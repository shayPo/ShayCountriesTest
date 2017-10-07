package com.shay.test.countries.shaycountriestest.setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shay.test.countries.shaycountriestest.R;
import com.shay.test.countries.shaycountriestest.display.DisplayActivity;

public class SetupActivity extends AppCompatActivity implements ISetupView, View.OnClickListener
{
    private TextView mTextOnScreen;
    private ProgressBar mProgressBar;
    private ISetupPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        init();
    }

    private void init()
    {
        mTextOnScreen = (TextView) findViewById(R.id.displayText);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mPresenter = new SetupPresenterImpl(this, this);
        mPresenter.loadData();
    }

    @Override
    public void showProgress()
    {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextOnScreen.setText(R.string.loading);
    }

    @Override
    public void hideProgress()
    {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showRetry()
    {
        mTextOnScreen.setText(R.string.retry_text);
        mTextOnScreen.setOnClickListener(this);
    }

    @Override
    public void navigateToDisplay()
    {
        Intent showDisplay = new Intent(this, DisplayActivity.class);
        showDisplay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(showDisplay);
    }

    @Override
    public void onClick(View view)
    {
        view.setOnClickListener(null);
        mPresenter.loadData();
    }

    @Override
    protected void onDestroy()
    {
        mPresenter.onDestroy();
        super.onDestroy();
    }
}
