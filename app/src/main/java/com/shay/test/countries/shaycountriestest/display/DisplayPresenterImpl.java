package com.shay.test.countries.shaycountriestest.display;

import android.content.Context;
import android.content.DialogInterface;

import com.shay.test.countries.shaycountriestest.R;
import com.shay.test.countries.shaycountriestest.display.adapters.CountriesAdapter;
import com.shay.test.countries.shaycountriestest.display.adapters.RegionsAdapter;
import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;

/**
 * Created by Shay on 05/10/2017.
 */

public class DisplayPresenterImpl implements IDisplayPresenter
{
    private Stat[] mStat;
    private int mCurrentStat;
    private IDisplayView mView;
    private IDisplayInteractor mInteractor;
    private Context mCtx;
    private Region mRegion;

    public DisplayPresenterImpl(IDisplayView view, Context ctx)
    {
        mView = view;
        mCtx = ctx;
        mStat = Stat.values();
        mCurrentStat = 0;
        mInteractor = new DisplayInteractorImpl();
        updateView(null);
    }

    @Override
    public void onDestroy()
    {
        mCtx = null;
        mView = null;
        mRegion = null;
    }

    private void updateView(Object data)
    {
        switch (mStat[mCurrentStat])
        {
            case REGIONS:
                displayRegions();
                break;
            case COUNTRIES:
                if (data != null)
                {
                    mRegion = (Region) data;
                }
                displayCountries();
                break;
            case COUNTRY:
                displayCountry(data);
                break;
        }
    }

    private void displayRegions()
    {
        mView.showTitle(mCtx.getString(R.string.regions_title));
        mView.updateList(new RegionsAdapter(mInteractor.getRegionsData(), mView));
    }

    private void displayCountries()
    {
        mView.showTitle(mCtx.getString(R.string.region) + mRegion.getName());
        mView.showSubtitle("");
        mView.updateList(new CountriesAdapter(mRegion.getCountries(), mView));
    }

    private void displayCountry(Object data)
    {
        StringBuilder countryDisplayData = new StringBuilder();
        Country country = (Country) data;
        countryDisplayData.append(mCtx.getString(R.string.capital));
        countryDisplayData.append(country.getCapital());
        countryDisplayData.append("\n");
        countryDisplayData.append(mCtx.getString(R.string.currency));
        countryDisplayData.append(country.getCurrency());
        countryDisplayData.append("\n");
        countryDisplayData.append(mCtx.getString(R.string.boarders));

        //show
        mView.showTitle(mCtx.getString(R.string.name) + country.getName());
        mView.showSubtitle(countryDisplayData.toString());
        mView.updateList(new CountriesAdapter(country.getBoarders(), null));
    }

    @Override
    public void nextLevel(Object data)
    {
        mCurrentStat++;
        updateView(data);
    }

    @Override
    public void previousLevel()
    {
        if (mCurrentStat > 0)
        {
            mCurrentStat--;
            updateView(null);
        } else
        {
            mView.showExitMessage();
        }

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i)
    {
        mView.close();
    }
}
