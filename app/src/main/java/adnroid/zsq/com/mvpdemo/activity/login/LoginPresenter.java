package adnroid.zsq.com.mvpdemo.activity.login;

import android.text.TextUtils;
import android.widget.Toast;

import adnroid.zsq.com.mvpdemo.base.presenter.BasePresenter;
import adnroid.zsq.com.mvpdemo.base.view.IView;
import adnroid.zsq.com.mvpdemo.http.rxsubscriber.ProgressSubscriber;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class LoginPresenter   extends BasePresenter <ILoginView>{

    private   LoginModel loginModel;
    private ILoginView loginView;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }

    @Override
    public void attachView(ILoginView view) {
        super.attachView(view);
        this.loginView=view;
    }

    @Override
    public void detachView() {
        super.detachView();
        loginView=null;
    }
    public void startLogin(){
        String userName = loginView.getUserName();
        if (TextUtils.isEmpty(userName)){
          loginView.setUserNameError("用户名不能为空");
            return;
        }
        String passWord = loginView.getPassWord();
        if (TextUtils.isEmpty(passWord)){
            loginView.setPasswordError("密码不能为空");
            return;
        }

        loginModel.login(userName, passWord).subscribe(new ProgressSubscriber<Object>(getView()) {
            @Override
            public void _onError(String message) {

            }

            @Override
            public void _onNext(Object o) {

            }

            @Override
            public void _onCompleted() {

            }
        });
    }
}
