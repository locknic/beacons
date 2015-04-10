package com.custardgames.beacons.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class CustardEntity extends Entity implements Disposable
{
	Array<CustardComponent> custardComponents;
	
	public CustardEntity()
	{
		super();
		
		custardComponents = new Array<CustardComponent>();
	}
	
	public void addComponent(CustardComponent component)
	{
		super.add(component);
		
		custardComponents.add(component);
	}

	@Override
	public void dispose()
	{
		for (CustardComponent custardComponent : custardComponents)
		{
			custardComponent.dispose();
		}
	}

}
