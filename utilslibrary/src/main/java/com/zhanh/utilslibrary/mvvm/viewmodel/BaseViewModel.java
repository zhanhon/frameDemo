package com.zhanh.utilslibrary.mvvm.viewmodel;

import com.zhanh.utilslibrary.mvvm.model.BaseModel;
import com.zhanh.utilslibrary.util.MyLog;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<M extends BaseModel> extends ViewModel implements LifecycleObserver{
    protected M mModel;

    public BaseViewModel() {
        this.mModel = onBindModel();
    }

    protected abstract M onBindModel();

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(LifecycleOwner owner, Lifecycle.Event event){}

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){ }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        onCleared();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){}


    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) {
            mModel.onCleared();
        }
    }


}
