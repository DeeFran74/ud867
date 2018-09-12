package com.example.jokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JokeService {

    // Get a random dad joke with an empty call to the base URL
    @Headers({"User-Agent: Udacity Project (https://github.com/DeeFran74/ud867/tree/master/FinalProject)",
            "Accept: application/json"})
    @GET(".")
    Call<Joke> dadJoke();

}
