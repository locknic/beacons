package com.custardgames.beacons.entity.systems.ship;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.custardgames.beacons.entity.components.ship.ShipThrusterComponent;
import com.custardgames.beacons.entity.components.ship.ShipThrusterInputComponent;
import com.custardgames.beacons.entity.components.ship.modules.ThrusterModuleComponent;

public class ShipThrusterSystem extends IteratingSystem
{
	private ComponentMapper<ShipThrusterComponent> shipThrusterComponents;
	private ComponentMapper<ShipThrusterInputComponent> shipThrusterInputComponents;

	// Thruster entities
	private ComponentMapper<ThrusterModuleComponent> thrusterModuleComponents;

	@SuppressWarnings("unchecked")
	public ShipThrusterSystem()
	{
		super(Family.getFor(ShipThrusterComponent.class, ShipThrusterInputComponent.class));

		shipThrusterComponents = ComponentMapper.getFor(ShipThrusterComponent.class);
		shipThrusterInputComponents = ComponentMapper.getFor(ShipThrusterInputComponent.class);

		thrusterModuleComponents = ComponentMapper.getFor(ThrusterModuleComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		ShipThrusterComponent shipThrusterComponent = shipThrusterComponents.get(entity);
		ShipThrusterInputComponent shipThrusterInputComponent = shipThrusterInputComponents.get(entity);
		
		for (Entity thrusterEntity : shipThrusterComponent.getShipThrusterEntities())
		{
			ThrusterModuleComponent thrusterModuleComponent = thrusterModuleComponents.get(thrusterEntity);
						
			if (shipThrusterInputComponent.isForward() && thrusterModuleComponent.isThrustsForward())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else if (shipThrusterInputComponent.isBackward() && thrusterModuleComponent.isThrustsBackward())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else if (shipThrusterInputComponent.isTurnLeft() && thrusterModuleComponent.isThrustsTurnLeft())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else if (shipThrusterInputComponent.isTurnRight() && thrusterModuleComponent.isThrustsTurnRight())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else if (shipThrusterInputComponent.isStrafeLeft() && thrusterModuleComponent.isThrustsStrafeLeft())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else if (shipThrusterInputComponent.isStrafeRight() && thrusterModuleComponent.isThrustsStrafeRight())
			{
				thrusterModuleComponent.setThrusting(true);
			}
			else
			{
				thrusterModuleComponent.setThrusting(false);
			}
		}
	}
}
