package com.example.usafety;

import static androidx.core.content.ContextCompat.getSystemService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.usafety_app_icon);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnav =  findViewById(R.id.bottomNavigation);
        bottomnav.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        switch (id){
            case R.id.homeFrag:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
                return true;
            case R.id.dashboardFrag:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Dashboard()).commit();
                return true;
            case R.id.actionFrag:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Action()).commit();
                return true;
            case R.id.settingsFrag:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Setings()).commit();
                return true;
        }
        return false;
    }


}