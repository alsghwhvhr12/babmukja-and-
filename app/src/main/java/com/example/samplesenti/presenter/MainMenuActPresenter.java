package com.example.samplesenti.presenter;

import com.example.samplesenti.view.IMainMenuActView;

public class MainMenuActPresenter implements IMainMenuActPresenter {
    IMainMenuActView mainMenuActView;

    public MainMenuActPresenter(IMainMenuActView mainMenuActView){
        this.mainMenuActView = mainMenuActView;
    }


}
