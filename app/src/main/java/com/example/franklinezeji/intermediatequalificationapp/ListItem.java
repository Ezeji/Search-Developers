package com.example.franklinezeji.intermediatequalificationapp;

import static android.R.attr.description;

/**
 * Created by user on 8/3/2017.
 */

public class ListItem {

    private String user_name;
    private String imageUrl;
    private String html_url;

    public ListItem(String user_name, String imageUrl, String html_url) {
        this.user_name = user_name;
        this.imageUrl = imageUrl;
        this.html_url = html_url;
    }

    public String getUser_name() {
        return user_name;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public String getHtml_url() {
        return html_url;
    }
}
