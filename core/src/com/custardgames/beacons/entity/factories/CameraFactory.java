package com.custardgames.beacons.entity.factories;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.custardgames.beacons.entity.CustardEntity;
import com.custardgames.beacons.entity.CustardEntityEngine;
import com.custardgames.beacons.entity.components.CameraInputComponent;
import com.custardgames.beacons.entity.components.CameraMovementComponent;
import com.custardgames.beacons.entity.components.CustardCameraComponent;
import com.custardgames.beacons.entity.components.gfx.Box2DDebugRendererComponent;
import com.custardgames.beacons.entity.components.gfx.SpriteBatchComponent;
import com.custardgames.beacons.utils.CustardCamera;

public class CameraFactory
{
	public void registerCameraEntity(CustardEntityEngine entityEngine, SpriteBatch spriteBatch, Vector2 position, float width, float height)
	{
		CustardCamera camera = new CustardCamera();
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.position.set(position, 0);
		camera.update();

		CustardEntity cameraEntity = new CustardEntity();
		cameraEntity.add(new CustardCameraComponent(camera));
		cameraEntity.add(new CameraInputComponent());
		cameraEntity.add(new CameraMovementComponent(100.0f, 45.0f, 1.0f));
		cameraEntity.add(new Box2DDebugRendererComponent(true, true, true, true, true, true, true));
		cameraEntity.add(new SpriteBatchComponent(spriteBatch));
		entityEngine.addEntity(cameraEntity);
	}
}
