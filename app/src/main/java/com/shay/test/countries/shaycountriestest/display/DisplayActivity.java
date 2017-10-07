package com.shay.test.countries.shaycountriestest.display;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shay.test.countries.shaycountriestest.R;

/**
 * Created by Shay on 05/10/2017.
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
    }

    @Override
    protected void onDestroy()
    {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showTitle(String title)
    {
        mTitle.setText(title);
    }

    @Override
    public void showSubtitle(String text)
    {
        mSubTitle.setText(text);
    }

    public void updateList(RecyclerView.Adapter adapter)
    {
        mListView.setAdapter(adapter);
    }

    @Override
    public void showExitMessage()
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.exit);
        dlgAlert.setPositiveButton(R.string.ok, mPresenter);
        dlgAlert.setNegativeButton(R.string.cancel, null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    @Override
    public void close()
    {
        finish();
    }

    @Override
    public void onBackPressed()
    {
        mPresenter.previousLevel();
    }

    @Override
    public void onClick(View view)
    {
        mPresenter.nextLevel(view.getTag());
    }
}
