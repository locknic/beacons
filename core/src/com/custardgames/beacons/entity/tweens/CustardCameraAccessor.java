package com.custardgames.beacons.entity.tweens;

import aurelienribon.tweenengine.TweenAccessor;

import com.custardgames.beacons.utils.CustardCamera;

public class CustardCameraAccessor implements TweenAccessor<CustardCamera>
{
	public static final int POSITION_X = 1;
	public static final int POSITION_Y = 2;
	public static final int POSITION = 3;
	public static final int ROTATION = 4;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 6;
	public static final int SIZE = 7;
	public static final int ZOOM = 8;

	@Override
	public int getValues(CustardCamera target, int tweenType, float[] returnValues)
	{
		switch (tweenType)
		{
		case POSITION_X:
			returnValues[0] = target.position.x;
			return 1;
		case POSITION_Y:
			returnValues[0] = target.position.y;
			return 1;
		case POSITION:
			returnValues[0] = target.position.x;
			returnValues[1] = target.position.y;
			return 2;
		case ROTATION:
			returnValues[0] = target.angle;
			return 1;
		case WIDTH:
			returnValues[0] = target.viewportWidth;
			return 1;
		case HEIGHT:
			returnValues[0] = target.viewportHeight;
			return 1;
		case SIZE:
			returnValues[0] = target.viewportWidth;
			returnValues[1] = target.viewportHeight;
			return 2;
		case ZOOM:
			returnValues[0] = target.zoom;
			return 1;
		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(CustardCamera target, int tweenType, float[] newValues)
	{
		switch (tweenType)
		{
		case POSITION_X:
			target.position.x = newValues[0];
			target.update();
			break;
		case POSITION_Y:
			target.position.y = newValues[0];
			target.update();
			break;
		case POSITION:
			target.position.x = newValues[0];
			target.position.y = newValues[1];
			target.update();
			break;
		case ROTATION:
			target.setRotation(newValues[0]);
			target.update();
			break;
		case WIDTH:
			target.viewportWidth = newValues[0];
			target.update();
			break;
		case HEIGHT:
			target.viewportHeight = newValues[0];
			target.update();
			break;
		case SIZE:
			target.viewportWidth = newValues[0];
			target.viewportHeight = newValues[1];
			target.update();
			break;
		case ZOOM:
			target.zoom = newValues[0];
			target.update();
			break;
		default:
			assert false;
			break;
		}

	}

}
