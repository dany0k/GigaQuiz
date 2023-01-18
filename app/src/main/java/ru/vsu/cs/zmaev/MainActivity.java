package ru.vsu.cs.zmaev;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import kotlin.Suppress;
import ru.vsu.cs.zmaev.databinding.ActivityMainBinding;
import ru.vsu.cs.zmaev.model.MyDrawerController;

public class MainActivity extends AppCompatActivity implements MyDrawerController {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @Suppress(names = "UNUSED_VARIABLE")
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        return NavigationUI.navigateUp(navController, drawerLayout);
    }

    @Override
    public void setDrawerLocked() {
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDrawerUnlocked() {
        bottomNavigationView.setVisibility(View.GONE);
    }
}