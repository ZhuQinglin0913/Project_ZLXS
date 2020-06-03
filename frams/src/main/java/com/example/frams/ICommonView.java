package com.example.frams;

public interface ICommonView<D> {
    void success(int whichAPi,D...dp);
    void failed(int whichAPi,Throwable throwable);
}
