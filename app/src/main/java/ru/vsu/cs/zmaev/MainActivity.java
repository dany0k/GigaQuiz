package ru.vsu.cs.zmaev;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.JsonWriter;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.vsu.cs.zmaev.databinding.ActivityMainBinding;
import ru.vsu.cs.zmaev.model.JsonAdapter;
import ru.vsu.cs.zmaev.model.MyDrawerController;

public class MainActivity extends AppCompatActivity implements MyDrawerController {

    ActivityMainBinding binding;

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Bottom Navigation
        NavController bottomNavController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupWithNavController(binding.bottomNavView, bottomNavController);
        bottomNavigationView = binding.bottomNavView;
        // In game navigation
        NavController upperNavController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupActionBarWithNavController(this, upperNavController, drawerLayout);
        NavigationUI.setupWithNavController(binding.upperNavView, upperNavController);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (!JsonAdapter.isFilePresent(this, "user.json")) {
            setDrawerLocked();
        }
        // User
        JsonAdapter.clearMyFiles(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        return NavigationUI.navigateUp(navController, drawerLayout);
    }

    @Override
    public void setDrawerUnlocked() {
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDrawerLocked() {
        bottomNavigationView.setVisibility(View.GONE);
    }

}