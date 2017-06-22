package com.example.epitos.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import Model.City;
import Model.Forecast;
import Network.Requests;
import Utils.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final int LONDON_CITY_ID = 2643743;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ForcastAdapter forcastAdapter;
    private Requests requests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        requests = ApiUtils.getRequests();

        loadForecast();

    }

    private void bindViews() {
        recyclerView = (RecyclerView) findViewById(R.id.five_day_forcast_list);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(forcastAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,  DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void loadForecast() {
        requests.getCityForecast(LONDON_CITY_ID, getResources().getString(R.string.open_weather_map_api_key)).enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    forcastAdapter = new ForcastAdapter(response.body().getList());
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.d(MainActivity.class.getSimpleName(), t.getMessage());
            }
        });
    }
}
