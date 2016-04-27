package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class PhotoModel {
    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "PhotoModel{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
