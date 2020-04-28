package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity {
    Editable Postcode;
    private TextView mTextViewResult;
    private TextView mtemp;
    private EditText mtext;
    private RequestQueue mQueue;
    private ImageView icon;
    private Button buttonParse;
    private JsonArrayRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.textid1);
        buttonParse = findViewById(R.id.buttonid);
        mtext = findViewById(R.id.inputtext);
        icon = findViewById(R.id.pictureid);
        mtemp = findViewById(R.id.tempid);
        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Postcode = mtext.getText();
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q="+Postcode+"&days=3\n";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject location,current;
                            location = response.getJSONObject("location");
                            String name = location.getString("name");
                            String country = location.getString("country");
                            String localtime = location.getString("localtime");
                            mTextViewResult.append(name + ", " + country + " ," + localtime + "\n\n");

                            // The current temperature with the icon
                            current = response.getJSONObject("current");
                            String temp = current.getString("temp_c");
                            JSONObject object = current.getJSONObject("condition");
                            String iconurl = object.getString("icon");
                            Picasso.get().load("https:"+iconurl).into(icon);
                            mtemp.append(temp+ ", " +"\n\n");
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
