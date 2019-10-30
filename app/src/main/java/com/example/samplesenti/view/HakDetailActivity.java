package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;

public class HakDetailActivity extends AppCompatActivity {

    private TextView detailHakID;
    private TextView detailHakCompany_no;
    private TextView detailHakName;
    private TextView detailHakPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hak_detail);

        detailHakID = (TextView) findViewById(R.id.detailHakID);
        detailHakCompany_no = (TextView) findViewById(R.id.detailHakCompany_no);
        detailHakName = (TextView) findViewById(R.id.detailHakName);
        detailHakPrice = (TextView) findViewById(R.id.detailHakPrice);

        Intent intent = getIntent();

        Menu menu = (Menu) intent.getSerializableExtra("menu");

        detailHakID.setText(menu.getNo());
        detailHakCompany_no.setText(menu.getCompany_no());
        detailHakName.setText(menu.getName());
        detailHakPrice.setText(menu.getPrice());

        Toolbar mToolbar = (Toolbar) findViewById(R.id.detailmeEtb);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
