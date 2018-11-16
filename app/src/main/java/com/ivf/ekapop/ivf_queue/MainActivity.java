package com.ivf.ekapop.ivf_queue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    JsonParser jsonparser = new JsonParser();
    JSONArray jarrS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
