package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

public class ParentShipEntityComponent extends Component
{
	private Entity entity;

	public ParentShipEntityComponent(Entity entity)
	{
		this.setEntity(entity);
	}

	public Entity getEntity()
	{
		return entity;
	}

	public void setEntity(Entity entity)
	{
		this.entity = entity;
	}
	
	
}
