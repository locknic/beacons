package com.custardgames.beacons.entity.systems.ship.modules;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.ParentShipEntityComponent;
import com.custardgames.beacons.entity.components.ship.ShipThrusterInputComponent;
import com.custardgames.beacons.entity.components.ship.modules.AngularDampeningModuleComponent;

public class AngularDampeningModuleSystem extends IteratingSystem
{
	private ComponentMapper<ParentShipEntityComponent> parentShipEntityComponents;
	private ComponentMapper<AngularDampeningModuleComponent> angularDampeningModuleComponents;
	
	// Parent ship's input
	private ComponentMapper<ShipThrusterInputComponent> parentShipThrusterInputComponents;
	
	@SuppressWarnings("unchecked")
	public AngularDampeningModuleSystem()
	{
		super(Family.getFor(ParentShipEntityComponent.class, AngularDampeningModuleComponent.class, Box2DBodyComponent.class));
		
		parentShipEntityComponents = ComponentMapper.getFor(ParentShipEntityComponent.class);
		angularDampeningModuleComponents = ComponentMapper.getFor(AngularDampeningModuleComponent.class);
		
		parentShipThrusterInputComponents = ComponentMapper.getFor(ShipThrusterInputComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		ParentShipEntityComponent parentShipEntityComponent = parentShipEntityComponents.get(entity);
		AngularDampeningModuleComponent angularDampeningModuleComponent = angularDampeningModuleComponents.get(entity);
		
		ShipThrusterInputComponent parentShipThrusterInputComponent = parentShipThrusterInputComponents.get(parentShipEntityComponent.getEntity());
		
		if (angularDampeningModuleComponent.isTurnedOn() && !parentShipThrusterInputComponent.isTurnLeft() && !parentShipThrusterInputComponent.isTurnRight())
		{
			angularDampeningModuleComponent.setOn(true);
		}
		else
		{
			angularDampeningModuleComponent.setOn(false);
		}
	}
	
}
