package com.custardgames.beacons.entity.factories;

import net.dermetfan.gdx.graphics.g2d.Box2DSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.custardgames.beacons.entity.CustardEntity;
import com.custardgames.beacons.entity.components.Box2DBodyComponent;
import com.custardgames.beacons.entity.components.Box2DFixtureComponent;
import com.custardgames.beacons.entity.components.gfx.Box2DFixtureSpriteComponent;
import com.custardgames.beacons.entity.components.gfx.RenderableComponent;

public class Box2DBoxFactory
{
	public final static CustardEntity createBoxBodyEntity(World world, Vector2 position, float width, float height)
	{
		CustardEntity box = new CustardEntity();

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position);
		bodyDef.angle = 0;
		bodyDef.fixedRotation = false;
		bodyDef.angularDamping = 0.0f;
		bodyDef.linearDamping = 0.0f;
		Body body = world.createBody(bodyDef);
		body.setUserData(box);
		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape boxShape = new PolygonShape();
		boxShape.setAsBox(width, height);
		fixtureDef.shape = boxShape;
		fixtureDef.density = 1.0f;
		Fixture fixture = body.createFixture(fixtureDef);
		boxShape.dispose();		
		
		box.add(new Box2DBodyComponent(body));
		box.add(new Box2DFixtureComponent(fixture, 0, 0));
		box.add(new Box2DFixtureSpriteComponent(new Box2DSprite(new Sprite(new Texture(Gdx.files.internal("images/splashscreen.png"))))));
		box.add(new RenderableComponent());
		
		return box;
	}
	
	public final static CustardEntity createBoxFixtureEntity(World world, Body body, Vector2 position, float width, float height)
	{
		CustardEntity box = new CustardEntity();
		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape boxShape = new PolygonShape();
		boxShape.setAsBox(width, height, position, 0);
		fixtureDef.shape = boxShape;
		fixtureDef.density = 0.5f;
		Fixture fixture = body.createFixture(fixtureDef);
		boxShape.dispose();		
		
		box.add(new Box2DBodyComponent(body));
		box.add(new Box2DFixtureComponent(fixture, position.x, position.y));
		box.add(new Box2DFixtureSpriteComponent(new Box2DSprite(new Sprite(new Texture(Gdx.files.internal("images/splashscreen.png"))))));
		box.add(new RenderableComponent());
		
		return box;
	}
}
