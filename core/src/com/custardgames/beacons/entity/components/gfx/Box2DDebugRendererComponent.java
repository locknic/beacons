package com.custardgames.beacons.entity.components.gfx;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.custardgames.beacons.entity.CustardComponent;

public class Box2DDebugRendererComponent extends CustardComponent
{
	private Box2DDebugRenderer box2DDebugRenderer; 
	private boolean draw;
	private boolean drawBodies;
	private boolean drawJoints;
	private boolean drawAABBs;
	private boolean drawInactiveBodies;
	private boolean drawVelocities;
	private boolean drawContacts;
	
	public Box2DDebugRendererComponent()
	{
		this.box2DDebugRenderer = new Box2DDebugRenderer();
		this.draw = true;
		this.drawBodies = true;
		this.drawJoints = true;
		this.drawAABBs = false;
		this.drawInactiveBodies = true;
		this.drawVelocities = false;
		this.drawContacts = false;
	}
	
	public Box2DDebugRendererComponent(boolean draw, boolean drawBodies, boolean drawJoints, boolean drawAABBs, boolean drawInactiveBodies, boolean drawVelocities, boolean drawContacts)
	{
		this.box2DDebugRenderer = new Box2DDebugRenderer();
		this.draw = draw;
		this.drawBodies = drawBodies;
		this.drawJoints = drawJoints;
		this.drawAABBs = drawAABBs;
		this.drawInactiveBodies = drawInactiveBodies;
		this.drawVelocities = drawVelocities;
		this.drawContacts = drawContacts;
	}
	
	@Override
	public void dispose()
	{
		box2DDebugRenderer.dispose();
	}
	
	public void setBox2DDebugRendererSettings(Box2DDebugRenderer box2DDebugRenderer)
	{
		box2DDebugRenderer.setDrawBodies(drawBodies);
		box2DDebugRenderer.setDrawJoints(drawJoints);
		box2DDebugRenderer.setDrawAABBs(drawAABBs);
		box2DDebugRenderer.setDrawInactiveBodies(drawInactiveBodies);
		box2DDebugRenderer.setDrawVelocities(drawVelocities);
		box2DDebugRenderer.setDrawContacts(drawContacts);
	}

	public Box2DDebugRenderer getBox2DDebugRenderer()
	{
		setBox2DDebugRendererSettings(box2DDebugRenderer);
		return box2DDebugRenderer;
	}

	public void setBox2DDebugRenderer(Box2DDebugRenderer box2dDebugRenderer)
	{
		box2DDebugRenderer = box2dDebugRenderer;
	}

	public boolean isDraw()
	{
		return draw;
	}

	public void setDraw(boolean draw)
	{
		this.draw = draw;
	}

	public boolean isDrawBodies()
	{
		return drawBodies;
	}

	public void setDrawBodies(boolean drawBodies)
	{
		this.drawBodies = drawBodies;
	}

	public boolean isDrawJoints()
	{
		return drawJoints;
	}

	public void setDrawJoints(boolean drawJoints)
	{
		this.drawJoints = drawJoints;
	}

	public boolean isDrawAABBs()
	{
		return drawAABBs;
	}

	public void setDrawAABBs(boolean drawAABBs)
	{
		this.drawAABBs = drawAABBs;
	}

	public boolean isDrawInactiveBodies()
	{
		return drawInactiveBodies;
	}

	public void setDrawInactiveBodies(boolean drawInactiveBodies)
	{
		this.drawInactiveBodies = drawInactiveBodies;
	}

	public boolean isDrawVelocities()
	{
		return drawVelocities;
	}

	public void setDrawVelocities(boolean drawVelocities)
	{
		this.drawVelocities = drawVelocities;
	}

	public boolean isDrawContacts()
	{
		return drawContacts;
	}

	public void setDrawContacts(boolean drawContacts)
	{
		this.drawContacts = drawContacts;
	}

}
