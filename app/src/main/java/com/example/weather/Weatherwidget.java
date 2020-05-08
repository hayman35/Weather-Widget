package com.example.weather;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.example.weather.Weatherapi.Converter;
import com.example.weather.Weatherapi.Temperatures;

import java.io.IOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


/**
 * Implementation of App Widget functionality.
 */
public class Weatherwidget extends AppWidgetProvider {

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        String json = ClientBuilder.newClient().target("https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q=l4g3c7&days=1").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        try {
            Temperatures data = Converter.fromJsonString(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
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





}

