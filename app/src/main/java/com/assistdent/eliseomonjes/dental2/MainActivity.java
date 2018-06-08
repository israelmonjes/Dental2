package com.assistdent.eliseomonjes.dental2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.assistdent.eliseomonjes.dental2.view.fragments.BlankFragment;
import com.assistdent.eliseomonjes.dental2.view.fragments.ChatFragment;
import com.assistdent.eliseomonjes.dental2.view.fragments.ClinicsFragment;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ClinicsFragment()).commit();
        }
        }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =


            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_clinics:
                            selectedFragment = new ClinicsFragment();
                            break;
                        case R.id.navigation_map:
                            selectedFragment = new ChatFragment();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new BlankFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };


}