package com.example.weather;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.RemoteViews;

import com.example.weather.Weatherapi.Converter;
import com.example.weather.Weatherapi.Temperatures;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;


/**
 * Implementation of App Widget functionality.
 */
public class Weatherwidget extends AppWidgetProvider {
    Temperatures data;

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);

        ApiCall apiCall = new ApiCall();
        apiCall.execute();
        try {
            data = apiCall.get();
            long code = data.getCurrent().getCondition().getCode();
            views.setTextViewText(R.id.daily_temp_1,""+data.getCurrent().getFeelslikeC());
            views.setImageViewResource(R.id.daily_img_1,R.drawable.weather_white_01d);
            views.setImageViewResource(R.id.daily_img_2,R.drawable.weather_white_02d);
            views.setImageViewResource(R.id.daily_img_3,R.drawable.weather_white_03d);
            views.setImageViewResource(R.id.daily_img_4,R.drawable.weather_white_04d);
            views.setImageViewResource(R.id.daily_img_5,R.drawable.weather_white_50d);
            views.setImageViewResource(R.id.daily_img_6,R.drawable.weather_white_09d);


        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private class ApiCall extends AsyncTask<Temperatures, String, Temperatures> {
        @Override
        protected Temperatures doInBackground(Temperatures... temperatures) {
            try {
                JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q=l4g3c7&days=1"), StandardCharsets.UTF_8));
                data = Converter.fromJsonString(json.toString());
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        protected void onPostExecute(Temperatures temperatures) {
            data = temperatures;

        }

    }




}

