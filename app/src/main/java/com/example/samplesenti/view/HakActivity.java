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



public class HakActivity extends AppCompatActivity {

    private ListView lvHak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hak);

        lvHak = (ListView) findViewById(R.id.lvHak);

        List hakList = new ArrayList();

        for (int count = 1; count < 300; count++) {
            hakList.add(new HakVO("학식이름", "업체명"));
        }

    }

/*
    private class HakListViewAdapter extends Adapter {
        private List hakList;

        private Context context;

        public HakListViewAdapter(List hakList, Context context) {
            this.hakList = hakList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return hakList.size();
        }
    }
    */

}
