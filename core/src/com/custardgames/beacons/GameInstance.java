package com.custardgames.beacons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.custardgames.beacons.entity.CustardEntity;
import com.custardgames.beacons.entity.CustardEntityEngine;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.Box2DWorldComponent;
import com.custardgames.beacons.entity.components.ParentShipEntityComponent;
import com.custardgames.beacons.entity.components.gfx.RenderableComponent;
import com.custardgames.beacons.entity.components.ship.ShipAngularDampeningComponent;
import com.custardgames.beacons.entity.components.ship.ShipThrusterComponent;
import com.custardgames.beacons.entity.components.ship.ShipThrusterInputComponent;
import com.custardgames.beacons.entity.components.ship.module.ModulePowerComponent;
import com.custardgames.beacons.entity.components.ship.modules.AngularDampeningModuleComponent;
import com.custardgames.beacons.entity.factories.Box2DBoxFactory;
import com.custardgames.beacons.entity.factories.CameraFactory;
import com.custardgames.beacons.entity.factories.ShipThrusterFactory;
import com.custardgames.beacons.entity.systems.Box2DWorldSystem;
import com.custardgames.beacons.entity.systems.CameraActionSystem;
import com.custardgames.beacons.entity.systems.gfx.Box2DDebugRenderSystem;
import com.custardgames.beacons.entity.systems.gfx.Box2DFixtureRenderSystem;
import com.custardgames.beacons.entity.systems.input.PlayerThrusterInputSystem;
import com.custardgames.beacons.entity.systems.ship.ShipAngularDampeningSystem;
import com.custardgames.beacons.entity.systems.ship.ShipThrusterSystem;
import com.custardgames.beacons.entity.systems.ship.modules.AngularDampeningModuleSystem;
import com.custardgames.beacons.entity.systems.ship.modules.ThrusterModuleSystem;

public class GameInstance
{
	private CustardEntityEngine entityEngine;

	public GameInstance()
	{
		entityEngine = new CustardEntityEngine();
		
		initPhysics();
		initInput();
		initLevel();
	}

	public void update(float deltaTime)
	{
		entityEngine.update(deltaTime);
	}

	public void render()
	{
		entityEngine.render();
	}

	public void dispose()
	{
		entityEngine.dispose();
	}
	
	public void initPhysics()
	{
		entityEngine.addSystem(new Box2DWorldSystem());
		entityEngine.addSystem(new CameraActionSystem());
		entityEngine.addSystem(new PlayerThrusterInputSystem());
		entityEngine.addSystem(new ShipThrusterSystem());
		entityEngine.addSystem(new ShipAngularDampeningSystem());
		entityEngine.addSystem(new ThrusterModuleSystem());
		entityEngine.addSystem(new AngularDampeningModuleSystem());
		
		World box2DWorld = null;
		
		box2DWorld = new World(new Vector2(0.0f, 0.0f), false);
		
		CustardEntity box2DWorldEntity = new CustardEntity();
		box2DWorldEntity.add(new Box2DWorldComponent(box2DWorld, 8, 3));
		box2DWorldEntity.add(new RenderableComponent());
		entityEngine.addEntity(box2DWorldEntity);

		CustardEntity shipEntity = Box2DBoxFactory.createBoxBodyEntity(box2DWorld, new Vector2(20.0f, 20.0f), 4.0f, 2.0f);
		shipEntity.add(new ShipThrusterInputComponent());
		shipEntity.add(new ShipThrusterComponent());
		shipEntity.add(new ShipAngularDampeningComponent());
		entityEngine.addEntity(shipEntity);
		
		Body shipBody = shipEntity.getComponent(Box2DBodyComponent.class).getBody();
		Array<CustardEntity> leftThrusterEntities = ShipThrusterFactory.createLeftBackThrustersEntity(box2DWorld, shipBody, new Vector2(-3.5f, -1f), 1.0f, 1.0f, 1000.0f, 500.0f, 250.0f); 
		for (CustardEntity thrusterEntity : leftThrusterEntities)
		{
			thrusterEntity.add(new ParentShipEntityComponent(shipEntity));
			entityEngine.addEntity(thrusterEntity);
			shipEntity.getComponent(ShipThrusterComponent.class).addShipThrusterEntity(thrusterEntity);
		}
		
		Array<CustardEntity> rightThrusterEntities = ShipThrusterFactory.createRightBackThrustersEntity(box2DWorld, shipBody, new Vector2(-3.5f, 1f), 1.0f, 1.0f, 1000.0f, 500.0f, 250.0f); 
		for (CustardEntity thrusterEntity : rightThrusterEntities)
		{
			thrusterEntity.add(new ParentShipEntityComponent(shipEntity));
			entityEngine.addEntity(thrusterEntity);
			shipEntity.getComponent(ShipThrusterComponent.class).addShipThrusterEntity(thrusterEntity);
		}
		
		CustardEntity angularDampeningEntity = new CustardEntity();
		angularDampeningEntity.add(new ParentShipEntityComponent(shipEntity));
		angularDampeningEntity.add(new Box2DBodyComponent(shipBody));
		angularDampeningEntity.add(new AngularDampeningModuleComponent(3));
		angularDampeningEntity.add(new ModulePowerComponent(128));
		shipEntity.getComponent(ShipAngularDampeningComponent.class).addDampener(angularDampeningEntity.getComponent(AngularDampeningModuleComponent.class));
		entityEngine.addEntity(angularDampeningEntity);		
	}
	
	public void initGraphics(SpriteBatch spriteBatch, Vector2 position, float width, float height)
	{
		entityEngine.addSystem(new Box2DFixtureRenderSystem());
		entityEngine.addSystem(new Box2DDebugRenderSystem());

		new CameraFactory().registerCameraEntity(entityEngine, spriteBatch, position, width, height);
	}
	
	public void initInput()
	{
		
	}
	
	public void initLevel()
	{
		
	}
}
