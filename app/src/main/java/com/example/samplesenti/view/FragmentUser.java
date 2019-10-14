//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.samplesenti.view.LoginActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;

import com.example.samplesenti.R;
import com.kakao.auth.ApiResponseCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;
import com.kakao.util.helper.log.Logger;


public class FragmentUser extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);


        Button btn_go = (Button) view.findViewById(R.id.notice);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go2 = (Button) view.findViewById(R.id.history);
        btn_go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go3 = (Button) view.findViewById(R.id.my);
        btn_go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MylecActivity.class);
                startActivity(intent);
            }
        });

        Button btn_go4 = (Button) view.findViewById(R.id.version);
        btn_go4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VersionActivity.class);
                startActivity(intent);
            }
        });

        Button btn_logout = (Button) view.findViewById(R.id.btn_custom_login);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLogout();
            }
        });

        return view;
    }

    private void onClickUnlink() {
        final String appendMessage = getString(R.string.com_kakao_confirm_unlink);
        new AlertDialog.Builder(getActivity())
                .setMessage(appendMessage)
                .setPositiveButton(getString(R.string.com_kakao_ok_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                UserManagement.getInstance().requestUnlink(new UnLinkResponseCallback() {
                                    @Override
                                    public void onFailure(ErrorResult errorResult) {
                                        Logger.e(errorResult.toString());
                                    }

                                    @Override
                                    public void onSessionClosed(ErrorResult errorResult) {
                                        goLogout();
                                    }

                                    @Override
                                    public void onNotSignedUp() {
                                        goLogout();
                                    }

                                    @Override
                                    public void onSuccess(Long userId) {
                                        goLogout();
                                    }
                                });
                                dialog.dismiss();
                            }
                        })

                .setNegativeButton(getString(R.string.com_kakao_cancel_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();

    }

    private void onClickLogout() {
        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
            }

            @Override
            public void onNotSignedUp() {
            }

            @Override
            public void onSuccess(Long result) {
            }

            @Override
            public void onDidEnd() {
//        Session.getCurrentSession().close();
                onCompleteLogout();
            }

            @Override
            public void onCompleteLogout() {
                goLogout();
            }
        });
    }

    public void goLogout(){

        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }


}
