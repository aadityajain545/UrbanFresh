package com.test.uebanfresh.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.uebanfresh.R;
import com.test.uebanfresh.fragment.ExploreFragment;

/**
 * This Activity is the main dashboard containing all the fragment
 * fragment -> shop, Explore, cart, favourite, account
 */
public class HomeScreenActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        fullScreen();
        initializeViews();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new ExploreFragment())
                .addToBackStack(null).commit();


    }

    private void initializeViews() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    /**
     * Method is used to get full screen
     */

    private void fullScreen() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }

    /*
     * Click of Navigation Items
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_shop:
                Toast.makeText(this, "shop", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_explore:
                Toast.makeText(this, "explore", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_cart:
                Toast.makeText(this, "cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_favourite:
                Toast.makeText(this, "Favourite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_account:
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;

    }
    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}