package com.custardgames.beacons.entity.systems.gfx;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.custardgames.beacons.entity.IteratingRenderSystem;
import com.custardgames.beacons.entity.components.Box2DFixtureComponent;
import com.custardgames.beacons.entity.components.CustardCameraComponent;
import com.custardgames.beacons.entity.components.gfx.Box2DFixtureSpriteComponent;
import com.custardgames.beacons.entity.components.gfx.RenderableComponent;
import com.custardgames.beacons.entity.components.gfx.SpriteBatchComponent;

public class Box2DFixtureRenderSystem extends IteratingRenderSystem
{
	private ComponentMapper<SpriteBatchComponent> spriteBatchComponents;
	private ComponentMapper<CustardCameraComponent> orthographicCameraComponents;
	
	private ComponentMapper<Box2DFixtureSpriteComponent> box2DFixtureSpriteComponents;
	private ComponentMapper<Box2DFixtureComponent> box2DFixtureComponents;
	private ComponentMapper<RenderableComponent> renderableComponents;
	
	@SuppressWarnings("unchecked")
	public Box2DFixtureRenderSystem()
	{
		super(Family.getFor(SpriteBatchComponent.class, CustardCameraComponent.class), Family.getFor(Box2DFixtureSpriteComponent.class, RenderableComponent.class));
		
		spriteBatchComponents = ComponentMapper.getFor(SpriteBatchComponent.class);
		orthographicCameraComponents = ComponentMapper.getFor(CustardCameraComponent.class);
		
		box2DFixtureSpriteComponents = ComponentMapper.getFor(Box2DFixtureSpriteComponent.class);
		box2DFixtureComponents = ComponentMapper.getFor(Box2DFixtureComponent.class);
		renderableComponents = ComponentMapper.getFor(RenderableComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		
	}
	
	@Override
	protected void renderRenderer(Entity renderer)
	{
		SpriteBatchComponent spriteBatchComponent = spriteBatchComponents.get(renderer);
		CustardCameraComponent orthographicCameraComponent = orthographicCameraComponents.get(renderer);
		
		SpriteBatch spriteBatch = spriteBatchComponent.getSpriteBatch();
		OrthographicCamera camera = orthographicCameraComponent.getCamera();
		
		spriteBatch.setProjectionMatrix(camera.combined);
		
		spriteBatch.begin();
		ImmutableArray<Entity> renderableQueue = getRenderableEntities();
		for (int y = 0; y < renderableQueue.size(); y++)
		{
			Entity renderable = renderableQueue.get(y);
			Box2DFixtureSpriteComponent box2DFixtureSpriteComponent = box2DFixtureSpriteComponents.get(renderable);
			Box2DFixtureComponent box2DFixtureComponent = box2DFixtureComponents.get(renderable);
			RenderableComponent renderableComponent = renderableComponents.get(renderable);
			
			if (renderableComponent.isDraw())
			{
				Box2DSprite box2DSprite = box2DFixtureSpriteComponent.getSprite();
				Fixture box2DFixture = box2DFixtureComponent.getFixture();
				box2DSprite.draw(spriteBatch, box2DFixture);
			}
		}
		spriteBatch.end();
	}

}
