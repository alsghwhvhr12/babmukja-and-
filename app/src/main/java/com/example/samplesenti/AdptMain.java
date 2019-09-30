//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdptMain extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> arrayGroup;
    private HashMap<String, ArrayList<String>> arrayChild;

    public AdptMain( Context context, ArrayList<String> arrayGroup, HashMap<String, ArrayList<String>> arrayChild){
        super();
        this.context = context;
        this.arrayChild= arrayChild;
        this.arrayGroup= arrayGroup;


    }



    @Override
    public int getGroupCount() {
        return arrayGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arrayChild.get( arrayGroup.get( groupPosition )).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrayGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arrayChild.get( arrayGroup.get( groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupName = arrayGroup.get(groupPosition);
        View v  = convertView;

        if( v == null){
            LayoutInflater inflater=  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (RelativeLayout)inflater.inflate(R.layout.listview_item, null);
        }
        TextView textGroup = (TextView) v.findViewById(R.id.textGroup);
        textGroup.setText(groupName);

        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childName = arrayChild.get(arrayGroup.get(groupPosition)).get(childPosition);
        View v  = convertView;


        if( v == null){
            LayoutInflater inflater=  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (RelativeLayout)inflater.inflate(R.layout.listview_child, null);
        }
        TextView textChild = (TextView) v.findViewById(R.id.textChild);
        textChild.setText(childName);

        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


}