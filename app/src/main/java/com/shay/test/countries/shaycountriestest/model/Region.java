package com.shay.test.countries.shaycountriestest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public class Region
{
    private String mName;
    private List<Country> mData = new ArrayList<>();

    public Region(String name)
    {
       mName = name;
    }

    public void addCountry(Country country)
    {
        mData.add(country);
    }

    public List<Country> getCountries()
    {
        return mData;
    }

    public String getName()
    {
        return mName;
    }
}
