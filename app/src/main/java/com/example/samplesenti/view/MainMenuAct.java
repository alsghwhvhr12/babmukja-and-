//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.samplesenti.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuAct extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager(); //프레그먼트 선언
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
        //이름or 아이디값을 받아옴
       Intent intent = getIntent();
        Long Id=intent.getExtras().getLong("userid"+"");
        TextView tvId= (TextView) findViewById(R.id.tvName);
         tvId.setText(Id+"");
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
