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
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.samplesenti.R;
import com.example.samplesenti.model.Login;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        getHashKey(mContext);
        setContentView(R.layout.activity_main);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(getApplicationContext(), MainMenuAct.class);
                startActivity(intent);
                finish();
            }
        },Login.loadingSecond);
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

