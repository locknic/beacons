package com.custardgames.beacons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.custardgames.beacons.screens.SplashScreen;

public class Core extends Game
{
	private SpriteBatch spriteBatch;
	private AssetManager assetManager;
	private Preferences config;

	@Override
	public void create()
	{
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
		config = Gdx.app.getPreferences("config");
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();
	}

	@Override
	public void dispose()
	{
		// TODO Fix disposing pipeline to stop crashing
		
		// super.dispose();
		//
		// spriteBatch.dispose();
		// assetManager.dispose();
	}

	public SpriteBatch getSpriteBatch()
	{
		return spriteBatch;
	}

	public AssetManager getAssetManager()
	{
		return assetManager;
	}

	public Preferences getConfig()
	{
		return config;
	}
}
