package com.example.acer.twittersearch;

/**
 * Created by acer on 7.07.2017.
 */

public class MoreInner {


   String profile_image_url_https;
    String name;

    public MoreInner(String profile_image_url_https, String name) {
        this.profile_image_url_https = profile_image_url_https;
        this.name = name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getName() {
        return name;
    }
}
