package com.LykoS.Novellus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Land {
	Sprite sprite;
	float xPos;
	float yPos;
	String type;
	public Land(String s, Texture t, float x, float y) {
		this.sprite = new Sprite(t);
		xPos = x;
		yPos = y;
		type = s;
		updateObject();
		
	}
	public void updateObject() {
		sprite.setX(xPos);
		sprite.setY(yPos);
		sprite.setSize(100, 100);
	}
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
}