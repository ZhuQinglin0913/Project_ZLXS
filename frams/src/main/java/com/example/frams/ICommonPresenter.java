package com.example.frams;

import io.reactivex.disposables.Disposable;

public interface ICommonPresenter<P> extends ICommonView {
    void getData(int whichAPi,P...ps);
    void addObserver(Disposable disposable);
}

