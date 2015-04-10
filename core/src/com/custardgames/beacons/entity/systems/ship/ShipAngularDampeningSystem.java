package com.custardgames.beacons.entity.systems.ship;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.ship.ShipAngularDampeningComponent;

public class ShipAngularDampeningSystem extends IteratingSystem
{
	private ComponentMapper<Box2DBodyComponent> box2DBodyComponents;
	private ComponentMapper<ShipAngularDampeningComponent> shipAngularDampeningComponents;
	
	@SuppressWarnings("unchecked")
	public ShipAngularDampeningSystem()
	{
		super(Family.getFor(Box2DBodyComponent.class, ShipAngularDampeningComponent.class));
		
		box2DBodyComponents = ComponentMapper.getFor(Box2DBodyComponent.class);
		shipAngularDampeningComponents = ComponentMapper.getFor(ShipAngularDampeningComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		Box2DBodyComponent box2DBodyComponent = box2DBodyComponents.get(entity);
		ShipAngularDampeningComponent shipAngularDampeningComponent = shipAngularDampeningComponents.get(entity);
		
		box2DBodyComponent.getBody().setAngularDamping(shipAngularDampeningComponent.getDampening());
	}

}
