package com.shay.test.countries.shaycountriestest.display.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shay.test.countries.shaycountriestest.R;
import com.shay.test.countries.shaycountriestest.model.Country;

import java.util.List;

/**
 * Created by Shay on 05/10/2017.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>
{
    private List<Country> mData;
    private View.OnClickListener mListener;

    public CountriesAdapter(List<Country> data, View.OnClickListener listener)
    {
        mData = data;
        mListener = listener;
    }

    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.region_row, null);
        CountriesAdapter.CountriesViewHolder viewHolder = new CountriesAdapter.CountriesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountriesAdapter.CountriesViewHolder holder, int position)
    {
        holder.updateData(mData.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mData == null ? 0 : mData.size();
    }

    class CountriesViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTitle;

        public CountriesViewHolder(View itemView)
        {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mTitle.setOnClickListener(mListener);
        }

        public void updateData(Country country)
        {
            mTitle.setTag(country);
            mTitle.setText(country.getName());
        }
    }
}
