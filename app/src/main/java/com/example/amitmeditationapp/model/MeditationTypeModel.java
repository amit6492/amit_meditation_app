package com.example.amitmeditationapp.model;

public class MeditationTypeModel {
    private String meditationTypes;
    private int backgroundColor;

    public MeditationTypeModel(String meditationTypes, int backgroundColor) {
        this.meditationTypes = meditationTypes;
        this.backgroundColor = backgroundColor;
    }

    public String getMeditationTypes() {
        return meditationTypes;
    }

    public void setMeditationTypes(String meditationTypes) {
        this.meditationTypes = meditationTypes;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
