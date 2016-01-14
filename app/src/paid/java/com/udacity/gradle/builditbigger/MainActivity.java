package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import net.alexandroid.androidlibrary.JokeShowActivity;

public class MainActivity extends AppCompatActivity {

    private String joke;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void getJokeFromServer(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(mCallBack);
    }

    EndpointsAsyncTask.CallBack mCallBack = new EndpointsAsyncTask.CallBack() {
        @Override
        public void onResult(String result) {
            joke = result;
            mProgressBar.setVisibility(View.GONE);
            startJokeShowActivity();
        }
    };

    private void startJokeShowActivity() {
        Intent intent = new Intent(this, JokeShowActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, joke);
        startActivity(intent);
    }

}
