package com.shay.test.countries.shaycountriestest.setup;

import android.content.Context;

import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;
import com.shay.test.countries.shaycountriestest.network.IResponseListener;

import java.util.List;

/**
 * Created by Sahar on 04/10/2017.
 */

public interface ISetupInteractor extends IResponseListener
{
    void loadData(OnSetupFinishedListener listener, Context ctx);

    List<Country> getCountryData();

    List<Region> getRegionData();

    interface OnSetupFinishedListener
    {
        void onSuccess();

        void onError();
    }
}
