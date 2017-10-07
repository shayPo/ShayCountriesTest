package com.shay.test.countries.shaycountriestest.network;

import com.android.volley.VolleyError;

/**
 * Created by Shay on 05/10/2017.
 */

public interface IResponseListener
{
    void onSuccess(Object response);

    void onError(VolleyError error);
}
