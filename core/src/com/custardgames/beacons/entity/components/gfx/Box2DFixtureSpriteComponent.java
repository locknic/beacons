package com.custardgames.beacons.entity.components.gfx;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import com.badlogic.ashley.core.Component;

public class Box2DFixtureSpriteComponent extends Component
{
	private Box2DSprite sprite;
	
	public Box2DFixtureSpriteComponent(Box2DSprite sprite)
	{
		this.setSprite(sprite);
	}

	public Box2DSprite getSprite()
	{
		return sprite;
	}

	public void setSprite(Box2DSprite sprite)
	{
		this.sprite = sprite;
	}
}
