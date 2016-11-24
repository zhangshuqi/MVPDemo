package adnroid.zsq.com.mvpdemo.activity.login;

import adnroid.zsq.com.mvpdemo.base.view.IView;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public interface ILoginView extends IView {
    void setUserName(String userNmae);
    String getUserName();
    void setPassWord(String passWord);
    String getPassWord();
    void showProgressDialog();
    void hideProgressDialog();
    void setUserNameError(String error);
    void setPasswordError(String error);
}
