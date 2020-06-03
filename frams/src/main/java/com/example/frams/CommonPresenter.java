package com.example.frams;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class CommonPresenter<V extends ICommonView,M extends ICommonModel> implements ICommonPresenter {
    private SoftReference<V> mView;
    private SoftReference<M> mModel;
    List<Disposable> disposableList;
    public CommonPresenter(V pView, M pModel) {
        mView = new SoftReference<>(pView);
        mModel = new SoftReference<>(pModel);
        disposableList = new ArrayList<>();
    }

    @Override
    public void getData(int whichAPi, Object... objects) {
        if (mModel!=null && mModel.get()!=null)mModel.get().getData(this,whichAPi,objects);
    }

    @Override
    public void addObserver(Disposable disposable) {
        if (disposable==null)return;
        disposableList.add(disposable);
    }

    @Override
    public void success(int whichAPi, Object[] dp) {
        if (mView!=null && mView.get()!=null)mView.get().success(whichAPi,dp);
    }

    @Override
    public void failed(int whichAPi, Throwable throwable) {
        if (mView!=null && mView.get()!=null)mView.get().failed(whichAPi,throwable);
    }
    public void clear(){
        for(Disposable dis:disposableList){
            if (dis!=null && dis.isDisposed())dis.dispose();
        }
        if (mView!=null){
            mView.clear();
            mView=null;
        }
        if (mModel!=null){
            mModel.clear();
            mModel=null;
        }
    }
}
