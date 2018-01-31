package com.example.humungus.infomavel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.humungus.infomavel.model.CharactersModel;

import java.io.IOException;
import java.util.ArrayList;


import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    public ArrayList<CharactersModel> mHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getInfo();
    }


    //    api responce
    private void getInfo() {
        final services mavelService = new services();
        mavelService.getCharacters(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mHeroes = mavelService.processResults(response);

                HomeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] heroNames = new String[mHeroes.size()];
                        for (int i = 0; i < heroNames.length; i++) {
                            heroNames[i] = mHeroes.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(HomeActivity.this,
                                android.R.layout.simple_list_item_1, heroNames);
                        mListView.setAdapter(adapter);

                    }

                });
            }
        });
    }
}