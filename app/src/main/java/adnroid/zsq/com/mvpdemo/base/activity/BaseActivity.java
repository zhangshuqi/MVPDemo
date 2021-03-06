package adnroid.zsq.com.mvpdemo.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import javax.inject.Inject;

import adnroid.zsq.com.mvpdemo.base.presenter.BasePresenter;
import adnroid.zsq.com.mvpdemo.base.view.IView;
import adnroid.zsq.com.mvpdemo.inject.component.ActivityComponent;
import adnroid.zsq.com.mvpdemo.inject.component.AppComponent;
import adnroid.zsq.com.mvpdemo.inject.component.DaggerActivityComponent;
import adnroid.zsq.com.mvpdemo.inject.component.DaggerAppComponent;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public abstract class BaseActivity <T extends  BasePresenter> extends FragmentActivity implements IView {
    @Inject
   protected  T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId<=0){
            throw new NullPointerException("Please set Layout  ");
        }
        ActivityComponent activityComponent = DaggerActivityComponent.builder().appComponent(AppComponent.Instance.getAppComponent()).build();
        setActivityComponent(activityComponent);
        setContentView(layoutId);
        ButterKnife.bind(this);
        if (presenter!=null)
        presenter.attachView(this);
        initView(savedInstanceState);
        initData(savedInstanceState);
        initEvent(savedInstanceState);
    }

    protected void initEvent(Bundle savedInstanceState) {

    }

    protected void initData(Bundle savedInstanceState) {

    }

    protected   void initView(Bundle savedInstanceState){

    }

    protected abstract int  getLayoutId() ;
    protected  abstract void setActivityComponent(ActivityComponent activityComponent);
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) presenter.detachView();
    }
}
