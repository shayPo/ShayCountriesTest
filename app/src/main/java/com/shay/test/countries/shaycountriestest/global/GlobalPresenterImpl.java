package com.shay.test.countries.shaycountriestest.global;

import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;

import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public class GlobalPresenterImpl implements IGlobalPresenter
{
    private List<Country> mCountryData;
    private List<Region> mRegionData;

    @Override
    public void setCountryData(List<Country> countryData)
    {
        mCountryData = countryData;
    }

    @Override
    public void setRegionsData(List<Region> regionData)
    {
        mRegionData = regionData;
    }

    @Override
    public List<Country> getCountryData()
    {
        return mCountryData;
    }

    @Override
    public List<Region> getRegionsData()
    {
        return mRegionData;
    }
}
