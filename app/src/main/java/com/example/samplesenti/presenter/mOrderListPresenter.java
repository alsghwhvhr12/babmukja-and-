package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Order;

import java.util.List;

public class mOrderListPresenter extends BaseAdapter {
    private Context context;
    private List<Order> orderList;
    private Activity parentActivity;

    public mOrderListPresenter(Context context, List<Order> menuList, Activity parentActivity){
        this.context = context;
        this.orderList = menuList;
        this.parentActivity = parentActivity;
    }
    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int i) {
        return orderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.hak_item, null);


        TextView hakName = (TextView)v.findViewById(R.id.hakName);
        TextView hakPrice = (TextView)v.findViewById(R.id.hakPrice);


        hakName.setText(orderList.get(i).getName());
        hakPrice.setText(orderList.get(i).getPrice());


        return v;
    }
}
