package com.group4.Auber.Video;

import java.io.FileNotFoundException;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Null;

public class VideoPlayerStub implements VideoPlayer {

    @Override
    public boolean play(FileHandle file) throws FileNotFoundException {
        return true;
    }

    @Override
    public boolean update(){
        return false;
    }

    @Override
    @Null
    public Texture getTexture(){
        return null;
    }

    @Override
    public boolean isBuffered(){
        return true;
    }

    @Override
    public void pause(){
    }

    @Override
    public void resume(){
    }

    @Override
    public void stop(){
    }

    @Override
    public void setOnVideoSizeListener (VideoSizeListener listener){
    }

    @Override
    public void setOnCompletionListener (CompletionListener listener){
    }

    @Override
    public int getVideoWidth(){
        return 0;
    }

    @Override
    public int getVideoHeight(){
        return 0;
    }

    @Override
    public boolean isPlaying(){
        return false;
    }

    @Override
    public int getCurrentTimestamp(){
        return 0;
    }

    @Override
    public void dispose(){
    }

    @Override
    public void setVolume(float volume){
    }

    @Override
    public float getVolume(){
        return 0;
    }

    @Override
    public void setLooping(boolean looping){
    }

    @Override
    public boolean isLooping(){
        return false;
    }
}
