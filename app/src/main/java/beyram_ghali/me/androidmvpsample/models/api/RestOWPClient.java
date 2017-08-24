package beyram_ghali.me.androidmvpsample.models.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beyram on 23/08/17.
 */

public class RestOWPClient {

    private static RestOWPClient instance = null;
    Retrofit retrofit;
    private OpenWeatherMapApi apiService;

    private RestOWPClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(OpenWeatherMapApi.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(OpenWeatherMapApi.class);
    }

    public static RestOWPClient getInstance() {
        if (instance == null) {
            instance = new RestOWPClient();
        }
        return instance;
    }

    public OpenWeatherMapApi getOpenWeatherMapApi() {
        return apiService;
    }

}
