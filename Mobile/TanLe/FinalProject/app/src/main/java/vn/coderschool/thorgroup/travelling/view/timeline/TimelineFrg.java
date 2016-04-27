package vn.coderschool.thorgroup.travelling.view.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.adapter.HomePagerAdapter;
import vn.coderschool.thorgroup.travelling.model.PostModel;
import vn.coderschool.thorgroup.travelling.service.HttpService;
import vn.coderschool.thorgroup.travelling.service.HttpUtils;

/**
 * Created by minhtan512 on 4/12/2016.
 */
public class TimelineFrg extends Fragment {
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.pager)
    ViewPager viewPager;

    public static TimelineFrg newInstance() {
        return new TimelineFrg();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        ButterKnife.bind(this, view);

        fetchFeeds();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void fetchFeeds() {
        HttpService.getInstance().getFeeds(new HttpUtils.IResultListener() {
            @Override
            public void onSuccess(String json) {
                try {
                    String array = new JSONObject(json).getJSONArray("posts").toString();
                    Type type = new TypeToken<List<PostModel>>() {
                    }.getType();
                    List<PostModel> posts = new Gson().fromJson(array, type);

                    initViewPager(posts);
                } catch (JSONException e) {
                    Log.e("DEBUG", "Fetch Feeds fail!", e);
                }
            }

            @Override
            public void onFail(Exception e) {
                Log.e("DEBUG", "Fetch Feeds fail!", e);
            }
        });
    }

    private void initViewPager(List<PostModel> posts) {
        tabLayout.addTab(tabLayout.newTab().setText("feed"));
        tabLayout.addTab(tabLayout.newTab().setText("location"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager(), posts, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
