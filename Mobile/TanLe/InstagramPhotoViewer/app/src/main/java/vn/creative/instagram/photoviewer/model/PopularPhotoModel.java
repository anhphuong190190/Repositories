package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class PopularPhotoModel {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("created_time")
    private long createdTime;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("images")
    private ImageModel images;

    @SerializedName("caption")
    private CaptionModel caption;

    @SerializedName("likes")
    private LikeModel likes;

    @SerializedName("comments")
    private CommentModel comments;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public UserModel getUser() {
        return user;
    }

    public ImageModel getImages() {
        return images;
    }

    public CaptionModel getCaption() {
        return caption;
    }

    public LikeModel getLikes() {
        return likes;
    }

    public CommentModel getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "PopularPhotoModel{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", createdTime=" + createdTime +
                ", user=" + user +
                ", images=" + images +
                ", caption=" + caption +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
