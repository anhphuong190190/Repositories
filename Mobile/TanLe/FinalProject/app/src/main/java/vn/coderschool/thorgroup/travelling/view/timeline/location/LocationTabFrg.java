package vn.coderschool.thorgroup.travelling.view.timeline.location;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.common.CommonUtils;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by minhtan512 on 4/12/2016.
 */
public class LocationTabFrg extends Fragment implements OnMapReadyCallback {
    private static final float ZOOM_LEVEL_WORLD = 1;
    private static final float ZOOM_LEVEL_LANDMASS = 5;
    private static final float ZOOM_LEVEL_CITY = 10;
    private static final float ZOOM_LEVEL_STREETS = 15;
    private static final float ZOOM_LEVEL_BUILDINGS = 20;

    private static List<PostModel> mPostList;
    private ClusterManager<MarkerItem> mClusterManager;

    public static LocationTabFrg newInstance(List<PostModel> posts) {
        mPostList = posts;
        return new LocationTabFrg();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_location, container, false);
        ButterKnife.bind(this, view);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng userLocation = CommonUtils.getLocation(getActivity());
        if (userLocation != null) {
            // add marker
            MarkerOptions marker = new MarkerOptions().position(userLocation).title("Current location");
            googleMap.addMarker(marker);

            // move camera to location
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, ZOOM_LEVEL_STREETS));

            mClusterManager = new ClusterManager<>(getContext(), googleMap);
            mClusterManager.setRenderer(new OwnIconRendered(getContext(), googleMap, mClusterManager));

            // Point the map's listeners at the listeners implemented by the cluster manager.
            googleMap.setOnCameraChangeListener(mClusterManager);
            googleMap.setOnMarkerClickListener(mClusterManager);

            // Add cluster items (markers) to the cluster manager.
            if (mPostList != null && !mPostList.isEmpty()) {
                for (PostModel post : mPostList) {
                    MarkerItem offsetItem = new MarkerItem(post.getLatitude(), post.getLongitude());
                    offsetItem.setIcon(post.getImages());
                    mClusterManager.addItem(offsetItem);
                }
            }
        }
    }
}
