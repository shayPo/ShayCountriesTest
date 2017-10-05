package com.shay.test.countries.shaycountriestest.display;

import android.content.Context;

import com.shay.test.countries.shaycountriestest.R;

/**
 * Created by Sahar on 05/10/2017.
 */

public class DisplayPresenterImpl implements IDisplayPresenter
{
    private Stat mStat;
    private IDisplayView mView;
    private IDisplayInteractor mInteractor;
    private Context mCtx;

    public DisplayPresenterImpl(IDisplayView view, Context ctx)
    {
        mView = view;
        mCtx = ctx;
        mInteractor = new DisplayInteractorImpl();
    }

    @Override
    public void displayRegions()
    {
        mView.showTitle(mCtx.getString(R.string.regions_title));
    }
}
