package com.giantant.skeleton.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

import com.giantant.skeleton.base.RootApplication;

public class CommonPref implements OnSharedPreferenceChangeListener {
    
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefEdit;
    
    private static CommonPref instance = null;
    
    public static CommonPref getInstance(){
	if(instance == null){
	    instance = new CommonPref();
	}
	return instance;
    }
    
    private CommonPref(){
		prefs = RootApplication.getContext().getSharedPreferences(
			CommonDef.PREF, Context.MODE_PRIVATE);
		prefEdit = prefs.edit();
    }
    
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
	    String key) {
	
    }
    
}

