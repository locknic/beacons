package com.custardgames.beacons.entity.components.ship;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

public class ShipThrusterComponent extends Component
{
	private Array<Entity> shipThrusterEntities;
	
	public ShipThrusterComponent()
	{
		this.shipThrusterEntities = new Array<Entity>();
	}
	
	public ShipThrusterComponent(Array<Entity> shipThrusterEntities)
	{
		this();
		this.setShipThrusterEntities(shipThrusterEntities);
	}

	public Array<Entity> getShipThrusterEntities()
	{
		return shipThrusterEntities;
	}

	public void setShipThrusterEntities(Array<Entity> shipThrusterEntities)
	{
		this.shipThrusterEntities = shipThrusterEntities;
	}
	
	public void addShipThrusterEntity(Entity shipThrusterEntity)
	{
		this.shipThrusterEntities.add(shipThrusterEntity);
	}
}
