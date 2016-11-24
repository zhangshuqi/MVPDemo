package adnroid.zsq.com.mvpdemo.base.presenter;

import adnroid.zsq.com.mvpdemo.base.view.IView;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public interface IPresenter <V extends IView>{
    void attachView(V view);

    void detachView();
}
