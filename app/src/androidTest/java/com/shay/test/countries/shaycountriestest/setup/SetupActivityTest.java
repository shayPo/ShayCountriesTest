package com.shay.test.countries.shaycountriestest.setup;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

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

    }

    @Test
    public void showRetry() throws Exception
    {

    }

    @Test
    public void onDestroy() throws Exception
    {

    }

}