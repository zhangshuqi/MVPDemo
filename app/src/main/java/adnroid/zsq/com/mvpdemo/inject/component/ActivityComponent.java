package adnroid.zsq.com.mvpdemo.inject.component;

import adnroid.zsq.com.mvpdemo.activity.login.LoginActivity;
import dagger.Component;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);
}
