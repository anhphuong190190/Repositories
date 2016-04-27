package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class ImageModel {
    @SerializedName("low_resolution")
    private PhotoModel lowRes;

    @SerializedName("thumbnail")
    private PhotoModel thumb;

    @SerializedName("standard_resolution")
    private PhotoModel standardRes;

    public PhotoModel getLowRes() {
        return lowRes;
    }

    public PhotoModel getThumb() {
        return thumb;
    }

    public PhotoModel getStandardRes() {
        return standardRes;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "lowRes=" + lowRes +
                ", thumb=" + thumb +
                ", standardRes=" + standardRes +
                '}';
    }
}
