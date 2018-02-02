package com.example.humungus.infomavel;

/**
 * Created by humungus on 2/1/18.
 */

public class ListItem {
    private String thumbnail;
    private String name;
    private String desc;


    public ListItem(String thumbnail, String name, String desc) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.desc = desc;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
