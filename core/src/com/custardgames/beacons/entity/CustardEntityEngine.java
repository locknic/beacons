package com.custardgames.beacons.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class CustardEntityEngine extends Engine implements Disposable
{
	private Array<IteratingRenderSystem> renderSystems;
	private Array<CustardEntity> custardEntities;

	public CustardEntityEngine()
	{
		super();
		
		renderSystems = new Array<IteratingRenderSystem>();
		custardEntities = new Array<CustardEntity>();
	}
	
	public void addSystem(IteratingRenderSystem renderSystem)
	{
		super.addSystem(renderSystem);
		renderSystems.add(renderSystem);
	}
	
	public void addEntity(CustardEntity custardEntity)
	{
		super.addEntity(custardEntity);
		custardEntities.add(custardEntity);
	}
	
	public void render()
	{
		for (IteratingRenderSystem renderSystem : renderSystems)
		{
			renderSystem.render();
		}
	}
	
	@Override
	public void dispose()
	{
		for (CustardEntity custardEntity : custardEntities)
		{
			custardEntity.dispose();
		}
	}
}
