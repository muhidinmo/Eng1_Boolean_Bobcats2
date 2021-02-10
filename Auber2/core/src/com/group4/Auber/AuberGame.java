package com.group4.Auber;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.group4.Auber.Screens.TitleScreen;


/**
 * AuberGame is responsible for handling multiple screens and provides some
 * helper methods for this purpose ({@link com.badlogic.gdx.Game#setScreen}),
 * alongside an implementation of {@link com.badlogic.gdx.Game} for use.
 *
 * @author Robert Watts
 * @author Bogdan Bodnariu-Lescinschi
 */
public class AuberGame extends Game {
//	public Screen screen;

	public SpriteBatch batch;
	public SpriteBatch mapSpriteBatch;
	Skin skin;

	@Override
	public void create () {
		batch = new SpriteBatch();
		mapSpriteBatch = new SpriteBatch();
		setScreen(new TitleScreen(this, false));
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

//	@Override
//	public void setScreen (Screen screen) {
//		if (this.screen != null) this.screen.hide();
//		this.screen = screen;
//		if (this.screen != null) {
//			this.screen.show();
//			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		}
//	}
//
//	@Override
//	public Screen getScreen () {
//		return this.screen;
//	}

}