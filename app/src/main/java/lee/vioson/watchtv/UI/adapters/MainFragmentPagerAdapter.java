package lee.vioson.watchtv.UI.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;

    public MainFragmentPagerAdapter(List<Fragment> fragments, FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
