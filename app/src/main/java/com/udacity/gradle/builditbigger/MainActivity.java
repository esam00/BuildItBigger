package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.jokeandroidlibrary.DisplayJokeActivity;

import networkAPI.EndPoint;
import networkAPI.onJokeReceived;

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
        fetchJoke();
    }

    private void startJokeActivity(String joke){
        Intent mIntent = new Intent(MainActivity.this,DisplayJokeActivity.class);
        mIntent.putExtra("joke",joke);
        startActivity(mIntent);
    }

    private void fetchJoke(){
        new EndPoint().execute(new onJokeReceived() {
            @Override
            public void OnJokeReceivedListener(String joke) {
                String mJoke = joke;
                if(joke!=null) {
                    Log.d("log", joke);
                    startJokeActivity(mJoke);
                }
            }
        });
    }
}
