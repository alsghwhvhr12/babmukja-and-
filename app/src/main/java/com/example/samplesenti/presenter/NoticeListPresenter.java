package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.Notice;
import com.example.samplesenti.model.nDelete;

import org.json.JSONObject;

import java.util.List;

public class NoticeListPresenter extends BaseAdapter {
    private Context context;
    private List<Notice> noticeList;
    private Activity parentActivity;


    public NoticeListPresenter(Context context, List<Notice> noticeList, Activity parentActivity){
        this.context = context;
        this.noticeList = noticeList;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.nolist_item, null);

        final TextView nTitle = (TextView)v.findViewById(R.id.nTitle);
        TextView nNotice = (TextView)v.findViewById(R.id.nNotice);

        nTitle.setText(noticeList.get(i).getTitle());
        nNotice.setText(noticeList.get(i).getNotice());

        v.setTag(noticeList.get(i).getTitle());

        Button deleteButton = (Button)v.findViewById(R.id.nDelBtn);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                noticeList.remove(i);
                                notifyDataSetChanged();
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                nDelete delete = new nDelete(nTitle.getText().toString(), responseListener);

                RequestQueue queue = Volley.newRequestQueue(parentActivity);

                queue.add(delete);
            }//onclick
        });

        return v;
    }
}
