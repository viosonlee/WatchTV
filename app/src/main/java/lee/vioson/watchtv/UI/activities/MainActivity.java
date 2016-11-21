package lee.vioson.watchtv.UI.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.adapters.MainFragmentPagerAdapter;
import lee.vioson.watchtv.UI.fragments.FirstFragment;

public class MainActivity extends FragmentActivity {

    private ViewPager fragmentPager;
    private MainFragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private LinearLayout tabBar;
    private TextView tab0;
    private TextView tab1;
    private TextView tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initView();
    }

    private void initViewPager() {
        fragmentPager = (ViewPager) findViewById(R.id.fragment_pager);
        FirstFragment firstFragment = FirstFragment.newInstance();
        FirstFragment firstFragment1 = FirstFragment.newInstance();
        FirstFragment firstFragment2 = FirstFragment.newInstance();

        fragmentList.add(firstFragment);
        fragmentList.add(firstFragment1);
        fragmentList.add(firstFragment2);
        fragmentPagerAdapter = new MainFragmentPagerAdapter(fragmentList, getSupportFragmentManager());
        fragmentPager.setAdapter(fragmentPagerAdapter);
    }


    private void initView() {
        tabBar = (LinearLayout) findViewById(R.id.tab_bar);
        tab0 = (TextView) findViewById(R.id.tab0);
        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tabBar.getViewTreeObserver().addOnGlobalFocusChangeListener((oldView, newView) -> {
//                    Toast.makeText(MainActivity.this, newView.getTag() + "", Toast.LENGTH_SHORT).show();
                    try {
                        fragmentPager.setCurrentItem(Integer.parseInt((String)newView.getTag()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
