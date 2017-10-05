package com.shay.test.countries.shaycountriestest.display;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.shay.test.countries.shaycountriestest.R;

/**
 * Created by Sahar on 05/10/2017.
 */

public class DisplayActivity extends AppCompatActivity implements IDisplayView
{
    private IDisplayPresenter mPresenter;
    private RecyclerView mListView;
    private TextView mTitle;
    private TextView mSubTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly);
        init();
    }

    private void init()
    {
        mTitle = (TextView) findViewById(R.id.main_title);
        mSubTitle = (TextView) findViewById(R.id.sub_title);
        mListView = (RecyclerView) findViewById(R.id.list_view);
        mListView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new DisplayPresenterImpl(this, this);
        mPresenter.displayRegions();
    }

    @Override
    public void showTitle(String title)
    {
        mTitle.setText(title);
    }

    public void updateList(RecyclerView.Adapter adapter)
    {
        mListView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
