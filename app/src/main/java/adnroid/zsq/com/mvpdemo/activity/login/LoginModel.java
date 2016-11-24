package adnroid.zsq.com.mvpdemo.activity.login;

import adnroid.zsq.com.mvpdemo.base.bean.BaseRequestData;
import adnroid.zsq.com.mvpdemo.http.HttpMethods;
import adnroid.zsq.com.mvpdemo.http.RxJavaHttpHelper;
import adnroid.zsq.com.mvpdemo.http.rxschedulers.RxSchedulersHelper;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class LoginModel {
    public  void getUserProfile(int uid){

    }

    public   Observable<Object>   login(String userName, String password){
        return  HttpMethods.getInstance().apiService.login(userName, password).
                compose((RxJavaHttpHelper.<Object>handleResult())).compose( RxSchedulersHelper.applyIoTransformer());
    }
}
