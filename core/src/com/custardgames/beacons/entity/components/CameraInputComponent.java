package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;

public class CameraInputComponent extends Component
{
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean rotateLeft;
	private boolean rotateRight;
	private boolean zoomIn;
	private boolean zoomOut;
	private boolean reset;
	
	public CameraInputComponent()
	{
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
		this.rotateLeft = false;
		this.rotateRight = false;
		this.zoomIn = false;
		this.zoomOut = false;
		this.reset = false;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean down)
	{
		this.down = down;
	}

	public boolean isLeft()
	{
		return left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isRight()
	{
		return right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isZoomIn()
	{
		return zoomIn;
	}

	public void setZoomIn(boolean zoomIn)
	{
		this.zoomIn = zoomIn;
	}

	public boolean isZoomOut()
	{
		return zoomOut;
	}

	public void setZoomOut(boolean zoomOut)
	{
		this.zoomOut = zoomOut;
	}

	public boolean isReset()
	{
		return reset;
	}

	public void setReset(boolean reset)
	{
		this.reset = reset;
	}

	public boolean isRotateLeft()
	{
		return rotateLeft;
	}

	public void setRotateLeft(boolean rotateLeft)
	{
		this.rotateLeft = rotateLeft;
	}

	public boolean isRotateRight()
	{
		return rotateRight;
	}

	public void setRotateRight(boolean rotateRight)
	{
		this.rotateRight = rotateRight;
	}
}
