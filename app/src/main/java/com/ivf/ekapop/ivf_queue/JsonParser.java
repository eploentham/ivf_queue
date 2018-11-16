package com.ivf.ekapop.ivf_queue;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class JsonParser {
    final String TAG = "JsonParser.java";

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    JSONArray jarr;
    public JSONArray getJSONFromUrl(String url, List<NameValuePair> params) {
        // make HTTP request
        try {
            String txt = url;
            txt = txt.replace("http://","").trim();
            if(txt.indexOf(":")!=0) {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                //httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    is.close();
                    json = sb.toString();
                    Log.d("getJSONFromUrl sb",sb.toString());
                    //json = json.replace("[","");
                    //json = json.replace("]","");
                } catch (Exception e) {
                    Log.e(TAG, "Error converting result " + e.toString());
                }

                // try parse the string to a JSON object
                try {
                    //jObj = new JSONObject(json);
                    if(json.toString().indexOf("DOCTYPE")>=0) return new JSONArray();
                    if(json == null) return  new JSONArray();
                    jarr = new JSONArray(json);
                    //jObj = new JSONObject("{\"code\":\"1000\",\"name\":\"\\u0e43\\u0e19\\u0e23\\u0e49\\u0e32\\u0e19\"},{\"code\":\"1001\",\"name\":\"\\u0e1f\\u0e38\\u0e15\\u0e1a\\u0e32\\u0e17\"},{\"code\":\"1002\",\"name\":\"\\u0e43\\u0e19\\u0e2a\\u0e27\\u0e19\"}");
                } catch (JSONException e) {
                    Log.e(TAG, "Error parsing data " + e.toString());
                    jarr = new JSONArray();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return JSON String
        return jarr;
    }

}
