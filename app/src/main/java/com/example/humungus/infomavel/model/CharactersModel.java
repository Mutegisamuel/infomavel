package com.example.humungus.infomavel.model;

/**
 * Created by humungus on 1/28/18.
 */

public class CharactersModel {
    private String mName;
    private String mDescription;
    private String mImage;

    public  CharactersModel(String name, String description, String image){
        this.mName = name;
        this.mDescription= description;
        this.mImage = image;
    }

    public String getName(){
        return  mName;
    }
    public String getDescription(){
        return mDescription;
    }
    public String getmImage(){return getmImage();
    }

}

