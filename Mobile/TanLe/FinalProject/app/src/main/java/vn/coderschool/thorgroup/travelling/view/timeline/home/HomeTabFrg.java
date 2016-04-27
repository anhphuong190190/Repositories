package vn.coderschool.thorgroup.travelling.view.timeline.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.adapter.FeedsAdapter;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by minhtan512 on 4/12/2016.
 */
public class HomeTabFrg extends Fragment {
    @Bind(R.id.tab_home_rv_feeds)
    RecyclerView rvFragmentFeeds;
    private static List<PostModel> mPostList;
    private FeedsAdapter feedsAdapter;

    public static HomeTabFrg newInstance(List<PostModel> posts) {
        mPostList = posts;
        return new HomeTabFrg();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        feedsAdapter = new FeedsAdapter(mPostList);
        rvFragmentFeeds.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFragmentFeeds.setAdapter(feedsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
