package vn.coderschool.thorgroup.travelling.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by minhtan512 on 4/10/2016.
 */
public class PostModel implements Parcelable{
    @SerializedName("posts")
    List<PostModel> posts;

    @SerializedName("id")
    private long id;

    @SerializedName("created_at")
    private long createdAt;

    @SerializedName("status")
    private String status;

    @SerializedName("image_url")
    private String image;

    @SerializedName("user")
    private UserModel owner;

    @SerializedName("reaction")
    private String reaction;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("latitude")
    private double latitude;

//    private LocationModel location;

    public PostModel(){

    }

    protected PostModel(Parcel in) {
        posts = in.createTypedArrayList(PostModel.CREATOR);
        id = in.readLong();
        createdAt = in.readLong();
        status = in.readString();
        image = in.readString();
        reaction = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        owner = in.readParcelable(UserModel.class.getClassLoader());
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public String getImages() {
        return image;
    }

    public UserModel getOwner() {
        return owner;
    }

    public String getReaction() {
        return reaction;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //    public LocationModel getLocation(){
//        return location;
//    }
    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", images=" + image +
                ", owner=" + owner +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(posts);
        dest.writeLong(id);
        dest.writeLong(createdAt);
        dest.writeString(status);
        dest.writeString(image);
        dest.writeString(reaction);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeParcelable(owner,flags);
    }
}
