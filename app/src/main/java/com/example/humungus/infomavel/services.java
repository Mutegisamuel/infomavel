package com.example.humungus.infomavel;




import com.example.humungus.infomavel.model.CharactersModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by humungus on 1/28/18.
 */

public class services {
    public static void getCharacters(Callback callback) {

//        ok http client
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        String url = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=c34b4fbe057fc5d80c15def315daf2d4&hash=6447d19c43c2339aa168217c7b4a7590";

/*
no need to build the url because this api is direct,it doesn't need query parameters or a key,its all included in the base url
so down here all we have to do is create a request
*/
        Request request= new Request.Builder()
                .url(url)
                .build();

//        here we create a call object and place our request in it.
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public ArrayList<CharactersModel> processResults(Response response){
        ArrayList<CharactersModel> charactersModels = new ArrayList<>();



        try{
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject charactersJSON = new JSONObject(jsonData);
                JSONObject data = charactersJSON.getJSONObject("data");
                JSONArray characterDetails = data.getJSONArray("results");
                    for(int x=0 ; x > characterDetails.length(); x++){

                    }



            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return charactersModels;
    }

}
