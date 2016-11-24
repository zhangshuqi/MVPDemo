package adnroid.zsq.com.mvpdemo.base.presenter;

import adnroid.zsq.com.mvpdemo.base.view.IView;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {
    @Override
    public void attachView(T view) {

    }

    @Override
    public void detachView() {

    }
}
