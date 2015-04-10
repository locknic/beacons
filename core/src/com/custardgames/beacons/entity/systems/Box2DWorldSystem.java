package com.custardgames.beacons.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.custardgames.beacons.entity.components.Box2DWorldComponent;

public class Box2DWorldSystem extends IteratingSystem
{
	private ComponentMapper<Box2DWorldComponent> box2DWorldComponents;
	
	@SuppressWarnings("unchecked")
	public Box2DWorldSystem()
	{
		super(Family.getFor(Box2DWorldComponent.class));
		
		box2DWorldComponents = ComponentMapper.getFor(Box2DWorldComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		Box2DWorldComponent box2DWorldComponent = box2DWorldComponents.get(entity);
		
		box2DWorldComponent.getWorld().step(deltaTime, box2DWorldComponent.getVelocityIterations(), box2DWorldComponent.getPositionIterations());
	}
	
}
