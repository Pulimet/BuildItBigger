package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.alexandroid.udacity.sample.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.CallBack, Void, String> {
    private static MyApi myApiService = null;
    private CallBack mCallBack;

    @Override
    protected String doInBackground(CallBack... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://gce-sample-project.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        mCallBack = params[0];

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mCallBack.onResult(result);
    }

    interface CallBack {
        void onResult(String result);
    }
}