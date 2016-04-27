package vn.coderschool.thorgroup.travelling.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.adapter.PhotosAdapter;
import vn.coderschool.thorgroup.travelling.model.PhotoModel;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by ADMIN on 4/19/2016.
 */
public class PhotosFragment extends Fragment {

    ArrayList<PhotoModel> photos;
    ArrayList<PostModel> posts;
    PhotosAdapter photosAdapter;
    ListView lvPhotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        photos = new ArrayList<PhotoModel>();
        posts = new ArrayList<PostModel>();
        photosAdapter = new PhotosAdapter(getActivity(), photos, posts);
        lvPhotos = (ListView) getView().findViewById(R.id.lvPhotos);
        lvPhotos.setAdapter(photosAdapter);
    }

    /* TODO LIST
     * handle action browser existing image
     * handle action take picture image from camera
     * add reaction image category
     */
}
