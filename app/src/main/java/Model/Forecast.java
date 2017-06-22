package Model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by epitos on 20/06/2017.
 */

public class Forecast {

    @SerializedName("city")
    private City city;

    public City getCity() {
        return city;
    }
}
