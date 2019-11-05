//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

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
import com.example.samplesenti.model.Notice;
import com.example.samplesenti.presenter.mNoticeListPresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class NoticeActivity extends AppCompatActivity {

    private ListView listView;
    private mNoticeListPresenter adapter;
    private Inflater inflater;
    private List<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Intent intent = getIntent();

        listView = (ListView)findViewById(R.id.lvNotice);
        noticeList = new ArrayList<Notice>();

        adapter = new mNoticeListPresenter(getApplicationContext(), noticeList, this);
        listView.setAdapter(adapter);

        try{
            //intent로 값을 가져옵니다 이때 JSONObject타입으로 가져옵니다
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("noticeList"));


            //List.php 웹페이지에서 response라는 변수명으로 JSON 배열을 만들었음..
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;

            String nNo, nTitle, nNotice;

            //JSON 배열 길이만큼 반복문을 실행
            while(count < jsonArray.length()){
                //count는 배열의 인덱스를 의미
                JSONObject object = jsonArray.getJSONObject(count);

                nNo = object.getString("no");
                nTitle = object.getString("title");//여기서 ID가 대문자임을 유의
                nNotice = object.getString("notice");

                //값들을 User클래스에 묶어줍니다
                Notice notice = new Notice(nNo, nTitle, nNotice);
                noticeList.add(notice);//리스트뷰에 값을 추가해줍니다
                count++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
                Notice notice = (Notice) noticeList.get(position);
                Intent intent = new Intent(view.getContext(),NoticeDetailActivity.class);
                intent.putExtra("notice", notice);
                startActivity(intent);
            }
        });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.noticetb);
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
