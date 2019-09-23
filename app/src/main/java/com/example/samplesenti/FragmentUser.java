package com.example.samplesenti;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;


public class FragmentUser extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);

        Button btn_go = (Button) view.findViewById(R.id.notice);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuAct act = (MainMenuAct) getActivity();
                act.replaceF(view);
            }
        });

        Button btn_go2 = (Button) view.findViewById(R.id.history);
        btn_go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuAct act = (MainMenuAct) getActivity();
                act.replaceF(view);
            }
        });

        Button btn_go3 = (Button) view.findViewById(R.id.my);
        btn_go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuAct act = (MainMenuAct) getActivity();
                act.replaceF(view);
            }
        });

        Button btn_go4 = (Button) view.findViewById(R.id.version);
        btn_go4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuAct act = (MainMenuAct) getActivity();
                act.replaceF(view);
            }
        });

        return view;
    }
}
