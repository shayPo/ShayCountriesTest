package com.shay.test.countries.shaycountriestest.setup;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.shay.test.countries.shaycountriestest.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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

        onView(withText(R.string.loading)).check(matches(isDisplayed()));
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