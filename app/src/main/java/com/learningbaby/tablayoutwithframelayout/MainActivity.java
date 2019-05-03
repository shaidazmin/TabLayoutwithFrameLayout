package com.learningbaby.tablayoutwithframelayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablLayout);
        frameLayout = findViewById(R.id.frameLayout);

        fragment  = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                    {
                        fragment = new HomeFragment();
                        Toast.makeText(getApplicationContext(),"Home is Selected",Toast.LENGTH_LONG).show();
                        break;
                    } case 1:
                    {
                        fragment = new JavaFragment();
                        Toast.makeText(getApplicationContext(),"Java is Selected",Toast.LENGTH_LONG).show();
                        break;
                    } case 2:
                    {
                        fragment = new AndroidFragment();
                        Toast.makeText(getApplicationContext(),"Android is Selected",Toast.LENGTH_LONG).show();
                        break;
                    }
                }// close switch ..

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();

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
