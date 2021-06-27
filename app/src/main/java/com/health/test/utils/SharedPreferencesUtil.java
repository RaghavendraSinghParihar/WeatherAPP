package com.health.test.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesUtil {

    public static void savePreferences(Context context, String key, String value) {
        SharedPreferences sPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void savePreferences(Context context, String key, Boolean value) {
        SharedPreferences sPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static Boolean getPreferences(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean savedPref = sharedPreferences.getBoolean(key, defValue);
        return savedPref;
    }

    public static String getPreferences(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String savedPref = sharedPreferences.getString(key, defValue);
        return savedPref;
    }

    public static int getPreferences(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int savedPref = sharedPreferences.getInt(key, defValue);
        return savedPref;
    }

    public static void savePreferences(Context context, String key, int value) {
        SharedPreferences sPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void deletePreferences(Context context, String key) {
        SharedPreferences sPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.remove(key);
        editor.commit();
    }

    public static void deletePreferences(Context context) {
        SharedPreferences sPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sPrefs.edit();
        editor.clear();
        editor.commit();
    }
}
