package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Notice;

public class NoticeDetailActivity extends AppCompatActivity {

    private TextView detailNoticeTitle;
    private TextView detailNoticeN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        detailNoticeTitle = (TextView) findViewById(R.id.detailNoticeTitle);
        detailNoticeN = (TextView) findViewById(R.id.detailNoticeN);

        Intent intent = getIntent();

        Notice notice = (Notice) intent.getSerializableExtra("notice");

        detailNoticeTitle.setText(notice.getTitle());
        detailNoticeN.setText(notice.getNotice());

        Toolbar mToolbar = (Toolbar) findViewById(R.id.detailneEtb);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
