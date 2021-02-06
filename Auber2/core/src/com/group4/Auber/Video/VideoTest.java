package com.group4.Auber.Video;

import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.group4.Auber.AuberGame;
import com.group4.Auber.TitleScreen;

import java.io.FileNotFoundException;

public class VideoTest extends ApplicationAdapter {

    AuberGame game;

    Stage stage;

    SpriteBatch batch;
    OrthographicCamera camera;
    VideoPlayer videoPlayer;

    private boolean initialized = false;

    @Override
    public void create(){
        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        videoPlayer = VideoPlayerCreator.createVideoPlayer();
        videoPlayer.setOnCompletionListener(new VideoPlayer.CompletionListener() {
            @Override
            public void onCompletionListener(FileHandle file) {
                Gdx.app.log("VideoTest", file.name() + "fully played.");
            }
        });
        videoPlayer.setOnVideoSizeListener(new VideoPlayer.VideoSizeListener() {
            @Override
            public void onVideoSize(float width, float height) {
                Gdx.app.log("VideoTest", "The video has a size of " + width + "x" + height + ".");
            }
        });
    }

    public void render(float delta){
        if (!initialized){
            try{
                videoPlayer.play(Gdx.files.internal("AuberTest.webm"));
            }catch (FileNotFoundException e){
                System.out.println("File not found");
            }
            initialized = true;
        }

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        videoPlayer.update();
        batch.begin();
        Texture frame = videoPlayer.getTexture();
        if (frame != null) batch.draw(frame, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            game.setScreen(new TitleScreen(game, false));
        }
    }

    @Override
    public void pause(){
        videoPlayer.pause();
    }

    @Override
    public void resume(){
        videoPlayer.resume();
    }

    public void dispose(){
        videoPlayer.dispose();
    }

}
