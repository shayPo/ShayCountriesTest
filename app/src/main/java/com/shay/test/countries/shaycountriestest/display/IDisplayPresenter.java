package com.shay.test.countries.shaycountriestest.display;

import android.content.DialogInterface;

/**
 * Created by Sahar on 05/10/2017.
 */

public interface IDisplayPresenter extends DialogInterface.OnClickListener
{
    enum Stat
    {
        REGIONS,
        COUNTRIES,
        COUNTRY
    }

    void onDestroy();

    void nextLevel(Object data);

    void previousLevel();
}
