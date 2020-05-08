package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Forecast {
    private Forecastday[] forecastday;

    @JsonProperty("forecastday")
    public Forecastday[] getForecastday() { return forecastday; }
    @JsonProperty("forecastday")
    public void setForecastday(Forecastday[] value) { this.forecastday = value; }
}
