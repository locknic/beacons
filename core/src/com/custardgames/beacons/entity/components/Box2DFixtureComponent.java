package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Box2DFixtureComponent extends Component
{
	private Fixture fixture;
	private float xCo, yCo;

	public Box2DFixtureComponent(Fixture fixture, float xCo, float yCo)
	{
		this.setFixture(fixture);
		this.xCo = xCo;
		this.yCo = yCo;
	}

	public Fixture getFixture()
	{
		return fixture;
	}

	public void setFixture(Fixture fixture)
	{
		this.fixture = fixture;
	}

	public float getxCo()
	{
		return xCo;
	}

	public float getyCo()
	{
		return yCo;
	}
}
