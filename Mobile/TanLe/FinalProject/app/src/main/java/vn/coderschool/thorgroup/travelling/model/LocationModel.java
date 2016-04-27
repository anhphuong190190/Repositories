package vn.coderschool.thorgroup.travelling.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 4/10/2016.
 */
public class LocationModel {
    @SerializedName("longitude")
    private double longitude;

    @SerializedName("latitude")
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
