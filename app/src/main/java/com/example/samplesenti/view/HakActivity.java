package com.example.samplesenti.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.samplesenti.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView; import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;


public class HakActivity extends AppCompatActivity {

    private ListView lvHak;
    private Inflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hak);

        lvHak = (ListView) findViewById(R.id.lvHak);

        List hakList = new ArrayList();

        for (int count = 1; count < 300; count++) {
            hakList.add(new HakVO("학식이름"+count, "업체명"));
        }
        lvHak.setAdapter(new HakListViewAdapter(hakList,this));
    }




    private class HakListViewAdapter extends BaseAdapter {

        /* ListView에 세팅할 Item 정보들 */
        private List hakList;

        /*ListView에 Item을 세팅할 요청자의 정보가 들어감*/
        private Context context;

        /** * 생성자 * * @param articleList * @param context */
        public HakListViewAdapter(List hakList, Context context) {
            this.hakList = hakList;
            this.context = context;
        }

        /* ListView에 세팅할 아이템의 갯수 * @return */
        @Override
        public int getCount() {
            return hakList.size();
        }

        /* position 번째 Item 정보를 가져옴 * @param position * @return */
        @Override
        public Object getItem(int position) {
            return hakList.get(position);
        }

        /* position 번째 Item 정보를 가져옴 * @param position * @return */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /* 아이템의 index를 가져옴 * Item index == position * @param position * @return */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /* 가장 간단한 방법 * 사용자가 처음으로 Flicking을 할 때, 아래쪽에 만들어지는 Cell(한 칸)은 Null이다. */
            if (convertView == null) {
                // Item Cell에 Layout을 적용시킬 Inflater 객체를 생성한다.
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                // Item Cell에 Layout을 적용시킨다.
                // 실제 객체는 이곳에 있다.
                convertView = inflater.inflate(R.layout.hak_item, parent, false);
            }
            TextView tvhakItem1 = (TextView) convertView.findViewById(R.id.tvhakItem1);
            TextView tvhakItem2 = (TextView) convertView.findViewById(R.id.tvhakItem2);
            HakVO article = (HakVO) getItem(position);
            tvhakItem1.setText(article.getProductName());
            tvhakItem2.setText(article.getProductPrice());
          
            return convertView;
        }


    }

}

