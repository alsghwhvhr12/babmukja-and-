package com.example.samplesenti.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.samplesenti.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuAct extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentDashboard fragmentDashboard = new FragmentDashboard();
    private FragmentUser fragmentUser = new FragmentUser();
    private FragmentNotice fragmentNotice = new FragmentNotice();
    private FragmentHistory fragmentHistory = new FragmentHistory();
    private FragmentMy fragmentMy = new FragmentMy();
    private FragmentVersion fragmentVersion = new FragmentVersion();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    public void replaceF(View view){
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setVisibility(view.GONE);
        switch(view.getId()){
            case R.id.notice:
                transaction2.replace(R.id.frameLayout2, fragmentNotice).commitAllowingStateLoss();
                break;
            case R.id.history:
                transaction2.replace(R.id.frameLayout2, fragmentHistory).commitAllowingStateLoss();
                break;
            case R.id.my:
                transaction2.replace(R.id.frameLayout2, fragmentMy).commitAllowingStateLoss();
                break;
            case R.id.version:
                transaction2.replace(R.id.frameLayout2, fragmentVersion).commitAllowingStateLoss();
                break;
        }
    }

    public void goBack(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setVisibility(view.VISIBLE);
        switch (view.getId()){
            case R.id.goBack: //toolbar의 back키 눌렀을 때 동작
                transaction.remove(fragmentNotice).commitAllowingStateLoss();
                break;
            case R.id.goBack1: //toolbar의 back키 눌렀을 때 동작
                transaction.remove(fragmentHistory).commitAllowingStateLoss();
                break;
            case R.id.goBack2: //toolbar의 back키 눌렀을 때 동작
                transaction.remove(fragmentMy).commitAllowingStateLoss();
                break;
            case R.id.goBack3: //toolbar의 back키 눌렀을 때 동작
                transaction.remove(fragmentVersion).commitAllowingStateLoss();
                break;
        }
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
