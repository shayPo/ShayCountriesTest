package com.shay.test.countries.shaycountriestest.setup;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Sahar on 06/10/2017.
 */
public class SetupActivityTest
{
    @Rule
    public ActivityTestRule mRule = new ActivityTestRule(SetupActivity.class, true, false);

    @Test
    public void testView()
    {
        mRule.launchActivity(new Intent());
    }

    @Test
    public void hideProgress() throws Exception
    {
        Log.i("test", "2");


    }

    @Test
    public void showRetry() throws Exception
    {
        Log.i("test", "1");
    }

    @Test
    public void onDestroy() throws Exception
    {
        Log.i("test", "3");
    }

}