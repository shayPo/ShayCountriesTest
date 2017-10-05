package com.shay.test.countries.shaycountriestest.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public class Country
{
    private List<Country> mBoarders = new ArrayList<>();
    private String mFullName;
    private String mCapital;
    private String mRegion;
    private long mSize;

    public Country(String sortName)
    {

    }
//{"name":"Afghanistan","topLevelDomain":[".af"],"alpha2Code":"AF","alpha3Code":"AFG","callingCodes":["93"],"capital":"Kabul","altSpellings":["AF","Afġānistān"],"region":"Asia","subregion":"Southern Asia","population":27657145,"latlng":[33,65],"demonym":"Afghan","area":652230,"gini":27.8,"timezones":["UTC+04:30"],"borders":["IRN","PAK","TKM","UZB","TJK","CHN"],"nativeName":"افغانستان","numericCode":"004","currencies":[{"code":"AFN","name":"Afghan afghani","symbol":"؋"}],"languages":[{"iso639_1":"ps","iso639_2":"pus","name":"Pashto","nativeName":"پښتو"},{"iso639_1":"uz","iso639_2":"uzb","name":"Uzbek","nativeName":"Oʻzbek"},{"iso639_1":"tk","iso639_2":"tuk","name":"Turkmen","nativeName":"Türkmen"}],"translations":{"de":"Afghanistan","es":"Afganistán","fr":"Afghanistan","ja":"アフガニスタン","it":"Afghanistan","br":"Afeganistão","pt":"Afeganistão","nl":"Afghanistan","hr":"Afganistan","fa":"افغانستان"},"flag":"https:\/\/restcountries.eu\/data\/afg.svg","regionalBlocs":[{"acronym":"SAARC","name":"South Asian Association for Regional Cooperation","otherAcronyms":[],"otherNames":[]}],"cioc":"AFG"}

    public String getRegionName()
    {
        return mRegion;
    }

    public void parseCountryData(JSONObject countryJson)
    {
        try
        {
            mFullName = countryJson.getString("name");
            mCapital = countryJson.getString("capital");
            mRegion = countryJson.getString("region");
            mSize = countryJson.getLong("area");
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void addBoarder(Country boarder)
    {
        mBoarders.add(boarder);
    }
}
