//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;
import com.example.samplesenti.model.mDelete;

import org.json.JSONObject;

import java.util.List;

public class MenuListPresenter extends BaseAdapter {

    private Context context;
    private List<Menu> menuList;
    private Activity parentActivity;

    public MenuListPresenter(Context context, List<Menu> menuList, Activity parentActivity){
        this.context = context;
        this.menuList = menuList;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.melist_item, null);

        final TextView mNo = (TextView)v.findViewById(R.id.mNo);
        TextView mCompany_no = (TextView)v.findViewById(R.id.mCompany_no);
        TextView mName = (TextView)v.findViewById(R.id.mName);
        TextView mPrice = (TextView)v.findViewById(R.id.mPrice);

        mNo.setText(menuList.get(i).getNo());
        mCompany_no.setText(menuList.get(i).getCompany_no());
        mName.setText(menuList.get(i).getName());
        mPrice.setText(menuList.get(i).getPrice());

        v.setTag(menuList.get(i).getNo());

        Button deleteButton = (Button)v.findViewById(R.id.mDelBtn);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                menuList.remove(i);
                                notifyDataSetChanged();
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                mDelete delete = new mDelete(mNo.getText().toString(), responseListener);

                RequestQueue queue = Volley.newRequestQueue(parentActivity);

                queue.add(delete);
            }//onclick
        });

        return v;
    }
}
