package com.custardgames.beacons.entity.systems.ship.modules;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.Box2DFixtureComponent;
import com.custardgames.beacons.entity.components.ship.module.ModulePowerComponent;
import com.custardgames.beacons.entity.components.ship.modules.ThrusterModuleComponent;

public class ThrusterModuleSystem extends IteratingSystem
{
	private ComponentMapper<Box2DBodyComponent> box2DBodyComponents;
	private ComponentMapper<Box2DFixtureComponent> box2DFixtureComponents;
	private ComponentMapper<ThrusterModuleComponent> shipThrusterComponents;
	private ComponentMapper<ModulePowerComponent> modulePowerComponents;

	@SuppressWarnings("unchecked")
	public ThrusterModuleSystem()
	{
		super(Family.getFor(Box2DBodyComponent.class, Box2DFixtureComponent.class, ThrusterModuleComponent.class, ModulePowerComponent.class));

		box2DBodyComponents = ComponentMapper.getFor(Box2DBodyComponent.class);
		box2DFixtureComponents = ComponentMapper.getFor(Box2DFixtureComponent.class);
		shipThrusterComponents = ComponentMapper.getFor(ThrusterModuleComponent.class);
		modulePowerComponents = ComponentMapper.getFor(ModulePowerComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		Box2DBodyComponent box2DBodyComponent = box2DBodyComponents.get(entity);
		Box2DFixtureComponent box2DFixtureComponent = box2DFixtureComponents.get(entity);
		ThrusterModuleComponent shipThrusterComponent = shipThrusterComponents.get(entity);
		ModulePowerComponent modulePowerComponent = modulePowerComponents.get(entity);

		if (shipThrusterComponent.isThrusting())
		{
			Body body = box2DBodyComponent.getBody();
			float thrust = shipThrusterComponent.getThrust() * modulePowerComponent.getCurrentPowerPercentage();
			float cosAngle = (float) Math.cos(body.getAngle());
			float sinAngle = (float) Math.sin(body.getAngle());
			float thrustX = cosAngle * thrust;
			float thrustY = sinAngle * thrust;
			float offsetX = sinAngle * box2DFixtureComponent.getyCo() + cosAngle * box2DFixtureComponent.getxCo();
			float offsetY = sinAngle * box2DFixtureComponent.getxCo() - cosAngle * box2DFixtureComponent.getyCo();
			body.applyForce(thrustX, thrustY, body.getWorldCenter().x + offsetX, body.getWorldCenter().y + offsetY, true);
		}
	}

}
