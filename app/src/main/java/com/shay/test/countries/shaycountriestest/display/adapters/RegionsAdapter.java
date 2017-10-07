package com.shay.test.countries.shaycountriestest.display.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shay.test.countries.shaycountriestest.R;
import com.shay.test.countries.shaycountriestest.model.Region;

import java.util.List;

/**
 * Created by Shay on 05/10/2017.
 */

public class RegionsAdapter extends RecyclerView.Adapter<RegionsAdapter.RegionsViewHolder>
{
    private List<Region> mData;
    private View.OnClickListener mListener;

    public RegionsAdapter(List<Region> data, View.OnClickListener listener)
    {
        mData = data;
        mListener = listener;
    }

    @Override
    public RegionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.region_row, null);
        RegionsViewHolder viewHolder = new RegionsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RegionsViewHolder holder, int position)
    {
        holder.updateData(mData.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mData == null ? 0 : mData.size();
    }

    class RegionsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTitle;

        public RegionsViewHolder(View itemView)
        {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mTitle.setOnClickListener(mListener);
        }

        public void updateData(Region region)
        {
            mTitle.setTag(region);
            mTitle.setText(region.getName());
        }
    }

}
