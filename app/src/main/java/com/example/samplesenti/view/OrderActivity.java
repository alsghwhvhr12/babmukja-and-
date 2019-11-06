package com.example.samplesenti.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.R;
import com.example.samplesenti.presenter.mOrderListPresenter;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private ListView lvOrder1;
    private mOrderListPresenter adapter1;
    private ArrayList<String> orderList1;
    private SharedPreferences pref,history ;
    private Button btnBuy;

    String name0,name1,name2,name3,name4,price0,price1,price2,price3,price4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        btnBuy=(Button)findViewById(R.id.btnBuy);

        pref=getSharedPreferences("com.example.samplesenti",MODE_PRIVATE);
        history=getSharedPreferences("HISTORY",MODE_PRIVATE);

        final Intent intent = getIntent();
 //       adapter1 = new mOrderListPresenter(getApplicationContext(), orderList1, this);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.MmeEtb);
        setSupportActionBar(mtoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //   String name = intent.getStringExtra("oname");
    //    String price = intent.getStringExtra("oprice");

        lvOrder1 = (ListView)findViewById(R.id.lvOrder1);
        orderList1 = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,orderList1);
        lvOrder1.setAdapter(adapter);

       name0 = pref.getString("cname0","").toString();
       price0 = pref.getString("cprice0","").toString();

         name1 = pref.getString("cname1", "").toString();
         price1 = pref.getString("cprice1","").toString();

         name2 = pref.getString("cname2","").toString();
         price2 = pref.getString("cprice2","").toString();

         name3 = pref.getString("cname3","").toString();
         price3 = pref.getString("cprice3","").toString();

         name4 = pref.getString("cname4","").toString();
         price4 = pref.getString("cprice4","").toString();


        orderList1.add("상품명:" + name0);
        orderList1.add("가격:" + price0);

        orderList1.add("상품명:" + name1);
        orderList1.add("가격:" + price1);

        orderList1.add("상품명:" + name2);
        orderList1.add("가격:" + price2);

        orderList1.add("상품명:" + name3);
        orderList1.add("가격:" + price3);

        orderList1.add("상품명:" + name4);
        orderList1.add("가격:" + price4);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref = getSharedPreferences("com.example.samplesenti", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                SharedPreferences.Editor his_editor = history.edit();

                    his_editor.putString("hname0", name0);
                    his_editor.putString("hprice0", price0);
                    his_editor.putString("hname1", name1);
                    his_editor.putString("hprice1", price1);
                    his_editor.putString("hname2", name2);
                    his_editor.putString("hprice2", price2);
                    his_editor.putString("hname3", name3);
                    his_editor.putString("hprice3", price3);
                    his_editor.putString("hname4", name4);
                    his_editor.putString("hprice4", price4);


                his_editor.commit();
                editor.clear();
                editor.commit();
                finish();
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
