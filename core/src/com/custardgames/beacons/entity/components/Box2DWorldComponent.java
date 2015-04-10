package com.custardgames.beacons.entity.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.custardgames.beacons.entity.CustardComponent;

public class Box2DWorldComponent extends CustardComponent
{
	private World world;
	private int velocityIterations;
	private int positionIterations;
	
	public Box2DWorldComponent(Vector2 gravity, boolean doSleep, int velocityIterations, int positionIterations)
	{
		this.world = new World(gravity, doSleep);
		this.setVelocityIterations(velocityIterations);
		this.setPositionIterations(positionIterations);
	}
	
	public Box2DWorldComponent(World world, int velocityIterations, int positionIterations)
	{
		this.setWorld(world);
		this.setVelocityIterations(velocityIterations);
		this.setPositionIterations(positionIterations);
	}
	
	@Override
	public void dispose()
	{
		world.dispose();
	}

	public World getWorld()
	{
		return world;
	}

	public void setWorld(World world)
	{
		this.world = world;
	}

	public int getVelocityIterations()
	{
		return velocityIterations;
	}

	public void setVelocityIterations(int velocityIterations)
	{
		this.velocityIterations = velocityIterations;
	}

	public int getPositionIterations()
	{
		return positionIterations;
	}

	public void setPositionIterations(int positionIterations)
	{
		this.positionIterations = positionIterations;
	}

}
