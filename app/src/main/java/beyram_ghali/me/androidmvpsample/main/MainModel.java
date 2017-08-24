package beyram_ghali.me.androidmvpsample.main;

import android.util.Log;

import beyram_ghali.me.androidmvpsample.models.api.OpenWeatherMapApi;
import beyram_ghali.me.androidmvpsample.models.api.RestOWPClient;
import beyram_ghali.me.androidmvpsample.models.entity.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by beyram on 22/08/17.
 */

public class MainModel implements IMain_MVP.ModelOps {

    IMain_MVP.PresenterModelOps mPresenter;
    OpenWeatherMapApi service;

    public MainModel(IMain_MVP.PresenterModelOps mPresenter) {
        this.mPresenter = mPresenter;
        service = RestOWPClient.getInstance().getOpenWeatherMapApi();
    }

    @Override
    public void loadForecast(String city, String app_id) {
        Call<Weather> call = service.getWeather(city, app_id);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Log.v("onResponse", response.toString());
                Weather weather = response.body();
                mPresenter.successLoading(weather);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.v("onFailure", t.getMessage());
                mPresenter.errorLoading();
            }
        });
    }
}
