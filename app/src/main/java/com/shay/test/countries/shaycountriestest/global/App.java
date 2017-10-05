package com.shay.test.countries.shaycountriestest.global;

import android.app.Application;

/**
 * Created by Sahar on 05/10/2017.
 */

public class App extends Application
{
    private IGlobalPresenter mPresenter;
    private static App sInstance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mPresenter = new GlobalPresenterImpl();
        sInstance = this;
    }

    public static App getInstance()
    {
        return sInstance;
    }

    public IGlobalPresenter getPresenter()
    {
        return mPresenter;
    }
}
