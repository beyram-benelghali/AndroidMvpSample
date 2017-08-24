package beyram_ghali.me.androidmvpsample.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import beyram_ghali.me.androidmvpsample.Base.BaseActivity;
import beyram_ghali.me.androidmvpsample.R;
import beyram_ghali.me.androidmvpsample.common.Utils;
import beyram_ghali.me.androidmvpsample.models.entity.Weather;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMain_MVP.ViewOps, View.OnClickListener {

    ProgressDialog progressDialog;
    @BindView(R.id.weatherButton)
    Button weatherButton;
    @BindView(R.id.EdittextLocation)
    EditText edittextLocation;
    @BindView(R.id.imageWeather)
    ImageView imageWeather;
    @BindView(R.id.namePlace)
    TextView namePlaceTextView;
    @BindView(R.id.description)
    TextView descriptionTextView;
    @BindView(R.id.humidity)
    TextView humidityTextView;
    @BindView(R.id.temp)
    TextView tempTextView;
    @BindView(R.id.wind)
    TextView windTextView;
    IMain_MVP.PresenterViewOps mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherButton.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    protected void initializeMVP() {
        MainPresenter presenter = new MainPresenter(this);
        MainModel model = new MainModel(presenter);
        presenter.setModel(model);
        mPresenter = presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgress() {
        Utils.showProgressDialog(progressDialog, "MVP SAMPLE", "Loading Weather..", false);
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void displayWeatherData(Weather weather) {
        String name = weather.getName();
        String temp = weather.getMain().get("temp").getAsString();
        String humidity = weather.getMain().get("humidity").getAsString();
        String wind = weather.getWind().get("speed").getAsString();
        String description = weather.getWeather().get(0).getAsJsonObject().get("description").getAsString();
        String urlIcon = weather.getWeather().get(0).getAsJsonObject().get("icon").getAsString();
        Log.v("Weather", name + " " + temp + " " + humidity + " " + wind + " " + description + " " + urlIcon);
        Glide.with(this).load("http://openweathermap.org/img/w/" + urlIcon + ".png").into(imageWeather);
        namePlaceTextView.setText("Place : " + name);
        tempTextView.setText("Temperature : " + temp + " Kelvin");
        humidityTextView.setText("Humidity : " + humidity + "%");
        windTextView.setText("Wind Speed : " + temp + " M/S");
        descriptionTextView.setText("Description : " + description);

    }

    @Override
    public void errorLoadingWeather() {
        Utils.showToast(this, "Network error", Toast.LENGTH_LONG);
    }

    @Override
    public void getWeather(String city) {
        showProgress();
        mPresenter.loadWeather(city);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weatherButton: {
                Log.v("here", "here");
                String city = edittextLocation.getText().toString();
                if (city.isEmpty()) {
                    Utils.showAlert(this, "MVP SAMPLE", "CITY IS EMPTY");
                } else {
                    getWeather(city);
                }
            }
        }
    }
}
