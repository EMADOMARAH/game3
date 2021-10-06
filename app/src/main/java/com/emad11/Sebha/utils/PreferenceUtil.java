package com.emad11.Sebha.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtil {
	private static PreferenceUtil sInstance;
	private SharedPreferences appPref;
	private SharedPreferences.Editor appPrefEditor;
	
	
	private PreferenceUtil(final Context context) {
		appPref = PreferenceManager.getDefaultSharedPreferences(context);
		appPrefEditor = appPref.edit();
	}
	public static PreferenceUtil getInstance(final Context context) {
		if (sInstance == null)
			sInstance = new PreferenceUtil(context.getApplicationContext());
		return sInstance;
	}
	
	public SharedPreferences getAppPref() {
		return appPref;
	}
	
	public SharedPreferences.Editor getAppPrefEditor() {
		return appPrefEditor;
	}
	
	
}
