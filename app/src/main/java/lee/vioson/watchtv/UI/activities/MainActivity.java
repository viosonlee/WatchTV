package lee.vioson.watchtv.UI.activities;


import android.graphics.Color;
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
import lee.vioson.watchtv.UI.fragments.DianBoFragment;
import lee.vioson.watchtv.UI.fragments.FirstFragment;
import lee.vioson.watchtv.UI.fragments.FirstFragmentNew;
import lee.vioson.watchtv.UI.fragments.OnlineTVFragment;
import lee.vioson.watchtv.UI.fragments.TypeFragment;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

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
        TypeFragment firstFragment = TypeFragment.newInstance();
        DianBoFragment firstFragment1 = DianBoFragment.newInstance();
        OnlineTVFragment firstFragment2 = OnlineTVFragment.newInstance();

        fragmentList.add(firstFragment);
        fragmentList.add(firstFragment1);
        fragmentList.add(firstFragment2);
        fragmentPagerAdapter = new MainFragmentPagerAdapter(fragmentList, getSupportFragmentManager());
        fragmentPager.setAdapter(fragmentPagerAdapter);
        fragmentPager.addOnPageChangeListener(this);
    }


    private void initView() {
        tabBar = (LinearLayout) findViewById(R.id.tab_bar);
        tab0 = (TextView) findViewById(R.id.tab0);
        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab0.setOnClickListener((v) -> fragmentPager.setCurrentItem(0));
        tab1.setOnClickListener((v) -> fragmentPager.setCurrentItem(1));
        tab2.setOnClickListener((v) -> fragmentPager.setCurrentItem(2));
        tabBar.getViewTreeObserver().addOnGlobalFocusChangeListener((oldView, newView) -> {
                    try {
                        fragmentPager.setCurrentItem(Integer.parseInt((String) newView.getTag()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tab0.setTextColor(Color.parseColor("#d8f407"));
                tab1.setTextColor(Color.parseColor("#ffffff"));
                tab2.setTextColor(Color.parseColor("#ffffff"));
                break;
            case 1:
                tab1.setTextColor(Color.parseColor("#d8f407"));
                tab0.setTextColor(Color.parseColor("#ffffff"));
                tab2.setTextColor(Color.parseColor("#ffffff"));
                break;
            case 2:
                tab2.setTextColor(Color.parseColor("#d8f407"));
                tab1.setTextColor(Color.parseColor("#ffffff"));
                tab0.setTextColor(Color.parseColor("#ffffff"));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
