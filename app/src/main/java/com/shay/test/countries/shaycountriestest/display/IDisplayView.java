package com.shay.test.countries.shaycountriestest.display;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Shay on 05/10/2017.
 */

public interface IDisplayView extends View.OnClickListener
{
    void showTitle(String title);

    void showSubtitle(String title);

    void updateList(RecyclerView.Adapter adapter);

    void showExitMessage();

    void close();
}
