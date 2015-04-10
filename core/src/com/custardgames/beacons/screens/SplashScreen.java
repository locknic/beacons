package com.custardgames.beacons.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.custardgames.beacons.Core;



public class SplashScreen extends DefaultScreen
{
	Sprite backgroundSprite;
	
	public SplashScreen(Core chokudori)
	{
		super(chokudori);
	}

	@Override
	public void show()
	{
		setToConfig();
		AssetManager assetManager = chokudori.getAssetManager();
		assetManager.load("images/splashscreen.png", Texture.class);
		assetManager.finishLoading();
		backgroundSprite = new Sprite((Texture) assetManager.get("images/splashscreen.png"));
		backgroundSprite.setSize(camera.viewportWidth, camera.viewportHeight);
		chokudori.setScreen(new GameScreen(chokudori));
	}

	@Override
	public void render(float delta)
	{
		SpriteBatch spriteBatch = chokudori.getSpriteBatch();
		
		spriteBatch.begin();
		backgroundSprite.draw(spriteBatch);
		spriteBatch.end();
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
		AssetManager assetManager = chokudori.getAssetManager();
		assetManager.unload("images/splashscreen.png");
		
	}
	
	public void setToConfig()
	{
		Preferences config = chokudori.getConfig();
		if (config.getBoolean("firstRun", true))
		{
			createDefaultConfig();
		}
		else
		{
			Gdx.graphics.setDisplayMode(config.getInteger("screenWidth", 1280), config.getInteger("screenHeight", 720), config.getBoolean("fullscreen", false));
			Gdx.graphics.setVSync(config.getBoolean("vSync", false));
		}
	}
	
	public void createDefaultConfig()
	{
		Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode());
		Preferences config = chokudori.getConfig();
		config.putBoolean("firstRun", false);
		config.putInteger("screenWidth", Gdx.graphics.getWidth());
		config.putInteger("screenHeight", Gdx.graphics.getHeight());
		config.putBoolean("vSync", false);
		config.putBoolean("fullscreen", false);
		config.flush();
	}

}
