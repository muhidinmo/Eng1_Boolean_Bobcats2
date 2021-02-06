package com.group4.Auber.Video;

import java.nio.ByteBuffer;

import com.badlogic.gdx.utils.Disposable;

public class VideoDecoder implements Disposable{

    private long nativePointer;

    public static class VideoDecoderBuffers{
        private ByteBuffer videoBuffer;
        private ByteBuffer audioBuffer;
        private int videoWidth;
        private int videoHeight;
        private int audioChannels;
        private int audioSampleRate;

        private VideoDecoderBuffers (ByteBuffer videoBuffer, ByteBuffer audioBuffer, int videoWidth, int videoHeight,
                                     int audioChannels, int audioSampleRate){
            this.videoBuffer = videoBuffer;
            this.audioBuffer = audioBuffer;
            this.videoWidth = videoWidth;
            this.videoHeight = videoHeight;
            this.audioChannels = audioChannels;
            this.audioSampleRate = audioSampleRate;
        }

        public ByteBuffer getAudioBuffer(){
            return audioBuffer;
        }

        public ByteBuffer getVideoBuffer(){
            return videoBuffer;
        }

        public int getAudioChannels(){
            return audioChannels;
        }

        public int getAudioSampleRate(){
            return audioSampleRate;
        }

        public int getVideoWidth(){
            return videoWidth;
        }

        public int getVideoHeight() {
            return videoHeight;
        }
    }

    public VideoDecoder(){
        if (!FfMpeg.isLoaded()) throw new IllegalStateException("The native libraries are not yet loaded!");
        nativePointer = init();
    }

    public void close(){
        disposeNative();
        nativePointer = 0;
    }

    @Override
    public void dispose(){
        close();
    }

    private native long init();

    public native VideoDecoderBuffers loadStream (Object decodingObject, String methodName)
        throws IllegalArgumentException, Exception;

    public native ByteBuffer nextVideoFrame();

    public native void updateAudioBuffer();

    public native double getCurrentFrameTimestamp();

    private native void disposeNative();

    public native boolean isBuffered();
}
