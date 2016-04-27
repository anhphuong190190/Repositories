package vn.creative.instagram.photoviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by minhtan512 on 3/13/2016.
 */
public class CommentModel {
    @SerializedName("count")
    private int count;

    @SerializedName("data")
    private CaptionModel[] captions;

    public int getCount() {
        return count;
    }

    public CaptionModel[] getCaptions() {
        return captions;
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "count=" + count +
                ", captions=" + Arrays.toString(captions) +
                '}';
    }
}
