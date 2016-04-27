package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class UserModel {
    @SerializedName("username")
    private String userName;

    @SerializedName("profile_picture")
    private String profilePicture;

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    public String getUserName() {
        return userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
