package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.Joke;
import com.example.jokes.JokeMaker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** serveJoke from JokeMaker API */
    @ApiMethod(name = "serveJoke")
    public MyBean serveJoke() {

        MyBean responseObject = new MyBean();

        String joke = JokeMaker.getJoke();

        responseObject.setData(joke);

        return responseObject;
    }

}
