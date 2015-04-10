package com.custardgames.beacons.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CustardCamera extends OrthographicCamera
{
	public float angle;
	
	@Override
	public void rotate(float angle)
	{
		super.rotate(angle);
		this.angle += angle;
	}
	
	public void setRotation(float angle)
	{
		System.out.println("Current rotation: " + this.angle);
		rotate(-this.angle);
		System.out.println("Now: " + this.angle);
		rotate(angle);
		System.out.println("New rotation: " + this.angle);
	}
}
