package com.shay.test.countries.shaycountriestest.global;

import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;

import java.util.List;

/**
 * Created by Shay on 05/10/2017.
 */

public interface IGlobalPresenter
{

    void setCountryData(List<Country> countryData);

    void setRegionsData(List<Region> regionData);

    List<Country> getCountryData();

    List<Region> getRegionsData();
}
