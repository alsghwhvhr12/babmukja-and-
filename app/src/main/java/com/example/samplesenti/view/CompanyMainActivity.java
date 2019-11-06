//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//
package com.example.samplesenti.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.samplesenti.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CompanyMainActivity extends AppCompatActivity {
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);

        Button btn_insert = (Button) findViewById(R.id.mInsert);
        btn_insert.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        i=2;
                        new BackgroundTask().execute();
                    }
                }
        );
        Button btn_edit = (Button) findViewById(R.id.mEdit);
        btn_edit.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        i=1;
                        new BackgroundTask().execute();
                    }
                }
        );
        Button btn_logout = (Button) findViewById(R.id.cLogout);
        btn_logout.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            //List.php은 파싱으로 가져올 웹페이지
            if(i==1) {
                target = "http://babmukja.pe.kr/menu_list.php";
            }
            else if(i==2){
                target = "http://babmukja.pe.kr/com_list.php";
            }
        }

        @Override
        protected String doInBackground(Void... voids) {

            try{
                URL url = new URL(target);//URL 객체 생성

                //URL을 이용해서 웹페이지에 연결하는 부분
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                //바이트단위 입력스트림 생성 소스는 httpURLConnection
                InputStream inputStream = httpURLConnection.getInputStream();

                //웹페이지 출력물을 버퍼로 받음 버퍼로 하면 속도가 더 빨라짐
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;

                //문자열 처리를 더 빠르게 하기 위해 StringBuilder클래스를 사용함
                StringBuilder stringBuilder = new StringBuilder();

                //한줄씩 읽어서 stringBuilder에 저장함
                while((temp = bufferedReader.readLine()) != null){
                    stringBuilder.append(temp + "\n");//stringBuilder에 넣어줌
                }

                //사용했던 것도 다 닫아줌
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();//trim은 앞뒤의 공백을 제거함

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            if(i==1) {
                i=0;
                Intent intent = new Intent(CompanyMainActivity.this, MenuEditActivity.class);
                intent.putExtra("menuList", result);//파싱한 값을 넘겨줌
                CompanyMainActivity.this.startActivity(intent);//ManagementActivity로 넘어감
            }
            else if(i==2){
                i=0;
                Intent intent = new Intent(CompanyMainActivity.this, MenuRegisterActivity.class);
                intent.putExtra("companyList", result);//파싱한 값을 넘겨줌
                CompanyMainActivity.this.startActivity(intent);//ManagementActivity로 넘어감
                finish();
            }

        }

    }
}
