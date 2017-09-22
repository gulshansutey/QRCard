package com.gauravsutey.www.qrcard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.qrcard.R;


public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_scan:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, com.qrcard.fragments.ScanFragment.newInstance("","")).commit();
                    if (actionBar!=null){
                        actionBar.setTitle(R.string.scan);
                       }

                    return true;
                case R.id.nav_create:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, com.qrcard.fragments.CreateCardFragment.newInstance("","")).commit();
                    if (actionBar!=null){
                        actionBar.setTitle(R.string.create);
                    }

                    return true;

            }
            return false;
        }

    };
   private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(true);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.nav_scan);
        getSupportFragmentManager().beginTransaction().add(R.id.content, com.qrcard.fragments.ScanFragment.newInstance("","")).commit();
    }

}
