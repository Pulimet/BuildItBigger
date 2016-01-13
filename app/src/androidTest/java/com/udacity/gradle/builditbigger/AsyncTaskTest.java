package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase {
    private static String testResult;

    public void testForGettingSomeResultFromServer() {

        final CountDownLatch signal = new CountDownLatch(1);


        new EndpointsAsyncTask().execute(new EndpointsAsyncTask.CallBack() {
            @Override
            public void onResult(String result) {
                testResult = result;
                signal.countDown();
            }
        });

        try {
            signal.await(5, TimeUnit.SECONDS);
            assertNotNull(testResult);
            assertEquals(testResult, "Some joke is here...");
//            assertEquals(testResult, "Some");
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }


    }
}
