package vn.creative.instagram.photoviewer.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import vn.creative.instagram.photoviewer.R;
import vn.creative.instagram.photoviewer.adapter.PopularPhotoAdapter;
import vn.creative.instagram.photoviewer.model.PopularPhotoModel;

/**
 * Created by minhtan512 on 3/14/2016.
 */
public class PopularPhotoFrg extends Fragment {
    private SwipeRefreshLayout swipeContainer;
    private ListView lvPost;
    private PopularPhotoAdapter popularPhotoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_photo_frg, null);

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchTimelineAsync();
            }
        });

        lvPost = (ListView) view.findViewById(R.id.lv_post);
        fetchTimelineAsync();

        return view;
    }

    public void fetchTimelineAsync() {
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get("https://api.instagram.com/v1/media/popular?client_id=e05c462ebd86446ea48a5af73769b602", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    Type type = new TypeToken<List<PopularPhotoModel>>() {
                    }.getType();
                    List<PopularPhotoModel> popularPhotos = new Gson().fromJson(response.getJSONArray("data").toString(), type);
                    popularPhotoAdapter = new PopularPhotoAdapter(getContext(), popularPhotos);
                    lvPost.setAdapter(popularPhotoAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                swipeContainer.setRefreshing(false);
            }
        });
    }
}
