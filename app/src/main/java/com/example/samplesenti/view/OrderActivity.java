package com.example.samplesenti.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;
import com.example.samplesenti.model.Order;
import com.example.samplesenti.presenter.mOrderListPresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private ListView lvOrder1;
    private mOrderListPresenter adapter1;
    private ArrayList<String> orderList1;
    private SharedPreferences pref ;
    private Button btnBuy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        btnBuy=(Button)findViewById(R.id.btnBuy);
        pref=getSharedPreferences("com.example.samplesenti",MODE_PRIVATE);
        Intent intent = getIntent();
 //       adapter1 = new mOrderListPresenter(getApplicationContext(), orderList1, this);


     //   String name = intent.getStringExtra("oname");
    //    String price = intent.getStringExtra("oprice");

        lvOrder1 = (ListView)findViewById(R.id.lvOrder1);
        orderList1 = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,orderList1);
        lvOrder1.setAdapter(adapter);

        String name0 = pref.getString("cname0","").toString();
        String price0 = pref.getString("cprice0","").toString();

        String name1 = pref.getString("cname1", "").toString();
        String price1 = pref.getString("cprice1","").toString();

        String name2 = pref.getString("cname2","").toString();
        String price2 = pref.getString("cprice2","").toString();

        String name3 = pref.getString("cname3","").toString();
        String price3 = pref.getString("cprice3","").toString();

        String name4 = pref.getString("cname4","").toString();
        String price4 = pref.getString("cprice4","").toString();


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
                pref=getSharedPreferences("com.example.samplesenti",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
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
