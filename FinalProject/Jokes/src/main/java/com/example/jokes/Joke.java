package com.example.jokes;

public class Joke {
    String id;
    String joke;
    int status;

    public Joke(String id, String joke, int status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    public String getJoke() {
        return joke;
    }
}
