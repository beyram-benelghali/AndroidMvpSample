package beyram_ghali.me.androidmvpsample.main;

import android.content.Context;

import java.lang.ref.WeakReference;

import beyram_ghali.me.androidmvpsample.Base.BasePresenter;
import beyram_ghali.me.androidmvpsample.R;
import beyram_ghali.me.androidmvpsample.models.entity.Weather;

/**
 * Created by beyram on 22/08/17.
 */

public class MainPresenter extends BasePresenter<IMain_MVP.ModelOps, IMain_MVP.ViewOps> implements IMain_MVP.PresenterModelOps, IMain_MVP.PresenterViewOps {

    // View reference
    WeakReference<IMain_MVP.ViewOps> mView;
    // Model reference
    IMain_MVP.ModelOps mModel;
    private Context context;

    public MainPresenter(IMain_MVP.ViewOps mView) {
        attachView(mView);
        context = mView.getActivityContext();
    }

    @Override
    public void attachView(IMain_MVP.ViewOps mvpView) {
        this.mView = new WeakReference<>(mvpView);
    }

    @Override
    public IMain_MVP.ViewOps getView() {
        if (mView == null) {
            throw new NullPointerException("View is unavailable");
        } else {
            return mView.get();
        }
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void setModel(IMain_MVP.ModelOps model) {
        mModel = model;
    }

    @Override
    public void loadWeather(String city) {
        mModel.loadForecast(city, context.getResources().getString(R.string.open_weather_map_appid));
    }

    @Override
    public void successLoading(Weather weather) {
        mView.get().hideProgress();
        mView.get().displayWeatherData(weather);
    }

    @Override
    public void errorLoading() {
        mView.get().hideProgress();
        mView.get().errorLoadingWeather();
    }

}
