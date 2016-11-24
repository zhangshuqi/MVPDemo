package adnroid.zsq.com.mvpdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class NetUtils {
    public static Context context;
    public static void init(Context context) {
        NetUtils.context = context;
    }
        /**
         * 判断网络连接是否打开,包括移动数据连接
         *
         * @return 是否联网
         */
    public static boolean isNetworkEnable() {
        boolean netstate = false;
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {

            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {

                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {

                        netstate = true;
                        break;
                    }
                }
            }
        }
        return netstate;
    }

    /**
     * 检测网络是否连接上
     *
     * @return 是否能上网
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager==null){
            return false;
        }
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo==null){
            return false;
        }
        return  networkInfo.isConnected();
    }


}
