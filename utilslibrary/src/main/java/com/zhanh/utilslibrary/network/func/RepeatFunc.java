package com.zhanh.utilslibrary.network.func;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;


/**
 * 网络重复请求
 * 轮询功能
 */
public class RepeatFunc implements Function<Observable<Object>, Observable<?>> {
    private int delay = 5;//秒

    public RepeatFunc() {

    }

    public RepeatFunc(int delay) {
        this.delay = delay;
    }

    @Override
    public Observable<?> apply(Observable<Object> observable) throws Throwable {
        return Observable.timer(delay, TimeUnit.SECONDS);//计时发送;
    }
}
