package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;

public class Box2DRevoluteJointComponent extends Component
{
	private RevoluteJoint revoluteJoint;

	public Box2DRevoluteJointComponent(RevoluteJoint revoluteJoint)
	{
		this.setRevoluteJoint(revoluteJoint);
	}

	public RevoluteJoint getRevoluteJoint()
	{
		return revoluteJoint;
	}

	public void setRevoluteJoint(RevoluteJoint revoluteJoint)
	{
		this.revoluteJoint = revoluteJoint;
	}
	
	
}
