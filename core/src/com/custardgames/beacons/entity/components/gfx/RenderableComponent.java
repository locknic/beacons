package com.custardgames.beacons.entity.components.gfx;

import com.badlogic.ashley.core.Component;

public class RenderableComponent extends Component
{
	private boolean draw;
	
	public RenderableComponent()
	{
		setDraw(true);
	}

	public boolean isDraw()
	{
		return draw;
	}

	public void setDraw(boolean draw)
	{
		this.draw = draw;
	}
}
