package com.custardgames.beacons.entity.components.ship.module;

import com.badlogic.ashley.core.Component;

public class ModulePowerComponent extends Component
{
	private float maxPower;
	private float currentPower;

	public ModulePowerComponent(float maxPower)
	{
		this.maxPower = maxPower;
		this.setCurrentPower(maxPower);
	}

	public float getCurrentPower()
	{
		return currentPower;
	}

	public void setCurrentPower(float currentPower)
	{
		this.currentPower = currentPower;
	}

	public float getCurrentPowerPercentage()
	{
		return currentPower / maxPower;
	}

	public void setCurrentPowerPercentage(float percentage)
	{
		setCurrentPower(maxPower / (percentage / 100));
	}

}
