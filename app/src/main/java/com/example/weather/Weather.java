package com.example.weather;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
    private String name, country, temp, iconurl;
    private RequestQueue mQueue;

    Weather(){
        jsonParse();
    }

    public void getter(){

    }
    private void jsonParse() {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q=l4g3c7&days=3\n";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject location,current;
                            location = response.getJSONObject("location");
                            name = location.getString("name");
                            country = location.getString("country");

                            // The current temperature with the icon
                            current = response.getJSONObject("current");
                            temp = current.getString("temp_c");
                            JSONObject object = current.getJSONObject("condition");
                            // String iconurl = object.getString("icon");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}

