package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;
import com.example.samplesenti.presenter.piListPresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PiActivity extends AppCompatActivity {
    private ListView listView1;
    private piListPresenter adapter1;
    private Inflater inflater;
    private List<Menu> menuList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi);

        Intent intent = getIntent();

        listView1 = (ListView)findViewById(R.id.lvPi1);
        menuList1 = new ArrayList<Menu>();

        adapter1 = new piListPresenter(getApplicationContext(), menuList1, this);

        listView1.setAdapter(adapter1);

        try{
            //intent로 값을 가져옵니다 이때 JSONObject타입으로 가져옵니다
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("piList"));


            //List.php 웹페이지에서 response라는 변수명으로 JSON 배열을 만들었음..
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;

            String piNo, piK_id, piCompany_no, piName, piPrice;

            //JSON 배열 길이만큼 반복문을 실행
            while(count < jsonArray.length()){
                //count는 배열의 인덱스를 의미
                JSONObject object = jsonArray.getJSONObject(count);

                piNo = object.getString("no");
                piK_id = object.getString("k_id");
                piCompany_no = object.getString("company_no");//여기서 ID가 대문자임을 유의
                piName = object.getString("name");
                piPrice = object.getString("price");

                //값들을 User클래스에 묶어줍니다
                Menu menu = new Menu(piNo, piK_id, piCompany_no, piName, piPrice);
                if(piK_id.equals("5")) {
                    menuList1.add(menu);//리스트뷰에 값을 추가해줍니다
                }

                count++;
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        //학식메뉴를 눌렀을때 넘어가는 창
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
                Menu menu = (Menu) menuList1.get(position);
                Intent intent = new Intent(view.getContext(),HakDetailActivity.class);
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        });
        Toolbar mToolbar = (Toolbar) findViewById(R.id.MpiEtb);
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
