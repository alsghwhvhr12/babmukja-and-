//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.samplesenti.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        getHashKey(mContext);

        Button btn_go = (Button) findViewById(R.id.moveButton);
        btn_go.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //로그인화면
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        //액티비티 시작
                        startActivity(intent);
                    }
                }
        );
    }

        // 프로젝트의 해시키를 반환
        @Nullable
        public static String getHashKey(Context context) {
            final String TAG = "KeyHash";
            String keyHash = null;
            try {
                PackageInfo info =
                        context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
                for (Signature signature : info.signatures) {
                    MessageDigest md;
                    md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    keyHash = new String(Base64.encode(md.digest(), 0));
                    Log.d(TAG, keyHash);
                }
            } catch (Exception e) {
                Log.e("name not found", e.toString());
            }
            if (keyHash != null) {
                return keyHash;
            } else {
                return null;

            }

        }

    }

