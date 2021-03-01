package com.zhanh.utilslibrary.mvvm.model;


import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class BaseModel implements IBaseModel {
    private CompositeDisposable mCompositeDisposable;
    public BaseModel() {
        mCompositeDisposable = new CompositeDisposable();
    }
    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

}
