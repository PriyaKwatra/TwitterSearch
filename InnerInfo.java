package com.example.acer.twittersearch;

/**
 * Created by acer on 7.07.2017.
 */

public class InnerInfo {

    String text;
    String link;
    MoreInner user;

    String retweet_count;
      String      favourites_count;

    public InnerInfo(String text, String link, MoreInner user, String retweet_count, String favourites_count) {
        this.text = text;
        this.link = link;
        this.user = user;
        this.retweet_count = retweet_count;
        this.favourites_count = favourites_count;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public MoreInner getUser() {
        return user;
    }

    public String getRetweet_count() {
        return retweet_count;
    }

    public String getFavourites_count() {
        return favourites_count;
    }
}
