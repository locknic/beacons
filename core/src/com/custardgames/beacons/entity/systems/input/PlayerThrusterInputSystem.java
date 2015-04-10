package com.custardgames.beacons.entity.systems.input;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.custardgames.beacons.entity.components.ship.ShipThrusterInputComponent;

public class PlayerThrusterInputSystem extends IteratingSystem
{
	private ComponentMapper<ShipThrusterInputComponent> shipThrusterInputComponents;
	
	@SuppressWarnings("unchecked")
	public PlayerThrusterInputSystem()
	{
		super(Family.getFor(ShipThrusterInputComponent.class));
		
		shipThrusterInputComponents = ComponentMapper.getFor(ShipThrusterInputComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		ShipThrusterInputComponent shipThrusterInputComponent = shipThrusterInputComponents.get(entity);
		
		if (Gdx.input.isKeyPressed(Keys.W))
		{
			shipThrusterInputComponent.setForward(true);
		}
		else
		{
			shipThrusterInputComponent.setForward(false);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S))
		{
			shipThrusterInputComponent.setBackward(true);
		}
		else
		{
			shipThrusterInputComponent.setBackward(false);
		}
		
		if (Gdx.input.isKeyPressed(Keys.A))
		{
			shipThrusterInputComponent.setTurnLeft(true);
		}
		else
		{
			shipThrusterInputComponent.setTurnLeft(false);
		}
		
		if (Gdx.input.isKeyPressed(Keys.D))
		{
			shipThrusterInputComponent.setTurnRight(true);
		}
		else
		{
			shipThrusterInputComponent.setTurnRight(false);
		}
		
		if (Gdx.input.isKeyPressed(Keys.Q))
		{
			shipThrusterInputComponent.setStrafeLeft(true);
		}
		else
		{
			shipThrusterInputComponent.setStrafeLeft(false);
		}
		
		if (Gdx.input.isKeyPressed(Keys.E))
		{
			shipThrusterInputComponent.setStrafeRight(true);
		}
		else
		{
			shipThrusterInputComponent.setStrafeRight(false);
		}
	}

}
