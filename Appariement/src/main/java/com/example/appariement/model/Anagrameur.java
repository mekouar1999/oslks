package com.example.appariement.model;

public class Anagrameur {
    public Anagrameur(int id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    private int id;
    private String url;
    private String description;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
