package vn.coderschool.thorgroup.travelling.view.timeline.location;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.io.IOException;
import java.net.URL;

/**
 * Created by tanlnm on 4/21/2016.
 */
public class MarkerItem implements ClusterItem {
    private final LatLng mPosition;
    private BitmapDescriptor icon;

    public MarkerItem(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    public BitmapDescriptor getIcon() {
        return icon;
    }

    public void setIcon(String url) {
        try {
            Bitmap bmp = BitmapFactory.decodeStream(new URL(url).openConnection().getInputStream());
            bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false);
            this.icon = BitmapDescriptorFactory.fromBitmap(bmp);
        } catch (Exception e) {
            Log.e("DEBUG", "Set marker icon fail", e);
        }
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
