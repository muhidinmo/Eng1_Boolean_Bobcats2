package com.group4.Auber.Video;

import java.io.FileNotFoundException;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Null;

public interface VideoPlayer extends Disposable{

    interface VideoSizeListener {
        void onVideoSize (float width, float height);
    }

    interface CompletionListener {
        void onCompletionListener (FileHandle file);
    }

    boolean play (FileHandle file) throws FileNotFoundException;

    boolean update();

    @Null
    Texture getTexture();

    boolean isBuffered();

    void pause();

    void resume();

    void stop();

    void setOnVideoSizeListener (VideoSizeListener listener);

    void setOnCompletionListener(CompletionListener listener);

    int getVideoWidth();

    int getVideoHeight();

    boolean isPlaying();

    int getCurrentTimestamp();

    @Override
    void dispose();

    void setVolume(float volume);

    float getVolume();

    void setLooping(boolean looping);

    boolean isLooping();

}
