package com.example.weather;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.AppWidgetTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.weather.Weatherapi.Converter;
import com.example.weather.Weatherapi.Temperature;
import com.google.gson.JsonArray;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;


import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;


/**
 * Implementation of App Widget functionality.
 */
public class Weatherwidget extends AppWidgetProvider {
    Temperature data;
    String url,day;
    ApiCall apiCall = new ApiCall();


    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) throws ExecutionException, InterruptedException {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

        // Call the Api to get the Info
        createAsyncTask().execute();
        data = apiCall.get();

        // Current
        views.setTextViewText(R.id.current_temp,""+data.getCurrent().getTempC());
        views.setTextViewText(R.id.current_location,""+data.getLocation().getName());
        url = data.getCurrent().getCondition().getIcon(); // get the url from data
        // set the widget target for the picture
        AppWidgetTarget awt = new AppWidgetTarget(context, R.id.current_img, views, appWidgetId) {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                super.onResourceReady(resource, transition);
            }
        };

        RequestOptions options = new RequestOptions().
                override(300, 300).placeholder(R.drawable.weather_white_01d).error(R.drawable.weather_white_01d);
        // load the icons
        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load("https:"+url)
                .apply(options)
                .into(awt);

        // Day 1
        views.setTextViewText(R.id.daily_temp_1,""+data.getForecast().getForecastday()[0].getDay().getAvgtempC());
        //views.setTextViewText(R.id.daily_time_1,);
        url = data.getForecast().getForecastday()[0].getDay().getCondition().getIcon(); // get the url from data
        // set the widget target for the picture
         awt = new AppWidgetTarget(context, R.id.daily_img_1, views, appWidgetId) {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                super.onResourceReady(resource, transition);
            }
        };

         options = new RequestOptions().
                override(300, 300).placeholder(R.drawable.weather_white_01d).error(R.drawable.weather_white_01d);
        // load the icons
        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load("https:"+url)
                .apply(options)
                .into(awt);

        // Day 2
        views.setTextViewText(R.id.daily_temp_2,""+data.getForecast().getForecastday()[1].getDay().getAvgtempC());
        url = data.getForecast().getForecastday()[1].getDay().getCondition().getIcon(); // get the url from data
        // set the widget target for the picture
        awt = new AppWidgetTarget(context, R.id.daily_img_2, views, appWidgetId) {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                super.onResourceReady(resource, transition);
            }
        };

         options = new RequestOptions().
                override(300, 300).placeholder(R.drawable.weather_white_01d).error(R.drawable.weather_white_01d);
        // load the icons
        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load("https:"+url)
                .apply(options)
                .into(awt);



        // Day 3
        views.setTextViewText(R.id.daily_temp_3,""+data.getForecast().getForecastday()[2].getDay().getAvgtempC());
        url = data.getForecast().getForecastday()[2].getDay().getCondition().getIcon(); // get the url from data
        // set the widget target for the picture
        awt = new AppWidgetTarget(context, R.id.daily_img_3, views, appWidgetId) {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                super.onResourceReady(resource, transition);
            }
        };

        options = new RequestOptions().
                override(300, 300).placeholder(R.drawable.weather_white_01d).error(R.drawable.weather_white_01d);
        // load the icons
        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load("https:"+url)
                .apply(options)
                .into(awt);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            try {
                updateAppWidget(context, appWidgetManager, appWidgetId);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private ApiCall createAsyncTask(){
        if (apiCall == null){
            return apiCall = new ApiCall();
        }
        apiCall.cancel(true);
        return apiCall = new ApiCall();
    }

    private class ApiCall extends AsyncTask<Temperature, String, Temperature> {

        protected void onPreExecute(){

        }

        @Override
        protected Temperature doInBackground(Temperature... temperature) {
            try {
                // For the main Json file parsing it into data
                    JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q=l4g3c7&days=3"), StandardCharsets.UTF_8));
                    data = Converter.fromJsonString(json.toString());
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

            return data;
        }
        protected void onPostExecute(Temperature temperature) {
            data = temperature;
        }
        @Override
        protected void onCancelled(){
            System.out.println("DONE");
        }

    }


}

