package adnroid.zsq.com.mvpdemo.http.rxsubscriber;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public interface SubscriberState<T> {
    public void _onStart();

    public   void _onError();

    public   void _onNext(T t);

    public   void _onCompleted();
}
