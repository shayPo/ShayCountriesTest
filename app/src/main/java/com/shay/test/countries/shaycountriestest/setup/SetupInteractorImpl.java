package com.shay.test.countries.shaycountriestest.setup;

import android.content.Context;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;
import com.shay.test.countries.shaycountriestest.network.VolleyApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shay on 04/10/2017.
 */

public class SetupInteractorImpl implements ISetupInteractor
{
    private OnSetupFinishedListener mListener;
    private List<Country> mCountryData;
    private List<Region> mRegionData;

    @Override
    public void loadData(final OnSetupFinishedListener listener, Context ctx)
    {
        mListener = listener;
        VolleyApiClient.GetInstance(ctx).VolleyRequest(StringRequest.Method.GET, VolleyApiClient.COUNTRIES_DATA_URL, null, this);
    }

    @Override
    public List<Country> getCountryData()
    {
        if (mCountryData == null)
        {
            mCountryData = new ArrayList<>();
        }
        return mCountryData;
    }

    @Override
    public List<Region> getRegionData()
    {
        if (mRegionData == null)
        {
            mRegionData = new ArrayList<>();
        }
        return mRegionData;
    }

    @Override
    public void onSuccess(Object response)
    {
        try
        {
            JSONArray data = (JSONArray) response;
            HashMap<String, Country> countryData = new HashMap<>();
            HashMap<String, Region> regionData = new HashMap<>();
            for (int i = 0, size = data.length(); i < size; i++)
            {
                Country country;
                Region region;

                JSONObject countryJson = data.getJSONObject(i);
                String key = countryJson.getString("alpha3Code");
                if (countryData.containsKey(key))
                {
                    country = countryData.get(key);
                    country.parseCountryData(countryJson);
                } else
                {
                    country = new Country();
                    country.parseCountryData(countryJson);
                    countryData.put(key, country);
                }

                if (regionData.containsKey(country.getRegionName()))
                {
                    region = regionData.get(country.getRegionName());
                    region.addCountry(country);
                } else
                {
                    region = new Region(country.getRegionName());
                    region.addCountry(country);
                    regionData.put(country.getRegionName(), region);
                }

                JSONArray boarders = countryJson.getJSONArray("borders");
                for (int x = 0, boarderSize = boarders.length(); x < boarderSize; x++)
                {
                    String name = (String) boarders.get(x);
                    if (countryData.containsKey(name))
                    {
                        Country boarder = countryData.get(name);
                        country.addBoarder(boarder);
                    } else
                    {
                        Country boarder = new Country();
                        countryData.put(name, boarder);
                        country.addBoarder(boarder);
                    }
                }

            }

            mCountryData = new ArrayList<>(countryData.values());
            mRegionData = new ArrayList<>(regionData.values());

            if (mListener != null)
            {
                mListener.onSuccess();
            }
        } catch (Exception e)
        {
            if (mListener != null)
            {
                mListener.onError();
            }
        }
    }

    @Override
    public void onError(VolleyError error)
    {
        if (mListener != null)
        {
            mListener.onError();
        }
    }
}
