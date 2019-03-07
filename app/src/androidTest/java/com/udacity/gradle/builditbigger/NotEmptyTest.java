package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import networkAPI.EndPoint;
import networkAPI.onJokeReceived;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NotEmptyTest {
    final CountDownLatch signal = new CountDownLatch(1);
    String mJoke;


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
   public void retrieveValidJokeTest() throws InterruptedException {
        EndPoint endPoint = new EndPoint();
        endPoint.execute(new onJokeReceived() {
            @Override
            public void OnJokeReceivedListener(String joke) {
                 mJoke = joke;
                signal.countDown();
            }
        });
       signal.await(10,TimeUnit.SECONDS);
       assertNotNull("joke is null",mJoke);
       assertFalse("joke is empty",mJoke.isEmpty());
    }
}
