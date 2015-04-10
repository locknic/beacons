package com.custardgames.beacons.entity.components.ship.modules;

import com.badlogic.ashley.core.Component;

public class AngularDampeningModuleComponent extends Component
{
	private boolean turnedOn;
	private boolean on;
	private float angularDampening;
	
	public AngularDampeningModuleComponent(float angularDampening)
	{
		this.turnedOn = true;
		this.on = false;
		this.angularDampening = angularDampening;
	}

	public boolean isOn()
	{
		return on;
	}

	public float getAngularDampening()
	{
		return angularDampening;
	}

	public void setOn(boolean on)
	{
		this.on = on;
	}

	public void setAngularDampening(float angularDampening)
	{
		this.angularDampening = angularDampening;
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
