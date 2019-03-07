package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import networkAPI.EndPoint;
import networkAPI.onJokeReceived;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NotEmptyTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
   public void retrieveValidJokeTest(){
        EndPoint endPoint = new EndPoint();
        endPoint.execute(new onJokeReceived() {
            @Override
            public void OnJokeReceivedListener(String joke) {
                String mJoke = joke;
                assertNotEquals("", mJoke);
            }
        });
    }
}
