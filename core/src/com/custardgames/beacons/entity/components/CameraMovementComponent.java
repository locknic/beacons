package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;

public class CameraMovementComponent extends Component
{
	private float panSpeed;
	private float rotationSpeed;
	private float zoomSpeed;
	
	public CameraMovementComponent(float panSpeed, float rotationSpeed, float zoomSpeed)
	{
		this.setPanSpeed(panSpeed);
		this.setRotationSpeed(rotationSpeed);
		this.setZoomSpeed(zoomSpeed);
	}

	public float getPanSpeed()
	{
		return panSpeed;
	}

	public void setPanSpeed(float panSpeed)
	{
		this.panSpeed = panSpeed;
	}

	public float getZoomSpeed()
	{
		return zoomSpeed;
	}

	public void setZoomSpeed(float zoomSpeed)
	{
		this.zoomSpeed = zoomSpeed;
	}

	public float getRotationSpeed()
	{
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed)
	{
		this.rotationSpeed = rotationSpeed;
	}
}
