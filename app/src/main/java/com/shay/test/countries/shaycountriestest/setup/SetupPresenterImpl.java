package com.shay.test.countries.shaycountriestest.setup;

import android.content.Context;

import com.shay.test.countries.shaycountriestest.global.App;
import com.shay.test.countries.shaycountriestest.global.IGlobalPresenter;
import com.shay.test.countries.shaycountriestest.model.Country;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Shay on 04/10/2017.
 */

public class SetupPresenterImpl implements ISetupPresenter, ISetupInteractor.OnSetupFinishedListener
{
    private ISetupView mView;
    private ISetupInteractor mInteractor;
    private Context mCtx;

    public SetupPresenterImpl(ISetupView view, Context ctx)
    {
        mView = view;
        mInteractor = new SetupInteractorImpl();
        mCtx = ctx;
    }

    @Override
    public void onDestroy()
    {
        mView = null;
        mCtx = null;
        mInteractor = null;
    }

    @Override
    public void loadData()
    {
        mView.showProgress();
        mInteractor.loadData(new WeakReference<ISetupInteractor.OnSetupFinishedListener>(this), mCtx);
    }

    ////////////////// fix
    @Override
    public List<Country> getData()
    {
        return mInteractor.getCountryData();
    }

    @Override
    public void onSuccess()
    {
        App app = App.getInstance();
        IGlobalPresenter globalPresenter = app.getPresenter();
        globalPresenter.setCountryData(mInteractor.getCountryData());
        globalPresenter.setRegionsData(mInteractor.getRegionData());
        mView.navigateToDisplay();
    }

    @Override
    public void onError()
    {
        mView.hideProgress();
        mView.showRetry();
    }
}
