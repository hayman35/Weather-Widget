package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Forecastday {
    private String date;
    private long dateEpoch;
    private Day day;
    private Astro astro;

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("date_epoch")
    public long getDateEpoch() { return dateEpoch; }
    @JsonProperty("date_epoch")
    public void setDateEpoch(long value) { this.dateEpoch = value; }

    @JsonProperty("day")
    public Day getDay() { return day; }
    @JsonProperty("day")
    public void setDay(Day value) { this.day = value; }

    @JsonProperty("astro")
    public Astro getAstro() { return astro; }
    @JsonProperty("astro")
    public void setAstro(Astro value) { this.astro = value; }
}
