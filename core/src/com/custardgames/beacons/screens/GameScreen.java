package com.custardgames.beacons.screens;

import com.badlogic.gdx.math.Vector2;
import com.custardgames.beacons.Core;
import com.custardgames.beacons.GameInstance;

public class GameScreen extends DefaultScreen
{
	private GameInstance gameInstance;

	public GameScreen(Core chokudori)
	{
		super(chokudori);
		this.gameInstance = new GameInstance();
		this.gameInstance.initGraphics(chokudori.getSpriteBatch(), new Vector2(0, 0), chokudori.getConfig().getInteger("screenWidth", 1280), chokudori.getConfig().getInteger("screenHeight", 720));
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta)
	{
		gameInstance.update(delta);
		gameInstance.render();
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Fix disposing causing crashes
		// this.gameInstance.dispose();
	}

}
