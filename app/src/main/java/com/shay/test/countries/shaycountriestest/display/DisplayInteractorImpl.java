package com.shay.test.countries.shaycountriestest.display;

import com.shay.test.countries.shaycountriestest.global.App;
import com.shay.test.countries.shaycountriestest.model.Region;

import java.util.List;

/**
 * Created by Sahar on 05/10/2017.
 */

public class DisplayInteractorImpl implements IDisplayInteractor
{

    public DisplayInteractorImpl()
    {

    }

    @Override
    public List<Region> getRegionsData()
    {
        return App.getInstance().getPresenter().getRegionsData();
    }
}
