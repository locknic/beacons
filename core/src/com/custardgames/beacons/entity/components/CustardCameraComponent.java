package com.custardgames.beacons.entity.components;

import com.badlogic.ashley.core.Component;
import com.custardgames.beacons.utils.CustardCamera;

public class CustardCameraComponent extends Component
{
	private CustardCamera camera;
	
	public CustardCameraComponent(CustardCamera camera)
	{
		this.setCamera(camera);
	}

	public CustardCamera getCamera()
	{
		return camera;
	}

	public void setCamera(CustardCamera camera)
	{
		this.camera = camera;
	}
}
