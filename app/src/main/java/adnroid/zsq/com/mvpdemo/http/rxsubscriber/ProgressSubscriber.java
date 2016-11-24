package adnroid.zsq.com.mvpdemo.http.rxsubscriber;

import adnroid.zsq.com.mvpdemo.base.view.IStateView;
import adnroid.zsq.com.mvpdemo.http.rxexception.DefaultErrorBundle;
import adnroid.zsq.com.mvpdemo.http.rxexception.ErrorBundle;
import adnroid.zsq.com.mvpdemo.http.rxexception.ErrorManager;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public abstract class ProgressSubscriber<T> extends Subscriber<T> {

    private IStateView iStateView;

    public ProgressSubscriber(IStateView iStateView) {
        this.iStateView = iStateView;
    }

    @Override
    public void onCompleted() {
        iStateView.hideProgressDialog();
        _onCompleted();
    }

    @Override
    public void onStart() {
        super.onStart();
        iStateView.showProgressDialog();
        _onStart();
    }

    @Override
    public void onError(Throwable e) {
        iStateView.hideProgressDialog();
        _onError(ErrorManager.handleError(new DefaultErrorBundle((Exception) e)));

    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public void _onStart() {

    }

    public abstract void _onError(String message);

    public abstract void _onNext(T t);

    public abstract void _onCompleted();
}
