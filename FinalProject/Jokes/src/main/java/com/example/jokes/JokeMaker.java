package com.example.jokes;

// Makes use of https://icanhazdadjoke.com/api to fetch a random dad joke
// credit and thanks to them for the awesome API!


import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.*;

public class JokeMaker {

    public static final String jokesUrl = "https://icanhazdadjoke.com/";
    public static final String FAIL_STRING = "Failed to fetch joke";

    public static String getJoke() {

        String returnString = "";
        try {
            // Format URL request to API
            URL request = new URL(jokesUrl);
            HttpURLConnection connection = (HttpURLConnection) request.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept",  "application/json");
            connection.setRequestProperty("User-Agent", "My library / practice project (https://github.com/DeeFran74/ud867/tree/master/FinalProject");
            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.useDelimiter("\\Z").next();

            JSONObject jsonObject = new JSONObject(response);
            returnString = jsonObject.getString("joke");

            scanner.close();
            connection.disconnect();
            return returnString;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnString;

    }

}
