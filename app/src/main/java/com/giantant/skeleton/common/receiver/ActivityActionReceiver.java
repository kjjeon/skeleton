package com.giantant.skeleton.common.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.giantant.skeleton.base.BaseActivity;

public class ActivityActionReceiver extends EventReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
	    if(context instanceof BaseActivity){
		((BaseActivity)context).onReceive(context, intent);
	    }
	}
	
	@Override
	public void registerReciever(Context mContext) {
	    IntentFilter localIntentFilter = new IntentFilter();
	    localIntentFilter.addCategory("android.intent.category.DEFAULT");
	    localIntentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);	//android.net.conn.CONNECTIVITY_CHANGE
	    
	    mContext.registerReceiver(this, localIntentFilter);
	}

	
	public void unregisterReceiver(Context mContext) {
		mContext.unregisterReceiver(this);
	}
}
