package beyram_ghali.me.androidmvpsample.main;

import android.content.Context;

import beyram_ghali.me.androidmvpsample.models.entity.Weather;

/**
 * Created by beyram on 22/08/17.
 */

public interface IMain_MVP {

    /**
     * View methods available to Presenter.
     */
    interface ViewOps {
        void getWeather(String city);

        void showProgress();

        void hideProgress();

        Context getActivityContext();

        void displayWeatherData(Weather weather);

        void errorLoadingWeather();
    }

    /**
     * Presenter Operations offered to View
     */
    interface PresenterViewOps {
        void loadWeather(String city);
    }

    /**
     * Presenter Operations offered to Model
     */
    interface PresenterModelOps {
        void successLoading(Weather weather);

        void errorLoading();
    }

    /**
     * Models Operations offered to Presenter
     */
    interface ModelOps {
        void loadForecast(String city, String app_id);
    }
}
