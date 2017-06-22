package com.example.epitos.retrofitexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.List;

/**
 * Created by epitos on 20/06/2017.
 */

public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.ViewHolder> {

    private static final int FORECAST_SIZE = 5;

    private java.util.List<List> list;

    public ForcastAdapter(java.util.List<List> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.forcast_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mainTextView.setText(list.get(position).getWeather().get(0).getMain());
        holder.descriptionTextView.setText(list.get(position).getWeather().get(0).getDescription());
        holder.timeTextView.setText(list.get(position).getDtTxt().substring(10));

        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date MyDate = newDateFormat.parse(list.get(position).getDtTxt().substring(0, 10));
            newDateFormat.applyPattern("EEEE");
            String MyDateString = newDateFormat.format(MyDate);
            holder.dayTextView.setText(MyDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return FORECAST_SIZE;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mainTextView;
        public TextView descriptionTextView;
        public TextView timeTextView;
        public TextView dayTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mainTextView = (TextView) itemView.findViewById(R.id.main);
            descriptionTextView = (TextView) itemView.findViewById(R.id.description);
            timeTextView = (TextView) itemView.findViewById(R.id.time);
            dayTextView = (TextView) itemView.findViewById(R.id.day);
        }
    }


}
