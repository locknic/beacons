package com.custardgames.beacons.entity.factories;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.custardgames.beacons.entity.CustardEntity;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.ship.module.ModulePowerComponent;
import com.custardgames.beacons.entity.components.ship.modules.ThrusterModuleComponent;

public class ShipThrusterFactory
{
	public final static CustardEntity createThrusterEntity(World world, Body owner, Vector2 position, float width, float height, float thrust)
	{
		CustardEntity thruster = Box2DBoxFactory.createBoxFixtureEntity(world, owner, position, width, height);
		thruster.add(new ThrusterModuleComponent(thrust));
		thruster.add(new Box2DBodyComponent(owner));
		thruster.add(new ModulePowerComponent(256));
		return thruster;
	}
	
	public final static Array<CustardEntity> createLeftBackThrustersEntity(World world, Body owner, Vector2 position, float width, float height, float forwardThrust, float backThrust, float sideThrust)
	{
		Array<CustardEntity> entities = new Array<CustardEntity>();
		
		CustardEntity forwardThruster = createThrusterEntity(world, owner, position, width, height, forwardThrust);
		forwardThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(true, false, false, true, false, false);
		entities.add(forwardThruster);

		position.x += 0.5f;
		CustardEntity backwardThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, -backThrust);
		backwardThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, true, true, false, false, false);
		position.x -= 0.5f;
		entities.add(backwardThruster);
		
		position.y += 0.5f;
		CustardEntity leftThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, sideThrust);
		leftThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, false, true, false, false, true);
		position.y -= 0.5f;
		entities.add(leftThruster);
		
		position.y -= 0.5f;
		CustardEntity rightThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, sideThrust);
		rightThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, false, false, true, true, false);
		position.y += 0.5f;
		entities.add(rightThruster);
		
		return entities;
	}
	
	public final static Array<CustardEntity> createRightBackThrustersEntity(World world, Body owner, Vector2 position, float width, float height, float forwardThrust, float backThrust, float sideThrust)
	{
		Array<CustardEntity> entities = new Array<CustardEntity>();

		CustardEntity forwardThruster = createThrusterEntity(world, owner, position, width, height, forwardThrust);
		forwardThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(true, false, true, false, false, false);
		entities.add(forwardThruster);

		position.x += 0.5f;
		CustardEntity backwardThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, -backThrust);
		backwardThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, true, false, true, false, false);
		position.x -= 0.5f;
		entities.add(backwardThruster);
		
		position.y += 0.5f;
		CustardEntity leftThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, sideThrust);
		leftThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, false, true, false, false, true);
		position.y -= 0.5f;
		entities.add(leftThruster);
		
		position.y -= 0.5f;
		CustardEntity rightThruster = createThrusterEntity(world, owner, position, width / 4, height / 4, sideThrust);
		rightThruster.getComponent(ThrusterModuleComponent.class).setThrustDirections(false, false, false, true, true, false);
		position.y += 0.5f;
		entities.add(rightThruster);
		
		return entities;
	}
}
