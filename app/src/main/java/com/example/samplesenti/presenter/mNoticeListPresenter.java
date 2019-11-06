package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Notice;

import java.util.List;

public class mNoticeListPresenter extends BaseAdapter {
    private Context context;
    private List<Notice> noticeList;
    private Activity parentActivity;


    public mNoticeListPresenter(Context context, List<Notice> noticeList, Activity parentActivity){
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
        View v = View.inflate(context, R.layout.main_no_item, null);

        final TextView nNo = (TextView) v.findViewById(R.id.mnNo);
        TextView nTitle = (TextView) v.findViewById(R.id.mnTitle);

        nNo.setText(noticeList.get(i).getNo());
        nTitle.setText(noticeList.get(i).getTitle());

        v.setTag(noticeList.get(i).getNo());

        return v;
    }
}
