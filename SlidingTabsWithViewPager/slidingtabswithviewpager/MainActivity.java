package com.example.eminesezer.slidingtabswithviewpager;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  Tab1.OnFragmentInteractionListener, Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        TabLayout tabl=(TabLayout)findViewById( R.id.tablayout );
        tabl.addTab( tabl.newTab().setText("First"));
        tabl.addTab( tabl.newTab().setText("Second"));
        tabl.addTab( tabl.newTab().setText("Third"));
        tabl.setTabGravity( TabLayout.GRAVITY_FILL );
        final ViewPager viewer=(ViewPager)findViewById( R.id.pager );
        final PageAdapter adapter=new PageAdapter( getSupportFragmentManager(),tabl.getTabCount() );
        viewer.setAdapter( adapter );
        viewer.setOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabl ) );
        tabl.setOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewer.setCurrentItem( tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
