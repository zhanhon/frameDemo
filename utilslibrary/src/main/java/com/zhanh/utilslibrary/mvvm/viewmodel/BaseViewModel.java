package com.zhanh.utilslibrary.mvvm.viewmodel;

import com.zhanh.utilslibrary.mvvm.model.BaseModel;
import com.zhanh.utilslibrary.util.MyLog;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public abstract class BaseViewModel<M extends BaseModel> extends ViewModel implements IBaseViewModel,Consumer<Disposable> {
    protected M mModel;

    public BaseViewModel() {
        this.mModel = onBindModel();
    }

    protected abstract M onBindModel();

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {


    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void accept(Disposable disposable) throws Exception {
        if(mModel != null){
            mModel.addSubscribe(disposable);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) {
            mModel.onCleared();
        }
    }


}
