package com.itsvks.stringtranslator.activities;

import android.os.Bundle;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itsvks.stringtranslator.R;
import com.itsvks.stringtranslator.adapters.MainPagerAdapter;
import com.itsvks.stringtranslator.databinding.ActivityMainBinding;
import com.itsvks.stringtranslator.ui.dashboard.DashboardFragment;
import com.itsvks.stringtranslator.ui.home.HomeFragment;
import com.itsvks.stringtranslator.ui.notifications.NotificationsFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    private BottomNavigationView navView;
    private ViewPager2 pager;
    private MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = binding.navView;
        pager = binding.pager;
        adapter = new MainPagerAdapter(getSupportFragmentManager(), getLifecycle());

        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new DashboardFragment());
        adapter.addFragment(new NotificationsFragment());

        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        pager.setAdapter(adapter);

        pager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {

                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                        switch (position) {
                            case 0:
                                navView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                                break;
                            case 1:
                                navView.getMenu()
                                        .findItem(R.id.navigation_dashboard)
                                        .setChecked(true);
                                break;
                            case 2:
                                navView.getMenu()
                                        .findItem(R.id.navigation_notifications)
                                        .setChecked(true);
                                break;
                        }
                    }
                });

        navView.setOnItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            pager.setCurrentItem(0);
                            break;
                        case R.id.navigation_dashboard:
                            pager.setCurrentItem(1);
                            break;
                        case R.id.navigation_notifications:
                            pager.setCurrentItem(2);
                            break;
                    }
                    return true;
                });
    }
}
