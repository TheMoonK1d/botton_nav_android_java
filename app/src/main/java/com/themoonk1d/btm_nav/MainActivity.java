package com.themoonk1d.btm_nav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm_nav = findViewById(R.id.bottomNavigationView);
        btm_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId()== R.id.home)
                {
                    fragment = new HomeFragment();
                }
                if(item.getItemId()== R.id.food)
                {
                    fragment = new FoodFragment();
                }
                if(item.getItemId()== R.id.store)
                {
                    fragment = new StoreFragment();
                }
                if(item.getItemId()== R.id.profile)
                {
                    fragment = new ProfileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });
        btm_nav.setSelectedItemId(R.id.home);
    }

    public void setActionBarTitle(String title){
        setTitle("Discover");
    }
}