package com.custardgames.beacons.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;

public abstract class IteratingRenderSystem extends IteratingSystem
{
	private Family renderableFamily;
	private ImmutableArray<Entity> renderableQueue;

	public IteratingRenderSystem(Family rendererFamily, Family renderableFamily)
	{
		super(rendererFamily);
		
		this.renderableFamily = renderableFamily;
	}

	@Override
	public void addedToEngine(Engine engine)
	{
		super.addedToEngine(engine);

		renderableQueue = engine.getEntitiesFor(renderableFamily);
	}

	public void render()
	{
		ImmutableArray<Entity> entities = getEntities();

		for (int x = 0; x < entities.size(); x++)
		{
			Entity renderer = entities.get(x);

			renderRenderer(renderer);
		}
	}

	protected ImmutableArray<Entity> getRenderableEntities()
	{
		return renderableQueue;
	}

	protected abstract void renderRenderer(Entity renderer);

}
