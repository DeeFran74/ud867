package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokes.Joke;
import com.example.jokes.JokeMaker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        // Get joke from Retrofit service
        Call<Joke> myJoke = JokeMaker.getJoke();

        myJoke.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                Toast.makeText(MainActivity.this, response.body().getJoke(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call to get joke failed :|", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
