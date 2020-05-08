package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Astro {
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;

    @JsonProperty("sunrise")
    public String getSunrise() { return sunrise; }
    @JsonProperty("sunrise")
    public void setSunrise(String value) { this.sunrise = value; }

    @JsonProperty("sunset")
    public String getSunset() { return sunset; }
    @JsonProperty("sunset")
    public void setSunset(String value) { this.sunset = value; }

    @JsonProperty("moonrise")
    public String getMoonrise() { return moonrise; }
    @JsonProperty("moonrise")
    public void setMoonrise(String value) { this.moonrise = value; }

    @JsonProperty("moonset")
    public String getMoonset() { return moonset; }
    @JsonProperty("moonset")
    public void setMoonset(String value) { this.moonset = value; }
}
