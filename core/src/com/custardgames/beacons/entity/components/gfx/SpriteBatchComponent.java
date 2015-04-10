package com.custardgames.beacons.entity.components.gfx;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteBatchComponent extends Component
{
	private SpriteBatch spriteBatch;
	
	public SpriteBatchComponent(SpriteBatch spriteBatch)
	{
		this.setSpriteBatch(spriteBatch);
	}

	public SpriteBatch getSpriteBatch()
	{
		return spriteBatch;
	}

	public void setSpriteBatch(SpriteBatch spriteBatch)
	{
		this.spriteBatch = spriteBatch;
	}
}
