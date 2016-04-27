package vn.coderschool.thorgroup.travelling.view.timeline.location;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

/**
 * Created by tanlnm on 4/22/2016.
 */
public class OwnIconRendered extends DefaultClusterRenderer<MarkerItem> {
    public OwnIconRendered(Context context, GoogleMap map, ClusterManager<MarkerItem> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(MarkerItem item, MarkerOptions markerOptions) {
        markerOptions.icon(item.getIcon());
        super.onBeforeClusterItemRendered(item, markerOptions);
    }
}
