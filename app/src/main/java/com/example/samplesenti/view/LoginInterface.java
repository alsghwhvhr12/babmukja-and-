//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

public interface LoginInterface {
    interface View{
        void setView();
    }
    interface Presenter{
        void presenterView();
        void Login(String id, String pw);
    }
}

