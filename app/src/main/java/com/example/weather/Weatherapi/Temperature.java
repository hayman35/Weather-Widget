package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Temperature {
    private Location location;
    private Current current;
    private Forecast forecast;
    private Alert alert;

    @JsonProperty("location")
    public Location getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Location value) { this.location = value; }

    @JsonProperty("current")
    public Current getCurrent() { return current; }
    @JsonProperty("current")
    public void setCurrent(Current value) { this.current = value; }

    @JsonProperty("forecast")
    public Forecast getForecast() { return forecast; }
    @JsonProperty("forecast")
    public void setForecast(Forecast value) { this.forecast = value; }

    @JsonProperty("alert")
    public Alert getAlert() { return alert; }
    @JsonProperty("alert")
    public void setAlert(Alert value) { this.alert = value; }
}
