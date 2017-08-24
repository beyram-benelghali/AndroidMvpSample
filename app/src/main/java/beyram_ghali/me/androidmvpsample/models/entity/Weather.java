package beyram_ghali.me.androidmvpsample.models.entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

/**
 * Created by beyram on 23/08/17.
 */

public class Weather {

    @Expose
    private JsonArray weather;
    @Expose
    private JsonObject main;
    @Expose
    private JsonObject wind;
    @Expose
    private String name;


    public Weather() {
    }

    public JsonArray getWeather() {
        return weather;
    }

    public void setWeather(JsonArray weather) {
        this.weather = weather;
    }

    public JsonObject getMain() {
        return main;
    }

    public void setMain(JsonObject main) {
        this.main = main;
    }

    public JsonObject getWind() {
        return wind;
    }

    public void setWind(JsonObject wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
