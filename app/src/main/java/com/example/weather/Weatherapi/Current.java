package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Current {
    private long lastUpdatedEpoch;
    private String lastUpdated;
    private double tempC;
    private double tempF;
    private long isDay;
    private Condition condition;
    private double windMph;
    private double windKph;
    private long windDegree;
    private String windDir;
    private long pressureMB;
    private double pressureIn;
    private long precipMm;
    private long precipIn;
    private long humidity;
    private long cloud;
    private double feelslikeC;
    private double feelslikeF;
    private long visKM;
    private long visMiles;
    private long uv;
    private long gustMph;
    private double gustKph;

    @JsonProperty("last_updated_epoch")
    public long getLastUpdatedEpoch() { return lastUpdatedEpoch; }
    @JsonProperty("last_updated_epoch")
    public void setLastUpdatedEpoch(long value) { this.lastUpdatedEpoch = value; }

    @JsonProperty("last_updated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("last_updated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    @JsonProperty("temp_c")
    public double getTempC() { return tempC; }
    @JsonProperty("temp_c")
    public void setTempC(double value) { this.tempC = value; }

    @JsonProperty("temp_f")
    public double getTempF() { return tempF; }
    @JsonProperty("temp_f")
    public void setTempF(double value) { this.tempF = value; }

    @JsonProperty("is_day")
    public long getIsDay() { return isDay; }
    @JsonProperty("is_day")
    public void setIsDay(long value) { this.isDay = value; }

    @JsonProperty("condition")
    public Condition getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Condition value) { this.condition = value; }

    @JsonProperty("wind_mph")
    public double getWindMph() { return windMph; }
    @JsonProperty("wind_mph")
    public void setWindMph(double value) { this.windMph = value; }

    @JsonProperty("wind_kph")
    public double getWindKph() { return windKph; }
    @JsonProperty("wind_kph")
    public void setWindKph(double value) { this.windKph = value; }

    @JsonProperty("wind_degree")
    public long getWindDegree() { return windDegree; }
    @JsonProperty("wind_degree")
    public void setWindDegree(long value) { this.windDegree = value; }

    @JsonProperty("wind_dir")
    public String getWindDir() { return windDir; }
    @JsonProperty("wind_dir")
    public void setWindDir(String value) { this.windDir = value; }

    @JsonProperty("pressure_mb")
    public long getPressureMB() { return pressureMB; }
    @JsonProperty("pressure_mb")
    public void setPressureMB(long value) { this.pressureMB = value; }

    @JsonProperty("pressure_in")
    public double getPressureIn() { return pressureIn; }
    @JsonProperty("pressure_in")
    public void setPressureIn(double value) { this.pressureIn = value; }

    @JsonProperty("precip_mm")
    public long getPrecipMm() { return precipMm; }
    @JsonProperty("precip_mm")
    public void setPrecipMm(long value) { this.precipMm = value; }

    @JsonProperty("precip_in")
    public long getPrecipIn() { return precipIn; }
    @JsonProperty("precip_in")
    public void setPrecipIn(long value) { this.precipIn = value; }

    @JsonProperty("humidity")
    public long getHumidity() { return humidity; }
    @JsonProperty("humidity")
    public void setHumidity(long value) { this.humidity = value; }

    @JsonProperty("cloud")
    public long getCloud() { return cloud; }
    @JsonProperty("cloud")
    public void setCloud(long value) { this.cloud = value; }

    @JsonProperty("feelslike_c")
    public double getFeelslikeC() { return feelslikeC; }
    @JsonProperty("feelslike_c")
    public void setFeelslikeC(double value) { this.feelslikeC = value; }

    @JsonProperty("feelslike_f")
    public double getFeelslikeF() { return feelslikeF; }
    @JsonProperty("feelslike_f")
    public void setFeelslikeF(double value) { this.feelslikeF = value; }

    @JsonProperty("vis_km")
    public long getVisKM() { return visKM; }
    @JsonProperty("vis_km")
    public void setVisKM(long value) { this.visKM = value; }

    @JsonProperty("vis_miles")
    public long getVisMiles() { return visMiles; }
    @JsonProperty("vis_miles")
    public void setVisMiles(long value) { this.visMiles = value; }

    @JsonProperty("uv")
    public long getUv() { return uv; }
    @JsonProperty("uv")
    public void setUv(long value) { this.uv = value; }

    @JsonProperty("gust_mph")
    public long getGustMph() { return gustMph; }
    @JsonProperty("gust_mph")
    public void setGustMph(long value) { this.gustMph = value; }

    @JsonProperty("gust_kph")
    public double getGustKph() { return gustKph; }
    @JsonProperty("gust_kph")
    public void setGustKph(double value) { this.gustKph = value; }
}
