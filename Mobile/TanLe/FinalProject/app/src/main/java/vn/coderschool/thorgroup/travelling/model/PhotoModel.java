package vn.coderschool.thorgroup.travelling.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by minhtan512 on 4/10/2016.
 */
public class PhotoModel {
    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("image_url")
    private String url;

    @SerializedName("location")
    private LocationModel location;

    @SerializedName("timestamp")
    private long timestamp;

    private JSONArray photoArray;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LocationModel getLocation() {
        return location;
    }

    public String getPhotoUrl() {
        try {
            return getPhotoMeta().getString("url");
        } catch (Exception e) {
            return null;
        }
    }

    private JSONObject getPhotoMeta() {
        try {
            JSONArray altSizes = ((JSONObject) photoArray.get(0))
                    .getJSONArray("alt_sizes");
            for (int i = 0; i < altSizes.length(); i++) {
                JSONObject altSize = (JSONObject) altSizes.get(i);
                int width = altSize.getInt("width");
                if (width < 1000) {
                    return altSize;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
