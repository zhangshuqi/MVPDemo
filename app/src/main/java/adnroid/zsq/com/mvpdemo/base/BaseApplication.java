package adnroid.zsq.com.mvpdemo.base;

import android.support.multidex.MultiDexApplication;

import adnroid.zsq.com.mvpdemo.inject.component.AppComponent;
import adnroid.zsq.com.mvpdemo.inject.component.DaggerActivityComponent;
import adnroid.zsq.com.mvpdemo.inject.component.DaggerAppComponent;
import adnroid.zsq.com.mvpdemo.inject.module.AppModule;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent.Instance.init(DaggerAppComponent.builder().appModule(new AppModule(this)).build());
    }
}
