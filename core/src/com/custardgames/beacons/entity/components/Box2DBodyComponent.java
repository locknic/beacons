package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class Box2DBodyComponent extends Component
{
	private Body body;
	
	public Box2DBodyComponent(Body body)
	{
		this.setBody(body);
	}

	public Body getBody()
	{
		return body;
	}

	public void setBody(Body body)
	{
		this.body = body;
	}
}
