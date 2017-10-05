package com.shay.test.countries.shaycountriestest.display;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Sahar on 05/10/2017.
 */

public interface IDisplayView
{
    void showTitle(String title);

    void updateList(RecyclerView.Adapter adapter);
}
