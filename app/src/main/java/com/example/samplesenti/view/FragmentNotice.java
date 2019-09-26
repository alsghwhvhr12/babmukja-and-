package com.example.samplesenti.view;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.samplesenti.R;
import com.example.samplesenti.view.MainMenuAct;


public class FragmentNotice extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        Button btn_go = (Button) view.findViewById(R.id.goBack);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuAct act = (MainMenuAct) getActivity();
                act.goBack(view);
            }
        });
        return view;
    }

}



