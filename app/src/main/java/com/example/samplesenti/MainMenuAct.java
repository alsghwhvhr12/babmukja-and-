package com.example.samplesenti;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainMenuAct extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentDashboard fragmentDashboard = new FragmentDashboard();
    private FragmentUser fragmentUser = new FragmentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(menuItem.getItemId())
            {
                case R.id.navigation_home:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.frameLayout, fragmentDashboard).commitAllowingStateLoss();
                    break;
                case R.id.navigation_user:
                    transaction.replace(R.id.frameLayout, fragmentUser).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
