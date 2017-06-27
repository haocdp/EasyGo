package com.unicorn.easygo.utils;

/**
 * Created by haoc_dp on 2017/6/26.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *  Android不能直接根据网络资源URL加载图片资源，
 *  需要将URL转为stream，然后通过BitmapFactory.decodeStream方法加载资源
 *  本工具类，即为将URL转为stream
 */
public class Path2Stream {

    public static InputStream is;
    private static URLConnection urlConnection;

    public synchronized static Bitmap path2Stream(final String url) {
        if (!"".equals(url) && url != null) {
            Bitmap bitmap = null;

            try {
                urlConnection = (new URL(url)).openConnection();
                urlConnection.connect();
                is = urlConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            }catch (Exception e ) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
