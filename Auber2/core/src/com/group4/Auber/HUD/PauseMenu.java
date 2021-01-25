package com.group4.Auber.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.group4.Auber.*;

public class PauseMenu {

    private AuberGame game;
    public Stage stage;

    private GameScreen screen;

    /**
     * The sound made when the user selects a button
     */
    private final Sound menuSelect = Gdx.audio.newSound(Gdx.files.internal("audio/menuSelect.ogg"));


    public PauseMenu(AuberGame game){
        this.game = game;

        setup();
    }

    public void setup() {

        //Create the stage and allow it to process inputs. Using an Extend Viewport for scalablity of the product
        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));

        //Create the table and expand it to fill the window
        Table table = new Table();
        table.setFillParent(true);

        //Create the logo and add it to the table
        Texture logoTexture = new Texture(Gdx.files.internal("img/menu/auberLogo.png"));
        Image logo = new Image(logoTexture);
        table.add(logo).pad(10).fillY().align(Align.center);
        table.row();

        //Create the start game button, add it to the table with its click event
        ImageButton.ImageButtonStyle playStyle = new ImageButton.ImageButtonStyle();
        playStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/playButtonInactive.png"))));
        playStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/playButtonActive.png"))));
        playStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/playButtonActive.png"))));
        ImageButton playButton = new ImageButton(playStyle);
        table.add(playButton).center().pad(5);
        table.row();

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //As per libGDX docs this is needed to return true for the touchup event to trigger
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                menuSelect.play(0.2f);
                game.setScreen(new GameScreen(game));
            }
        });

        //Create the menu button, add it to the table with its click event
        ImageButton.ImageButtonStyle menuStyle = new ImageButton.ImageButtonStyle();
        menuStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/menuButtonInactive.png"))));
        menuStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/menuButtonActive.png"))));
        menuStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/menu/menuButtonActive.png"))));
        ImageButton quitButton = new ImageButton(menuStyle);
        table.add(quitButton).center().pad(5);
        table.row();

        quitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //As per libGDX docs this is needed to return true for the touchup event to trigger
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                menuSelect.play(0.2f);
                game.setScreen(new TitleScreen(game, false));
            }
        });

        stage.addActor(table);
    }

    public void on(){
        Gdx.input.setInputProcessor(stage);
    }

    public void draw(float delta){
        stage.act(delta);
        stage.draw();
    }
}
