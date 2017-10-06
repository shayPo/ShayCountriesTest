package com.shay.test.countries.shaycountriestest.model;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public class Country implements Comparable<Country>
{
    private List<Country> mBoarders = new ArrayList<>();
    private String mFullName;
    private String mCapital;
    private String mRegion;
    private String mCurrency;
    private double mSize;

    public Country(String sortName)
    {

    }

    public void parseCountryData(JSONObject countryJson)
    {
        try
        {
            mFullName = countryJson.getString("name");
            mCapital = countryJson.getString("capital");
            mRegion = countryJson.getString("region");
            mSize = countryJson.getDouble("area");
            JSONArray currencies = countryJson.getJSONArray("currencies");
            if(currencies.length() > 0)
            {
                mCurrency = ((JSONObject) currencies.get(0)).getString("name");
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void addBoarder(Country boarder)
    {
        mBoarders.add(boarder);
    }

    public String getRegionName()
    {
        return mRegion;
    }

    public String getName()
    {
        return mFullName;
    }

    public double getSize()
    {
        return mSize;
    }

    public List<Country> getBoarders()
    {
        return mBoarders;
    }

    @Override
    public int compareTo(@NonNull Country country)
    {
        return (int) (country.getSize() - mSize);
    }

    public String getCapital()
    {
        return mCapital;
    }

    public String getCurrency()
    {
        return mCurrency;
    }
}
