package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.alexandroid.androidlibrary.JokeShowActivity;

public class MainActivity extends AppCompatActivity {

    private String joke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getJokeFromServer(View view) {
        new EndpointsAsyncTask().execute(mCallBack);
    }

    EndpointsAsyncTask.CallBack mCallBack = new EndpointsAsyncTask.CallBack() {
        @Override
        public void onResult(String result) {
            joke = result;
            startJokeShowActivity();
        }
    };

    private void startJokeShowActivity() {
        Intent intent = new Intent(this, JokeShowActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, joke);
        startActivity(intent);
    }

}
