package com.edgar.materialfun;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private final int[] selectedIconsId = {
            R.drawable.ic_airplane, R.drawable.ic_alarm, R.drawable.ic_bank, R.drawable.ic_music
    };
    private final int[] unselectedIconsId = {
            R.drawable.ic_un_airplane, R.drawable.ic_un_alarm, R.drawable.ic_un_bank, R.drawable.ic_un_music
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
        setUI();
    }

    private void setData() {
        for (int i = 0; i < 4; i++) {

            if (i == 0) {
                RitualFragment fragment = new RitualFragment();
                String tabTitle = "Ritual";
                fragment.setTabTitle(tabTitle);
                fragments.add(fragment);
                continue;
            }

            if (i == 1) {
                AlarmFragment fragment = new AlarmFragment();
                String tabTitle = "Alarm";
                fragment.setTabTitle(tabTitle);
                fragments.add(fragment);
                continue;
            }

            if (i == 2) {
                BankFragment fragment = new BankFragment();
                String tabTitle = "Bank";
                fragment.setTabTitle(tabTitle);
                fragments.add(fragment);
                continue;
            }

            if (i == 3) {
                MusicFragment fragment = new MusicFragment();
                String tabTitle = "Music";
                fragment.setTabTitle(tabTitle);
                fragments.add(fragment);
                break;
            }

//            String tabTitle = "Tab " + i;
//            MyFragment fragment = new MyFragment();
//            fragment.setTabTitle(tabTitle);
//            Bundle args = new Bundle();
//            args.putString("text", "This is " + tabTitle);
//            fragment.setArguments(args);
//            fragments.add(fragment);

        }
    }

    private void setUI() {

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        final ViewPager viewPager = (ViewPager)findViewById(R.id.my_viewpager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        final TabLayout tabLayout = (TabLayout)findViewById(R.id.my_tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(0xFFBDBDBD, 0xFFFFC107);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setTag(i);
            int resId = (i == 0) ? selectedIconsId[i] : unselectedIconsId[i];
            tab.setIcon(resId);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(selectedIconsId[(int) tab.getTag()]);
                tabLayout.setTabTextColors(0xFFBDBDBD, 0xFFFFC107);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(unselectedIconsId[(int) tab.getTag()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

}
