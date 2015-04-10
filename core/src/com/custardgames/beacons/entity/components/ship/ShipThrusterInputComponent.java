package com.custardgames.beacons.entity.components.ship;

import com.badlogic.ashley.core.Component;

public class ShipThrusterInputComponent extends Component
{
	private boolean forward, backward, turnLeft, turnRight, strafeLeft, strafeRight;
	
	public ShipThrusterInputComponent()
	{
		forward = backward = turnLeft = turnRight = strafeLeft = strafeRight = false;
	}

	public boolean isForward()
	{
		return forward;
	}

	public boolean isBackward()
	{
		return backward;
	}

	public boolean isTurnLeft()
	{
		return turnLeft;
	}

	public boolean isTurnRight()
	{
		return turnRight;
	}

	public boolean isStrafeLeft()
	{
		return strafeLeft;
	}

	public boolean isStrafeRight()
	{
		return strafeRight;
	}

	public void setForward(boolean forward)
	{
		this.forward = forward;
	}

	public void setBackward(boolean backward)
	{
		this.backward = backward;
	}

	public void setTurnLeft(boolean turnsLeft)
	{
		this.turnLeft = turnsLeft;
	}

	public void setTurnRight(boolean turnRight)
	{
		this.turnRight = turnRight;
	}

	public void setStrafeLeft(boolean strafeLeft)
	{
		this.strafeLeft = strafeLeft;
	}

	public void setStrafeRight(boolean strafeRight)
	{
		this.strafeRight = strafeRight;
	}
	
	public boolean isMoving()
	{
		return forward || backward || turnLeft || turnRight || strafeLeft || strafeRight;
	}

	
}
