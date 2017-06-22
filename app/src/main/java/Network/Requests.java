package Network;

import Model.City;
import Model.Forecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by epitos on 20/06/2017.
 */

public interface Requests {

    @GET("forecast")
    Call<City> getCityForecast(@Query("id") int id, @Query("APPID") String apiKey);
}
