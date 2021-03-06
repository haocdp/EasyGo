package com.unicorn.easygo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by haoc_dp on 2017/6/24.
 */

public class NetworkCheckUtil {

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {

                // 当前网络是连接的
                //Log.i("networkCheck", "isNetworkAvailable: " + (info.getState() == NetworkInfo.State.CONNECTED));
                //return info.getState() == NetworkInfo.State.CONNECTED;
                return info.isAvailable();
            }
        }
        return false;
    }
}
