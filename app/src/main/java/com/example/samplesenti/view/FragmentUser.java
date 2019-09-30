package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.samplesenti.R;


public class FragmentUser extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);

        Button btn_go = (Button) view.findViewById(R.id.notice);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go2 = (Button) view.findViewById(R.id.history);
        btn_go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go3 = (Button) view.findViewById(R.id.my);
        btn_go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MylecActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go4 = (Button) view.findViewById(R.id.version);
        btn_go4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VersionActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
