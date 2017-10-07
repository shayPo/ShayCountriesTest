package com.shay.test.countries.shaycountriestest.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * Created by Shay on 05/10/2017.
 */

public class VolleyApiClient
{
    private RequestQueue mQueue;
    private static VolleyApiClient mInstance;

    /*
        Api urls
     */
    public final static String COUNTRIES_DATA_URL = "https://restcountries.eu/rest/v2/all";


    public static VolleyApiClient GetInstance(Context ctx)
    {
        if (mInstance == null)
        {
            mInstance = new VolleyApiClient(ctx);
        }

        return mInstance;
    }

    private VolleyApiClient(Context ctx)
    {
        mQueue = Volley.newRequestQueue(ctx);
    }

    public void VolleyRequest(int requestMethod, final String requestUrl, final JSONArray requestParams, final IResponseListener listener)
    {

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(requestMethod, requestUrl, requestParams, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                listener.onSuccess(response);
            }

        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                listener.onError(error);
            }
        });

        mQueue.add(jsonObjectRequest);
    }

}


