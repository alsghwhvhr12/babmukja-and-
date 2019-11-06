package com.example.samplesenti.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.samplesenti.R;

public class FragmentHistory extends Fragment {
    public SharedPreferences history;
    public SharedPreferences.Editor his_editor;
    String goods0,goods1,goods2,goods3,goods4,gprice0,gprice1,gprice2,gprice3,gprice4;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history,container,false);

        TextView tvHis0=(TextView)view.findViewById(R.id.tvHis0);
        TextView tvHis1=(TextView)view.findViewById(R.id.tvHis1);
        TextView tvHis2=(TextView)view.findViewById(R.id.tvHis2);
        TextView tvHis3=(TextView)view.findViewById(R.id.tvHis3);
        TextView tvHis4=(TextView)view.findViewById(R.id.tvHis4);

        TextView tvNoOrder=(TextView)view.findViewById(R.id.tvNoOrder);

        history = this.getActivity().getSharedPreferences("HISTORY", Context.MODE_PRIVATE);
       goods0=history.getString("hname0","");
       goods1=history.getString("hname1","");
       goods2=history.getString("hname2","");
       goods3=history.getString("hname3","");
       goods4=history.getString("hname4","");
       gprice0=history.getString("hprice0","");
       gprice1=history.getString("hprice1","");
        gprice2=history.getString("hprice2","");
        gprice3=history.getString("hprice3","");
        gprice4=history.getString("hprice4","");

        if(goods0!="") {
            tvHis0.setText(goods0 +"\t"+gprice0);
        }else{
            tvNoOrder.setText("주문내역이 없습니다.");
        }
        if(goods1!="") {
            tvHis1.setText(goods1 +"\t"+ gprice1);
        }
        if(goods2!="") {
            tvHis2.setText(goods2 +"\t"+gprice2);
        }
        if(goods3!="") {
            tvHis3.setText(goods3 +"\t"+gprice3);
        }
        if(goods4!="") {
            tvHis4.setText(goods4 +"\t"+gprice4);
        }
        return view;
    }
}
