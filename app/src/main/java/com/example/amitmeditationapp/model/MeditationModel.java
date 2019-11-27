package com.example.amitmeditationapp.model;

import java.io.Serializable;

public class MeditationModel implements Serializable {

    private String backgroundImage;
    private String audioUrl;

    public MeditationModel(String backgroundImage, String audioUrl) {
        this.backgroundImage = backgroundImage;
        this.audioUrl = audioUrl;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}
