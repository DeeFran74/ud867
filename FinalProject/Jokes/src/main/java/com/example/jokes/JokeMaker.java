package com.example.jokes;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Makes use of https://icanhazdadjoke.com/api to fetch a random dad joke
// credit and thanks to them for the awesome API!

public class JokeMaker {

    public static Call<Joke> getJoke() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://icanhazdadjoke.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JokeService service = retrofit.create(JokeService.class);

        return service.dadJoke();
    }

}
