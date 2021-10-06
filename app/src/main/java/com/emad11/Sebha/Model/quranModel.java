package com.emad11.Sebha.Model;

public class quranModel {
    private final String surah_number;
    private final String verse_number;
    private final String content;

    public quranModel(String surah_number, String verse_number, String content) {
        this.surah_number = surah_number;
        this.verse_number = verse_number;
        this.content = content;
    }

    public String getSurah_number() {
        return surah_number;
    }

    public String getVerse_number() {
        return verse_number;
    }

    public String getContent() {
        return content;
    }
}
