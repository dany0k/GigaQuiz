package ru.vsu.cs.zmaev;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.navigation.NavigationBarView;

import kotlin.Suppress;
import ru.vsu.cs.zmaev.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @Suppress(names = "UNUSED_VARIABLE")
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        return NavigationUI.navigateUp(navController, drawerLayout);
    }
}