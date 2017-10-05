package com.shay.test.countries.shaycountriestest.setup;

import com.shay.test.countries.shaycountriestest.model.Country;

import java.util.List;

/**
 * Created by Sahar on 04/10/2017.
 */

public interface ISetupPresenter
{
    void onDestroy();

    void loadData();

    List<Country> getData();
}
