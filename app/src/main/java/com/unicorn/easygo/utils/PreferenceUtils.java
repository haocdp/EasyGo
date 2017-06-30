package com.unicorn.easygo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by haoc_dp on 2017/6/13.
 */

public class PreferenceUtils {

    public final static String PRE_ORDER_ITEMS_KEY = "preOrderItems";

    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";


    public static String getPrefString(Context context, String key,
                                       final String defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }

    public static void setPrefString(Context context, final String key,
                                     final String value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putString(key, value).apply();
    }

    public static Set<String> getPrefStringSet(Context context, String key,
                                               final Set<String> defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getStringSet(key, defaultValue);
    }

    public static void setPrefStringSet(Context context, final String key,
                                     final Set<String> value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putStringSet(key, value).apply();
    }

    public static boolean getPrefBoolean(Context context, final String key,
                                         final boolean defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(Context context, final String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(
                key);
    }

    public static void setPrefBoolean(Context context, final String key,
                                      final boolean value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putBoolean(key, value).apply();
    }

    public static void setPrefInt(Context context, final String key,
                                  final int value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putInt(key, value).apply();
    }

    public static int getPrefInt(Context context, final String key,
                                 final int defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }

    public static void setPrefFloat(Context context, final String key,
                                    final float value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putFloat(key, value).apply();
    }

    public static float getPrefFloat(Context context, final String key,
                                     final float defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getFloat(key, defaultValue);
    }

    public static void setSettingLong(Context context, final String key,
                                      final long value) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        settings.edit().putLong(key, value).apply();
    }

    public static long getPrefLong(Context context, final String key,
                                   final long defaultValue) {
        final SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(context);
        return settings.getLong(key, defaultValue);
    }

    /*public static void clearPreference(Context context,
                                       final SharedPreferences p) {
        final SharedPreferences.Editor editor = p.edit();
        editor.clear();
        editor.apply();
    }*/
    public static void clearPreference(Context context) {
        final SharedPreferences.Editor editor = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }
}
