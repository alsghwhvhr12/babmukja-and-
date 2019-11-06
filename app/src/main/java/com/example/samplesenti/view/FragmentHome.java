package com.example.samplesenti.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.samplesenti.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FragmentHome extends Fragment  {


    public int i = 0;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        final ImageButton hak = (ImageButton) view.findViewById(R.id.imageButton3);
        final ImageButton pig = (ImageButton) view.findViewById(R.id.imageButton2);
        final ImageButton min = (ImageButton)view.findViewById(R.id.imageButton);
        final Button map = (Button)view.findViewById(R.id.map);

        hak.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i=1;
                new BackgroundTask().execute();
                }
        });

        min.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i=2;
                new BackgroundTask().execute();
            }
        });

        pig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i=3;
                new BackgroundTask().execute();
            }
        });

        map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),MapActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            //List.php은 파싱으로 가져올 웹페이지
            target = "http://babmukja.pe.kr/menu_list.php";
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
                Intent intent = new Intent(getActivity(), HakActivity.class);
                intent.putExtra("hakList", result);//파싱한 값을 넘겨줌
                startActivity(intent);//ManagementActivity로 넘어감
            }
            else if(i==2){
                Intent intent = new Intent(getActivity(), MinActivity.class);
                intent.putExtra("minList", result);//파싱한 값을 넘겨줌
                startActivity(intent);//ManagementActivity로 넘어감
            }
            else if(i==3){
                Intent intent = new Intent(getActivity(), PiActivity.class);
                intent.putExtra("piList", result);//파싱한 값을 넘겨줌
                startActivity(intent);//ManagementActivity로 넘어감
            }

        }

    }
}
