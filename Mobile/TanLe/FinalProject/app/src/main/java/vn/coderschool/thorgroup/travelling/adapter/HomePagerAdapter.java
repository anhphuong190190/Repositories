package vn.coderschool.thorgroup.travelling.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import vn.coderschool.thorgroup.travelling.model.PostModel;
import vn.coderschool.thorgroup.travelling.view.timeline.home.HomeTabFrg;
import vn.coderschool.thorgroup.travelling.view.timeline.location.LocationTabFrg;

/**
 * Created by minhtan512 on 4/12/2016.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private int nTabCount;

    private List<PostModel> mPostList;

    public HomePagerAdapter(FragmentManager fm, List<PostModel> posts, int tabCount) {
        super(fm);
        nTabCount = tabCount;
        mPostList = posts;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeTabFrg.newInstance(mPostList);

            case 1:
                return LocationTabFrg.newInstance(mPostList);

            default:
                return HomeTabFrg.newInstance(mPostList);
        }
    }

    @Override
    public int getCount() {
        return nTabCount;
    }
}
