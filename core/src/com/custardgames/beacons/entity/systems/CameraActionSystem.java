package com.custardgames.beacons.entity.systems;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.custardgames.beacons.entity.components.CameraInputComponent;
import com.custardgames.beacons.entity.components.CameraMovementComponent;
import com.custardgames.beacons.entity.components.CustardCameraComponent;
import com.custardgames.beacons.entity.tweens.CustardCameraAccessor;
import com.custardgames.beacons.utils.CustardCamera;

public class CameraActionSystem extends IteratingSystem
{
	private ComponentMapper<CustardCameraComponent> custardCameraComponents;
	private ComponentMapper<CameraInputComponent> cameraInputComponents;
	private ComponentMapper<CameraMovementComponent> cameraMovementComponents;

	private TweenManager tweenManager;

	@SuppressWarnings("unchecked")
	public CameraActionSystem()
	{
		super(Family.getFor(CustardCameraComponent.class, CameraInputComponent.class, CameraMovementComponent.class));

		custardCameraComponents = ComponentMapper.getFor(CustardCameraComponent.class);
		cameraInputComponents = ComponentMapper.getFor(CameraInputComponent.class);
		cameraMovementComponents = ComponentMapper.getFor(CameraMovementComponent.class);

		tweenManager = new TweenManager();

		Tween.registerAccessor(CustardCamera.class, new CustardCameraAccessor());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		CustardCameraComponent custardCameraComponent = custardCameraComponents.get(entity);
		CameraInputComponent cameraInputComponent = cameraInputComponents.get(entity);
		CameraMovementComponent cameraMovementComponent = cameraMovementComponents.get(entity);

		CustardCamera camera = custardCameraComponent.getCamera();

		float panSpeed = cameraMovementComponent.getPanSpeed() * deltaTime;
		float rotationSpeed = cameraMovementComponent.getRotationSpeed() * deltaTime;
		float zoomSpeed = cameraMovementComponent.getZoomSpeed() * (camera.zoom / 1) * deltaTime;
		byte xDir = 0;
		byte yDir = 0;

		// TODO Remove direct call to input

		if (cameraInputComponent.isUp() || Gdx.input.isKeyPressed(Keys.UP))
		{
			yDir++;
		}
		if (cameraInputComponent.isDown() || Gdx.input.isKeyPressed(Keys.DOWN))
		{
			yDir--;
		}
		if (cameraInputComponent.isLeft() || Gdx.input.isKeyPressed(Keys.LEFT))
		{
			xDir--;
		}
		if (cameraInputComponent.isRight() || Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			xDir++;
		}

		if (xDir != 0 || yDir != 0)
		{
			Tween.set(camera, CustardCameraAccessor.POSITION).targetRelative(xDir * panSpeed, yDir * panSpeed).start(tweenManager);
		}

		if (cameraInputComponent.isRotateLeft() || Gdx.input.isKeyPressed(Keys.O))
		{
			Tween.set(camera, CustardCameraAccessor.ROTATION).targetRelative(rotationSpeed).start(tweenManager);
		}
		else if (cameraInputComponent.isRotateRight() || Gdx.input.isKeyPressed(Keys.P))
		{
			Tween.set(camera, CustardCameraAccessor.ROTATION).targetRelative(-rotationSpeed).start(tweenManager);
		}

		if (cameraInputComponent.isZoomIn() || Gdx.input.isKeyPressed(Keys.EQUALS))
		{
			Tween.set(camera, CustardCameraAccessor.ZOOM).targetRelative(-zoomSpeed).start(tweenManager);
		}
		else if (cameraInputComponent.isZoomOut() || Gdx.input.isKeyPressed(Keys.MINUS))
		{
			Tween.set(camera, CustardCameraAccessor.ZOOM).targetRelative(zoomSpeed).start(tweenManager);
		}

		if (cameraInputComponent.isReset() || Gdx.input.isKeyPressed(Keys.NUM_0))
		{
			Tween.set(camera, CustardCameraAccessor.POSITION).target(0.0f, 0.0f).start(tweenManager);
			Tween.set(camera, CustardCameraAccessor.ROTATION).target(0.0f).start(tweenManager);
			Tween.set(camera, CustardCameraAccessor.ZOOM).target(1.0f).start(tweenManager);
		}

		tweenManager.update(deltaTime);
	}

}
