package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import net.alexandroid.androidlibrary.JokeShowActivity;

public class MainActivity extends AppCompatActivity {


    private String joke;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInterstitial();
    }

    private void setInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(mAdListener);
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    AdListener mAdListener = new AdListener() {
        @Override
        public void onAdClosed() {
            super.onAdClosed();
            startJokeShowActivity();
        }

        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Log.d("ZAQ", "Interstitial Ad is loaded!");
        }
    };

    public void getJokeFromServer(View view) {
        new EndpointsAsyncTask().execute(mCallBack);
    }

    EndpointsAsyncTask.CallBack mCallBack = new EndpointsAsyncTask.CallBack() {
        @Override
        public void onResult(String result) {
            joke = result;
            showJoke();
        }
    };

    private void showJoke() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            startJokeShowActivity();
        }
    }


    private void startJokeShowActivity() {
        Intent intent = new Intent(this, JokeShowActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, joke);
        startActivity(intent);
    }

}
