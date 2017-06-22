package Utils;

import Network.Requests;
import Network.RetrofitClient;

/**
 * Created by epitos on 20/06/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public static Requests getRequests() {
        return RetrofitClient.getClient(BASE_URL).create(Requests.class);
    }
}
