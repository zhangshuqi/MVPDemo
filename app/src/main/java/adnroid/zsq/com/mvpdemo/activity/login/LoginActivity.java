package adnroid.zsq.com.mvpdemo.activity.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import adnroid.zsq.com.mvpdemo.R;
import adnroid.zsq.com.mvpdemo.base.activity.BaseActivity;
import adnroid.zsq.com.mvpdemo.inject.component.ActivityComponent;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {

    @Bind(R.id.et_username)
    TextInputEditText etUsername;
    @Bind(R.id.ti_username)
    TextInputLayout tiUsername;
    @Bind(R.id.et_password)
    TextInputEditText etPassword;
    @Bind(R.id.ti_password)
    TextInputLayout tiPassword;
    @Bind(R.id.bt_login)
    AppCompatButton btLogin;
    private ProgressDialog loginDialog;
    private LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setActivityComponent(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        loginDialog = new ProgressDialog(this);
        loginDialog.setMessage("登陆中,请稍后");
        loginPresenter = new LoginPresenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);

    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {
        super.initEvent(savedInstanceState);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.startLogin();
            }
        });
    }

    @Override
    public void setUserName(String userName) {
        etUsername.setText(userName);
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public void setPassWord(String passWord) {
        etPassword.setText(passWord);
    }

    @Override
    public String getPassWord() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showProgressDialog() {
        loginDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (loginDialog.isShowing()) loginDialog.dismiss();
    }

    @Override
    public void setUserNameError(String error) {
        tiUsername.setErrorEnabled(true);
        tiUsername.setError(error);

    }

    @Override
    public void setPasswordError(String error) {
        tiPassword.setErrorEnabled(true);
        tiPassword.setError(error);

    }



}
