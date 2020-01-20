package com.example.moviecatalogue.list_movie;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable{

    private String title;
    private String overview;
    private Integer poster;

    public MovieModel(String title, String overview, Integer poster) {
        this.title = title;
        this.overview = overview;
        this.poster = poster;
    }

    public MovieModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    protected MovieModel(Parcel in) {
        title = in.readString();
        overview = in.readString();
        if (in.readByte() == 0) {
            poster = null;
        } else {
            poster = in.readInt();
        }
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(overview);
        if (poster == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(poster);
        }
    }
}