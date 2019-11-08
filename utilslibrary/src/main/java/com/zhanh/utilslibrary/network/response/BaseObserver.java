package com.zhanh.utilslibrary.network.response;


import com.zhanh.utilslibrary.network.RxExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    private Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(T results) {
        try {
            onSuccess(results);
        }catch (Exception e){
            e.printStackTrace();
            onFailure(e, RxExceptionUtil.exceptionHandler(e));
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {
    }

    public Disposable getDisposable(){
        return disposable;
    }

    public abstract void onSuccess(T results);
    public abstract void onFailure(Throwable e,String msg);
}
