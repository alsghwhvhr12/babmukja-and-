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

public class dMenuListPresenter extends BaseAdapter {

    private Context context;
    private List<Menu> menuList;
    private Activity parentActivity;
    private ViewHolder viewHolder;

    public dMenuListPresenter(Context context, List<Menu> menuList, Activity parentActivity){
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
        View v;
        if(view == null){
            view = View.inflate(context, R.layout.food_item, null);

            viewHolder = new ViewHolder();

            viewHolder.foodNo = (TextView)view.findViewById(R.id.foodNo);
            viewHolder.foodCompany_no = (TextView)view.findViewById(R.id.foodCompany_no);
            viewHolder.foodName = (TextView)view.findViewById(R.id.foodName);
            viewHolder.foodPrice = (TextView)view.findViewById(R.id.foodPrice);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.foodNo.setText(menuList.get(i).getNo());
        viewHolder.foodCompany_no.setText(menuList.get(i).getCompany_no());
        viewHolder.foodName.setText(menuList.get(i).getName());
        viewHolder.foodPrice.setText(menuList.get(i).getPrice());


        return view;
    }


    class ViewHolder{
        public TextView foodNo;
        public TextView foodCompany_no;
        public TextView foodName;
        public TextView foodPrice;
    }
}
