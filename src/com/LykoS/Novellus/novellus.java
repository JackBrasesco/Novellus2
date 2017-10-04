package com.LykoS.Novellus;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class novellus implements ApplicationListener {
	
	//Definitions
	SpriteBatch batch;
	ShapeRenderer sr;
	Object play, back,cardPlaceBorder;
	Texture carbon, background,PlayButton,PlayBackground,BackButton,VampireTxtr,CardPlaceBorder;
	public int GameState = 0;
	public int RoundState = 0;
	public int turnToggle = 0;
	Card vampire;

	@Override
	public void create() {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		carbon = new Texture(Gdx.files.internal("Assets/th.jpg"));
		CardPlaceBorder = new Texture(Gdx.files.internal("Assets/CardPlaceBorder.png"));
		BackButton = new Texture(Gdx.files.internal("Assets/BackArrow.png"));
		background = new Texture(Gdx.files.internal("Assets/NovellusBackground.png"));
		PlayButton = new Texture(Gdx.files.internal("Assets/PlayAIButton.png"));
		PlayBackground = new Texture(Gdx.files.internal("Assets/PlayBackground.png"));
		VampireTxtr = new Texture(Gdx.files.internal("Assets/Cards/Dark/Creatures/vampireCard.png"));
		play = new Object((Gdx.graphics.getWidth()/2) - 100,(Gdx.graphics.getHeight()/2) - 144, 200 ,266,PlayButton);
		back = new Object(5, 920,300,100,BackButton);
		cardPlaceBorder = new Object(300,200, 760,300,CardPlaceBorder);
		vampire = new Card( 400,400, VampireTxtr, 4, 3, "Drain");
	}

	@Override
	public void dispose() {
		sr.dispose();
		background.dispose();
		PlayButton.dispose();
		carbon.dispose();
		PlayBackground.dispose();
		BackButton.dispose();
		CardPlaceBorder.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render() {
		update();
		draw(batch);
	}


	public void update() {
		vampire.ClikNDrag();
		if(Gdx.input.isTouched()) {
			if(Clicked(play) == true) {
				GameState = 1;
			}
			if (Clicked(back) == true) {
				GameState = 0;
			}
		}
	}
	public boolean Clicked(Object ob) {
		if (MouseX() < ob.getRight() && MouseX() > ob.getLeft()) {
			if(MouseY() < ob.getTop() && MouseY() > ob.getBottom()) {
				return true;
			}
		}
		return false;
	}
	public int MouseX() {
		return Gdx.input.getX();
	}
	public int MouseY() {
		return Gdx.graphics.getHeight() - Gdx.input.getY();
	}

	private void draw(SpriteBatch batch) {
		batch.begin();
		if (GameState == 1) {
			batch.draw(PlayBackground, 0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			back.draw(batch);
			
			vampire.draw(batch);
			
		}
		if (GameState == 0) {
			batch.draw(background, 0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			play.draw(batch);
		}
		
		batch.end();
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		
	}
	

	
	
}