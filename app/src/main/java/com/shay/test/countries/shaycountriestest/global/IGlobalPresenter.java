package com.shay.test.countries.shaycountriestest.global;

import com.shay.test.countries.shaycountriestest.model.Country;
import com.shay.test.countries.shaycountriestest.model.Region;

import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public interface IGlobalPresenter
{

    void setCountryData(List<Country> countryData);

    void setRegionData(List<Region> regionData);

    List<Country> getCountryData();

    List<Region> getRegionData();
}
