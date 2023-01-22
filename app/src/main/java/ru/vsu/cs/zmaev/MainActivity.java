package ru.vsu.cs.zmaev;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import ru.vsu.cs.zmaev.databinding.ActivityMainBinding;
import ru.vsu.cs.zmaev.tools.FileTools;
import ru.vsu.cs.zmaev.model.MyDrawerController;

public class MainActivity extends AppCompatActivity implements MyDrawerController {

    ActivityMainBinding binding;

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("gigaquiz.db", MODE_PRIVATE, null);
//        DataBaseTools.createDB(db);
//        DataBaseTools.populateDB(db);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        deleteDatabase("gigaquiz.db");
        NavController bottomNavController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, bottomNavController);
        bottomNavigationView = binding.bottomNavigationView;
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setVisible(false);
        binding.fab.setOnClickListener(v -> {
            NavigationUI.navigateUp(bottomNavController, drawerLayout);
        });
        // Bottom Navigation

        // In game navigation
        NavController upperNavController = Navigation.findNavController(this, R.id.myNavHostFragment);
        NavigationUI.setupActionBarWithNavController(this, upperNavController, drawerLayout);
        NavigationUI.setupWithNavController(binding.upperNavView, upperNavController);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (!FileTools.isFilePresent(this, "user.json")) {
            setDrawerLocked();
        }
        setDrawerUnlocked();
        // DataBase
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.myNavHostFragment);
        return NavigationUI.navigateUp(navController, drawerLayout);
    }

    @Override
    public void setDrawerUnlocked() {
        binding.bottomNavCL.setVisibility(View.VISIBLE);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDrawerLocked() {
        binding.bottomNavCL.setVisibility(View.GONE);
        bottomNavigationView.setVisibility(View.GONE);
    }

}