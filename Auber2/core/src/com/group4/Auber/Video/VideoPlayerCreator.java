package com.group4.Auber.Video;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class VideoPlayerCreator {

    private static Class<? extends VideoPlayer> videoPlayerClass;

    @Null
    public static VideoPlayer createVideoPlayer(){
        initialize();
        if (videoPlayerClass == null) return new VideoPlayerStub();
        try{
            return ClassReflection.newInstance(videoPlayerClass);
        } catch (ReflectionException e){
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static void initialize() {
        if (videoPlayerClass != null) return;

        String className = null;
        ApplicationType type = Gdx.app.getType();

        if (type == ApplicationType.Desktop){
            className = "com.group4.Auber.Video.VideoPlayerDesktop";
        }

        try {
            videoPlayerClass = ClassReflection.forName(className);
        } catch (ReflectionException e){
            e.printStackTrace();
        }
    }

}
