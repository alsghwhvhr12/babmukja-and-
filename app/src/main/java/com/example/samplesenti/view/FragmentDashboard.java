//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;
import com.example.samplesenti.presenter.dMenuListPresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentDashboard extends Fragment {
    private ListView listView1;
    private ListView listView2;
    private ListView listView3;
    private dMenuListPresenter adapter1;
    private dMenuListPresenter adapter2;
    private dMenuListPresenter adapter3;
    private List<Menu> menuList1;
    private List<Menu> menuList2;
    private List<Menu> menuList3;
    private ArrayList<Menu> tempList1;
    private ArrayList<Menu> tempList2;
    private ArrayList<Menu> tempList3;
    private EditText editSearch;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);

        listView1 = (ListView)view.findViewById(R.id.lvFood1);
        listView2 = (ListView)view.findViewById(R.id.lvFood2);
        listView3 = (ListView)view.findViewById(R.id.lvFood3);
        menuList1 = new ArrayList<Menu>();
        menuList2 = new ArrayList<Menu>();
        menuList3 = new ArrayList<Menu>();

        editSearch = (EditText)view.findViewById(R.id.editSearch);

        tempList1 = new ArrayList<Menu>();
        tempList2 = new ArrayList<Menu>();
        tempList3 = new ArrayList<Menu>();



        adapter1 = new dMenuListPresenter(getContext(), menuList1, getActivity());
        adapter2 = new dMenuListPresenter(getContext(), menuList2, getActivity());
        adapter3 = new dMenuListPresenter(getContext(), menuList3, getActivity());

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);

        try{
            //intent로 값을 가져옵니다 이때 JSONObject타입으로 가져옵니다
            JSONObject jsonObject = new JSONObject(getArguments().getString("foodList"));


            //List.php 웹페이지에서 response라는 변수명으로 JSON 배열을 만들었음..
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;

            String foodNo, foodK_id, foodCompany_no, foodName, foodPrice;

            //JSON 배열 길이만큼 반복문을 실행
            while(count < jsonArray.length()){
                //count는 배열의 인덱스를 의미
                JSONObject object = jsonArray.getJSONObject(count);

                foodNo = object.getString("no");
                foodCompany_no = object.getString("company_no");//여기서 ID가 대문자임을 유의
                foodK_id = object.getString("k_id");
                foodName = object.getString("name");
                foodPrice = object.getString("price");

                //값들을 User클래스에 묶어줍니다
                Menu menu = new Menu(foodNo, foodCompany_no, foodK_id, foodName, foodPrice);
                if(foodK_id.equals("1") || foodK_id.equals("2") || foodK_id.equals("3")){
                    menuList1.add(menu);//리스트뷰에 값을 추가해줍니다
                    tempList1.add(menu);
                }
                else if(foodK_id.equals("4")){
                    menuList2.add(menu);//리스트뷰에 값을 추가해줍니다
                    tempList2.add(menu);
                }
                else if(foodK_id.equals("5")){
                    menuList3.add(menu);//리스트뷰에 값을 추가해줍니다
                    tempList3.add(menu);
                }

                count++;
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        //학식메뉴를 눌렀을때 넘어가는 창
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent,View view,int position,long id){
                Menu menu = (Menu) menuList1.get(position);
                Intent intent = new Intent(view.getContext(),HakDetailActivity.class);
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent,View view,int position,long id){
                Menu menu = (Menu) menuList2.get(position);
                Intent intent = new Intent(view.getContext(),HakDetailActivity.class);
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        });

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent,View view,int position,long id){
                Menu menu = (Menu) menuList3.get(position);
                Intent intent = new Intent(view.getContext(),HakDetailActivity.class);
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });

        return view;
    }

    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        menuList1.clear();
        menuList2.clear();
        menuList3.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            menuList1.addAll(tempList1);
            menuList2.addAll(tempList2);
            menuList3.addAll(tempList3);
        }
        // 문자 입력을 할때..
        else
        {
            for(Menu menu : tempList1){
                if(menu.getName().toLowerCase().contains(charText)){
                    menuList1.add(menu);
                }
            }
            for(Menu menu : tempList2){
                if(menu.getName().toLowerCase().contains(charText)){
                    menuList2.add(menu);
                }
            }
            for(Menu menu : tempList3) {
                if (menu.getName().toLowerCase().contains(charText)) {
                    menuList3.add(menu);
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter1.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        adapter3.notifyDataSetChanged();
    }

}
