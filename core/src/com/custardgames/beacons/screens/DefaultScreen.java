package com.custardgames.beacons.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.custardgames.beacons.Core;

public abstract class DefaultScreen implements Screen
{
	protected Core chokudori;
	
	protected OrthographicCamera camera;
	
	public DefaultScreen (Core chokudori)
	{
		this.chokudori = chokudori;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, chokudori.getConfig().getInteger("screenWidth", 1280), chokudori.getConfig().getInteger("screenHeight", 720));
	}
	
	@Override
	public void resize(int width, int height)
	{
//		camera.viewportWidth = width;
//		camera.viewportHeight = height;
//		camera.update();
	}
}
