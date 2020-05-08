package com.example.weather.Weatherapi;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Day {
    private double maxtempC;
    private double maxtempF;
    private double mintempC;
    private long mintempF;
    private double avgtempC;
    private double avgtempF;
    private double maxwindMph;
    private double maxwindKph;
    private long totalprecipMm;
    private long totalprecipIn;
    private long avgvisKM;
    private long avgvisMiles;
    private long avghumidity;
    private Condition condition;
    private double uv;

    @JsonProperty("maxtemp_c")
    public double getMaxtempC() { return maxtempC; }
    @JsonProperty("maxtemp_c")
    public void setMaxtempC(double value) { this.maxtempC = value; }

    @JsonProperty("maxtemp_f")
    public double getMaxtempF() { return maxtempF; }
    @JsonProperty("maxtemp_f")
    public void setMaxtempF(double value) { this.maxtempF = value; }

    @JsonProperty("mintemp_c")
    public double getMintempC() { return mintempC; }
    @JsonProperty("mintemp_c")
    public void setMintempC(double value) { this.mintempC = value; }

    @JsonProperty("mintemp_f")
    public long getMintempF() { return mintempF; }
    @JsonProperty("mintemp_f")
    public void setMintempF(long value) { this.mintempF = value; }

    @JsonProperty("avgtemp_c")
    public double getAvgtempC() { return avgtempC; }
    @JsonProperty("avgtemp_c")
    public void setAvgtempC(double value) { this.avgtempC = value; }

    @JsonProperty("avgtemp_f")
    public double getAvgtempF() { return avgtempF; }
    @JsonProperty("avgtemp_f")
    public void setAvgtempF(double value) { this.avgtempF = value; }

    @JsonProperty("maxwind_mph")
    public double getMaxwindMph() { return maxwindMph; }
    @JsonProperty("maxwind_mph")
    public void setMaxwindMph(double value) { this.maxwindMph = value; }

    @JsonProperty("maxwind_kph")
    public double getMaxwindKph() { return maxwindKph; }
    @JsonProperty("maxwind_kph")
    public void setMaxwindKph(double value) { this.maxwindKph = value; }

    @JsonProperty("totalprecip_mm")
    public long getTotalprecipMm() { return totalprecipMm; }
    @JsonProperty("totalprecip_mm")
    public void setTotalprecipMm(long value) { this.totalprecipMm = value; }

    @JsonProperty("totalprecip_in")
    public long getTotalprecipIn() { return totalprecipIn; }
    @JsonProperty("totalprecip_in")
    public void setTotalprecipIn(long value) { this.totalprecipIn = value; }

    @JsonProperty("avgvis_km")
    public long getAvgvisKM() { return avgvisKM; }
    @JsonProperty("avgvis_km")
    public void setAvgvisKM(long value) { this.avgvisKM = value; }

    @JsonProperty("avgvis_miles")
    public long getAvgvisMiles() { return avgvisMiles; }
    @JsonProperty("avgvis_miles")
    public void setAvgvisMiles(long value) { this.avgvisMiles = value; }

    @JsonProperty("avghumidity")
    public long getAvghumidity() { return avghumidity; }
    @JsonProperty("avghumidity")
    public void setAvghumidity(long value) { this.avghumidity = value; }

    @JsonProperty("condition")
    public Condition getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Condition value) { this.condition = value; }

    @JsonProperty("uv")
    public double getUv() { return uv; }
    @JsonProperty("uv")
    public void setUv(double value) { this.uv = value; }
}
