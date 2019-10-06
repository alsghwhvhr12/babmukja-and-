//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import com.example.samplesenti.R;


public class FragmentHome extends Fragment  {



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        final ImageButton hak = (ImageButton) view.findViewById(R.id.imageButton3);
        final ImageButton pig = (ImageButton) view.findViewById(R.id.imageButton2);
        final   ImageButton min = (ImageButton)view.findViewById(R.id.imageButton);
        final Button map = (Button)view.findViewById(R.id.map);

        hak.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), HakActivity.class);
                        startActivity(intent);
                }
        });

        map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),MapActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
