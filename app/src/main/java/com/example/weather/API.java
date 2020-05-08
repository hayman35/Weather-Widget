package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

class API {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }








//    Temperatures temperatures;
//    API(){
//        apiCall();
//    }
//
//    private void apiCall() {
//        new MyTask().execute();
//    }
//
//    public Temperatures getData() {
//        return temperatures;
//    }
//
//    public class MyTask extends AsyncTask<Void, Void, Void> {
//        String result;
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            URL url;
//            try {
//                url = new URL("https://api.weatherapi.com/v1/forecast.json?key=e39229688fd34bada27231316202704&q=l4g3c7&days=1");
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
//                String stringBuffer;
//                String string = "";
//                while ((stringBuffer = bufferedReader.readLine()) != null) {
//                    string = String.format("%s%s", string, stringBuffer);
//                }
//                bufferedReader.close();
//                result = string;
//            } catch (IOException e) {
//                e.printStackTrace();
//                result = e.toString();
//            }
//            try {
//                Temperatures data = Converter.fromJsonString(result);
//                setData(data);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        public void setData(Temperatures data) {
//            temperatures = data;
//            System.out.println(temperatures.getCurrent().getFeelslikeC());
//        }
//    }
}

