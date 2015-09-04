package com.giantant.skeleton.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.giantant.skeleton.common.CommonDef;
import com.giantant.skeleton.common.receiver.ActivityActionReceiver;
import com.giantant.skeleton.common.util.LogUtil;


/**
 * 베이스 액티비티
 * 모든 액티비티에서 공통으로 처리할 일이 있으면 여기서 (로딩바, Dialog 등)
 */
@SuppressLint("NewApi")
public abstract class BaseActivity extends ActionBarActivity {
    
//    public abstract void onXXX()
    
    private ActivityActionReceiver mActivityReceiver;
    
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.D(null,new Throwable());
        mActivityReceiver = new ActivityActionReceiver();
        mActivityReceiver.registerReciever(this);
        if(CommonDef.DEVELOPER_MODE == true){
        	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().penaltyLog().build()); // network 관련 규정 위반
        	StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyDeath().penaltyLog().build()); //sql Cursor는 사용 후 Close 하지 않는 경우
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.D(null, new Throwable());
    }

    public void onReceive(Context context, Intent intent){
		if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
		    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	            NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
	            NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
	           
	            Toast.makeText(context, "Active Network Type : " + activeNetInfo.getTypeName(), Toast.LENGTH_SHORT).show();
		}
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.D(null, new Throwable());
    }

    @Override
    protected void onDestroy() {
	super.onDestroy();
	LogUtil.D(null, new Throwable());
	mActivityReceiver.unregisterReceiver(this);
    }
    
}
