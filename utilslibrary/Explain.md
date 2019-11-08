# 该通用模块说明文档

更新时间：2019.9.12

*项目使用MVVM + Rxjava + Retrofit模式*

M:继承BaseModel，数据逻辑的处理

V:继承BaseMvvmActivity \ BaseMvvmFragment，页面的数据展示

VM:继承BaseViewModel，M和V的连接

#### 网络请求
> 使用 
```
public class ApiService {
    String url = "http://192.168.130.62:8083/yhouse/app/";
    private volatile static ApiService mInstance;
    private RequestApis nbaApiT;
    private ApiService() {
        //接口类RequestApis是服务后台数据接口，类名可自定义
        nbaApiT = RetrofitFactory
                .getInstance()
                .create(url,RequestApis.class);
    }
    public static RequestApis getInstance() {
        if (mInstance == null){
            synchronized (ApiService.class){
                if (mInstance == null){
                    mInstance = new ApiService();
                }
            }
        }
        return mInstance.nbaApiT;
    }

}
```
> 举个栗数据请求
```
ApiService.getInstance()
                .login(data)
                .compose(ResponseTransformer.<ResponseEntity<String>>setThread())
                .subscribe(new BaseObserver<ResponseEntity<String>>() {
                    @Override
                    public void onSuccess(ResponseEntity<String> results) {
                    
                    }
                    @Override
                    public void onFailure(Throwable e, String msg) {

                    }
                });
```



***
#### 引用的第三方库说明
1. json的转换[fastjson](https://github.com/alibaba/fastjson)

2. [live-event-bus-x](https://github.com/JeremyLiao/LiveEventBus)，
   消息总线，基于LiveData，具有生命周期感知能力，支持Sticky，支持AndroidX，支持跨进程，支持跨APP
   
   > 在Application的onCreate()初始化
   ```
   LiveEventBus.get()
                .config()
                .supportBroadcast(this)
                .lifecycleObserverAlwaysActive(false)
                .autoClear(true);
   ```
   
3. [BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
   RecyclerView万能适配器
   
4. [logger](https://github.com/orhanobut/logger)
   日志打印，会显示打印代码行数 
   > 在Application的onCreate()初始化
   ``` 
   Logger.addLogAdapter(newAndroidLogAdapter()); 
   ```
   
5. [litepal](https://github.com/LitePalFramework/LitePal)本地数据库 
   
   >  在Application的onCreate()初始化。还要在assets文件夹配置xml，具体看文档
   ```
   LitePal.initialize(instance);
   ```
   
6. [xpopup](https://github.com/li-xiaojun/XPopup) 各样式的弹窗

7. [glide](https://github.com/bumptech/glide)网络图片加载框架

8. [PickerView](https://github.com/Bigkoo/Android-PickerView)时间选择器、省市区三级联动

9. [agentweb](https://github.com/Justson/AgentWeb)是一个基于的 Android WebView ，极度容易使用以及功能强大的库，提供了 Android WebView 一系列的问题解决方案 ，并且轻量和极度灵活

10. [rxpermissions](https://github.com/tbruyelle/RxPermissions)权限的申请

11. [matisse](https://github.com/zhihu/Matisse)知乎的图片选择库

12. [updateapputils](https://github.com/teprinciple/UpdateAppUtils)快速实现app在线下载更新 

13. [banner](https://github.com/youth5201314/banner)Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等

14. [retrofit](https://github.com/square/retrofit)网络请求，配合*rxjava3*使用

15. [SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout) 下拉刷新、上拉加载、二级刷新等

16. [mmkv](https://github.com/Tencent/MMKV) MMKV 是基于 mmap 内存映射的 key-value 组件，保存数据

17. [AndroidAutoSize](https://github.com/JessYanCoding/AndroidAutoSize) 今日头条屏幕适配方案

18. [leakcanary](https://github.com/square/leakcanary) 内存泄漏检测 

19. [butterknife](https://github.com/JakeWharton/butterknife) 注解框架方便控件id的查找