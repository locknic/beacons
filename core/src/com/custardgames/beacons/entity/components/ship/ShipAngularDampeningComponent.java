package com.custardgames.beacons.entity.components.ship;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;
import com.custardgames.beacons.entity.components.ship.modules.AngularDampeningModuleComponent;

public class ShipAngularDampeningComponent extends Component
{
	private Array<AngularDampeningModuleComponent> dampeners;
	
	public ShipAngularDampeningComponent()
	{
		this.setDampeners(new Array<AngularDampeningModuleComponent>());
	}

	public Array<AngularDampeningModuleComponent> getDampeners()
	{
		return dampeners;
	}

	public void setDampeners(Array<AngularDampeningModuleComponent> dampeners)
	{
		this.dampeners = dampeners;
	}
	
	public void addDampener(AngularDampeningModuleComponent dampener)
	{
		this.dampeners.add(dampener);
	}
	
	public float getDampening()
	{
		float dampening = 0.0f;
		
		for (AngularDampeningModuleComponent dampener : dampeners)
		{
			if (dampener.isTurnedOn() && dampener.isOn())
			{
				dampening += dampener.getAngularDampening();
			}
		}
		
		return dampening;
	}
}
