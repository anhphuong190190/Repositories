package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class CaptionModel {
    @SerializedName("created_time")
    private long createdTime;

    @SerializedName("text")
    private String text;

    @SerializedName("id")
    private String id;

    @SerializedName("from")
    private UserModel from;

    public long getCreatedTime() {
        return createdTime;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public UserModel getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return "CaptionModel{" +
                "createdTime=" + createdTime +
                ", text='" + text + '\'' +
                ", id='" + id + '\'' +
                ", from=" + from +
                '}';
    }
}
