package com.example.humungus.infomavel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class HomeActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();

    ListView listView;
    Response responseObj;
    CustomAdapter adapter;
    String url = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=c34b4fbe057fc5d80c15def315daf2d4&hash=6447d19c43c2339aa168217c7b4a7590";
    Gson gson;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = (ListView) findViewById(R.id.characterList);
        client = new AsyncHttpClient();
        client.get(HomeActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responceStr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responceStr,Response.class);
                adapter = new CustomAdapter(HomeActivity.this,responseObj.getData().getResults());
                listView.setAdapter(adapter);
            }



            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }



}