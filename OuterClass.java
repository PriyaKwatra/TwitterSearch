package com.example.acer.twittersearch;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by acer on 7.07.2017.
 */

public class OuterClass implements Parcelable {
    ArrayList<InnerInfo> statuses;

    public OuterClass(ArrayList<InnerInfo> statuses) {
        this.statuses = statuses;
    }

    protected OuterClass(Parcel in) {
    }

    public static final Creator<OuterClass> CREATOR = new Creator<OuterClass>() {
        @Override
        public OuterClass createFromParcel(Parcel in) {
            return new OuterClass(in);
        }

        @Override
        public OuterClass[] newArray(int size) {
            return new OuterClass[size];
        }
    };

    public ArrayList<InnerInfo> getStatuses() {
        return statuses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
