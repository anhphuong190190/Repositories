package vn.coderschool.thorgroup.travelling.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 4/10/2016.
 */
public class UserModel implements Parcelable {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String userName;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("profile_picture_url")
    private String avatar;

    @SerializedName("cover")
    private String cover;

    @SerializedName("last_sync")
    private long lastSync;

    @SerializedName("location")
    private LocationModel location;

    protected UserModel(Parcel in) {
        id = in.readLong();
        userName = in.readString();
        fullName = in.readString();
        avatar = in.readString();
        cover = in.readString();
        lastSync = in.readLong();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCover() {
        return cover;
    }

    public long getLastSync() {
        return lastSync;
    }

    public LocationModel getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", cover='" + cover + '\'' +
                ", lastSync=" + lastSync +
                ", location=" + location +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(userName);
        dest.writeString(fullName);
        dest.writeString(avatar);
        dest.writeString(cover);
        dest.writeLong(lastSync);
    }
}
