package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Menu;

import java.util.List;

public class minListPresenter extends BaseAdapter {
    private Context context;
    private List<Menu> menuList;
    private Activity parentActivity;

    public minListPresenter(Context context, List<Menu> menuList, Activity parentActivity){
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
        View v = View.inflate(context, R.layout.min_activity, null);

        final TextView hakNo = (TextView)v.findViewById(R.id.minNo);
        TextView hakCompany_no = (TextView)v.findViewById(R.id.minCompany_no);
        TextView hakName = (TextView)v.findViewById(R.id.minName);
        TextView hakPrice = (TextView)v.findViewById(R.id.minPrice);

        hakNo.setText(menuList.get(i).getNo());
        hakCompany_no.setText(menuList.get(i).getCompany_no());
        hakName.setText(menuList.get(i).getName());
        hakPrice.setText(menuList.get(i).getPrice());

        v.setTag(menuList.get(i).getNo());

        return v;
    }
}
