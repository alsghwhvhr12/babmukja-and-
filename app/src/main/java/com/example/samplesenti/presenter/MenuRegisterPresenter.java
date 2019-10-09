//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.samplesenti.view.IMenuRegisterActivity;

public class MenuRegisterPresenter implements IMenuRegisterActivity.Presenter{
    private IMenuRegisterActivity.View view;
    private Context context;
    private Activity activity;

    public MenuRegisterPresenter(IMenuRegisterActivity.View view, Context context, Activity activity) {
        this.view = view;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void presenterView() {
        view.setView();
    }
}
