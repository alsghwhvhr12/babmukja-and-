package com.example.samplesenti.presenter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

public class KakaoPresenter extends Application {
   private static KakaoPresenter instance;

   public static KakaoPresenter getKaKaoPresenterContext(){
       if(instance==null){
           throw new IllegalStateException("This Application does not inherit com.kakao.KakaoPresenter");
       }
       return instance;
   }

    @Override
    public void onCreate(){
       super.onCreate();
       instance=this;
       // Kakao Sdk 초기화
       KakaoSDK.init(new KakaoSDKAdapter());
   }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
