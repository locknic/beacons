package com.custardgames.beacons.entity.systems.gfx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.custardgames.beacons.entity.IteratingRenderSystem;
import com.custardgames.beacons.entity.components.Box2DWorldComponent;
import com.custardgames.beacons.entity.components.CustardCameraComponent;
import com.custardgames.beacons.entity.components.gfx.Box2DDebugRendererComponent;
import com.custardgames.beacons.entity.components.gfx.RenderableComponent;

public class Box2DDebugRenderSystem extends IteratingRenderSystem
{
	private ComponentMapper<Box2DDebugRendererComponent> box2DDebugRendererComponents;
	private ComponentMapper<CustardCameraComponent> orthographicCameraComponents;
	
	private ComponentMapper<Box2DWorldComponent> box2DWorldComponents;
	private ComponentMapper<RenderableComponent> renderableComponents;
	
	@SuppressWarnings("unchecked")
	public Box2DDebugRenderSystem()
	{
		super(Family.getFor(Box2DDebugRendererComponent.class, CustardCameraComponent.class), Family.getFor(Box2DWorldComponent.class, RenderableComponent.class));
		
		box2DDebugRendererComponents = ComponentMapper.getFor(Box2DDebugRendererComponent.class);
		orthographicCameraComponents = ComponentMapper.getFor(CustardCameraComponent.class);
		
		box2DWorldComponents = ComponentMapper.getFor(Box2DWorldComponent.class);
		renderableComponents = ComponentMapper.getFor(RenderableComponent.class);
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void renderRenderer(Entity renderer)
	{
		Box2DDebugRendererComponent box2DDebugRendererComponent = box2DDebugRendererComponents.get(renderer);
		CustardCameraComponent orthographicCameraComponent = orthographicCameraComponents.get(renderer);
		
		if (box2DDebugRendererComponent.isDraw())
		{
			Box2DDebugRenderer box2DDebugRenderer = box2DDebugRendererComponent.getBox2DDebugRenderer();
			OrthographicCamera camera = orthographicCameraComponent.getCamera();
			
			ImmutableArray<Entity> renderableQueue = getRenderableEntities();
			for (int y = 0; y < renderableQueue.size(); y++)
			{
				Entity renderable = renderableQueue.get(y);
				Box2DWorldComponent box2DWorldComponent = box2DWorldComponents.get(renderable);
				RenderableComponent renderableComponent = renderableComponents.get(renderable);
				
				if (renderableComponent.isDraw())
				{
					World world = box2DWorldComponent.getWorld();
					box2DDebugRenderer.render(world, camera.combined);
				}
			}
			
		}
	}
	
}
