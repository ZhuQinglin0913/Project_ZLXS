package com.example.frams;

public interface ICommonModel<T> {
    void getData(ICommonPresenter presenter,int whichAPi,T...ts);
}
