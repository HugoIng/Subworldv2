package com.deepred.subworld.ui.main;

import java.util.List;

import com.deepred.subworld.data.model.Ribot;
import com.deepred.subworld.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
