package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class LikeModel {
    @SerializedName("count")
    private int count;

    @SerializedName("data")
    private UserModel[] users;

    public int getCount() {
        return count;
    }

    public UserModel[] getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "LikeModel{" +
                "count=" + count +
                ", users=" + Arrays.toString(users) +
                '}';
    }
}
