package com.giantant.skeleton.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class EventReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {

	}
	
	public abstract void registerReciever(Context mContext);
	
	public void unregisterReceiver(Context mContext){
		mContext.unregisterReceiver(this);
	}

}
