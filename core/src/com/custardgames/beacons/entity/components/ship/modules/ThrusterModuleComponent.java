package com.custardgames.beacons.entity.components.ship.modules;

import com.badlogic.ashley.core.Component;

public class ThrusterModuleComponent extends Component
{
	private float thrust;
	private boolean thrusting;
	private boolean turnedOn;
	private boolean thrustsForward, thrustsBackward, thrustsTurnLeft, thrustsTurnRight, thrustsStrafeLeft, thrustsStrafeRight;
	
	public ThrusterModuleComponent(float thrust)
	{
		this.thrust = thrust;
		this.thrusting = false;
		this.setTurnedOn(true);
	}

	public float getThrust()
	{
		return thrust;
	}

	public void setThrust(float thrust)
	{
		this.thrust = thrust;
	}

	public boolean isThrusting()
	{
		return thrusting;
	}

	public void setThrusting(boolean thrusting)
	{
		this.thrusting = thrusting;
	}

	public void setThrustDirections(boolean thrustsForward, boolean thrustsBackward, boolean thrustsTurnLeft, boolean thrustsTurnRight, boolean thrustsStrafeLeft, boolean thrustsStrafeRight)
	{
		this.thrustsForward = thrustsForward;
		this.thrustsBackward = thrustsBackward;
		this.thrustsTurnLeft = thrustsTurnLeft;
		this.thrustsTurnRight = thrustsTurnRight;
		this.thrustsStrafeLeft = thrustsStrafeLeft;
		this.thrustsStrafeRight = thrustsStrafeRight;
	}

	public boolean isThrustsForward()
	{
		return thrustsForward;
	}

	public boolean isThrustsBackward()
	{
		return thrustsBackward;
	}

	public boolean isThrustsTurnLeft()
	{
		return thrustsTurnLeft;
	}

	public boolean isThrustsTurnRight()
	{
		return thrustsTurnRight;
	}

	public boolean isThrustsStrafeLeft()
	{
		return thrustsStrafeLeft;
	}

	public boolean isThrustsStrafeRight()
	{
		return thrustsStrafeRight;
	}

	public void setThrustsForward(boolean thrustsForward)
	{
		this.thrustsForward = thrustsForward;
	}

	public void setThrustsBackward(boolean thrustsBackward)
	{
		this.thrustsBackward = thrustsBackward;
	}

	public void setThrustsTurnLeft(boolean thrustsTurnLeft)
	{
		this.thrustsTurnLeft = thrustsTurnLeft;
	}

	public void setThrustsTurnRight(boolean thrustsTurnRight)
	{
		this.thrustsTurnRight = thrustsTurnRight;
	}

	public void setThrustsStrafeLeft(boolean thrustsStrafeLeft)
	{
		this.thrustsStrafeLeft = thrustsStrafeLeft;
	}

	public void setThrustsStrafeRight(boolean thrustsStrafeRight)
	{
		this.thrustsStrafeRight = thrustsStrafeRight;
	}

	public boolean isTurnedOn()
	{
		return turnedOn;
	}

	public void setTurnedOn(boolean turnedOn)
	{
		this.turnedOn = turnedOn;
	}
}
