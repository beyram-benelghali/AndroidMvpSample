package beyram_ghali.me.androidmvpsample.models.api;

import beyram_ghali.me.androidmvpsample.models.entity.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beyram on 23/08/17.
 */

public interface OpenWeatherMapApi {

    String ENDPOINT = "http://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Call<Weather> getWeather(@Query("q") String location,
                             @Query("appid") String appid);

}
