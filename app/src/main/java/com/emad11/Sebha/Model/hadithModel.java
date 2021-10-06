package com.emad11.Sebha.Model;

public class hadithModel {
    private final String text;
    private final String daraga;
    private final String source;

    public hadithModel(String text, String daraga, String source) {
        this.text = text;
        this.daraga = daraga;
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public String getDaraga() {
        return daraga;
    }

    public String getSource() {
        return source;
    }
}
