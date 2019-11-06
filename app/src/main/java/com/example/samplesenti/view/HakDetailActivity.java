package com.example.samplesenti.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;
import com.example.samplesenti.model.Order;

import java.util.ArrayList;
import java.util.List;

public class HakDetailActivity extends AppCompatActivity {

   private SharedPreferences pref,count ;
    private SharedPreferences.Editor editor ;
    private TextView detailHakName;
    private TextView detailHakPrice;
    private Button btnOrder;
    private List<Order> orderList;
    private List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hak_detail);
        final int checkCount;

        pref=getSharedPreferences("com.example.samplesenti",MODE_PRIVATE);
        editor = pref.edit();
        checkCount =  pref.getInt("checkCount",0);
        detailHakName = (TextView) findViewById(R.id.detailHakName);
        detailHakPrice = (TextView) findViewById(R.id.detailHakPrice);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        Intent intent = getIntent();
        final Menu menu = (Menu) intent.getSerializableExtra("menu");

       detailHakName.setText(menu.getName());
        detailHakPrice.setText(menu.getPrice());

        Toolbar mToolbar = (Toolbar) findViewById(R.id.detailmeEtb);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnOrder.setOnClickListener(new View.OnClickListener() {
             @Override
               public void onClick(View view) {
                if(checkCount==0) {
                    editor.putString("cname0", detailHakPrice.getText().toString());
                    editor.putString("cprice0", detailHakName.getText().toString());
                    editor.putInt("checkCount", checkCount + 1);
                    editor.commit();
                }else if(checkCount==1){
                    editor.putString("cname1", detailHakPrice.getText().toString());
                    editor.putString("cprice1", detailHakName.getText().toString());
                    editor.putInt("checkCount", checkCount + 1);
                    editor.commit();
                }else if(checkCount==2) {
                    editor.putString("cname2", detailHakPrice.getText().toString());
                    editor.putString("cprice2", detailHakName.getText().toString());
                    editor.putInt("checkCount", checkCount + 1);
                    editor.commit();
                }else if(checkCount==3) {
                    editor.putString("cname3", detailHakPrice.getText().toString());
                    editor.putString("cprice3", detailHakName.getText().toString());
                    editor.putInt("checkCount", checkCount + 1);
                    editor.commit();
                }else if(checkCount==4) {
                    editor.putString("cname4", detailHakPrice.getText().toString());
                    editor.putString("cprice4", detailHakName.getText().toString());
                    editor.putInt("checkCount", checkCount + 1);
                    editor.commit();
                }
                 Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                 intent.putExtra("oname",detailHakName.getText().toString());
                 intent.putExtra("oprice",detailHakPrice.getText().toString());

                 startActivity(intent);
  }
    });

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
