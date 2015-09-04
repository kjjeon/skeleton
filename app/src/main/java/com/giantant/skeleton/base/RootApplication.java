package com.giantant.skeleton.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.giantant.skeleton.common.util.LogUtil;

public class RootApplication extends Application {

    public static boolean isDebugMode;
    public static RootApplication mContext = null;
    
    public RootApplication() {
    	super();
    	mContext = this;
    }

    public static Context getContext() {
    	return mContext;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        
//      crash 라이브러리. 에러로그 전송
//      ACRA.init(this);	common
        
        LogUtil.I(null, new Throwable());
        PackageInfo packageInfo;
       	try {
       	    packageInfo = getPackageManager().getPackageInfo(this.getPackageName(), 0);
       	    int flags = packageInfo.applicationInfo.flags;
       	    isDebugMode = (flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
       	} catch (NameNotFoundException e) {
       	    e.printStackTrace();
       	}
    }

}



/*
 * Application 객체란 ??
 * Android 4가지 Component(activity,service,receiver,provider) 중 하나만 실행되어도 Application 객체는 이미 생성된다.
 * 그리고 Application process가 죽지 않는한 Application 객체는 계속 존재한다.
 * 
 * 어플리케이션 객체에 멤버 변수등을 선언해 두면
 * 모든 component에서 접근할 수 있다.
 * 또한 그 멤버 변수는 유효성을 보장 받을 수 있다.
 * 왜냐하면 각각의 component  생명주기 내에서는 분명 Application 객체는 존재하기 때문이다.
 * 뿐만아니라 모든 componet 보다 가장 먼저 그리고 무조건 먼저 생명주기를 타기 때문에
 * 모든 component 진입전 꼭 실행해야할 처리를 넣어두어도 된다.
 * 
 * (다만 Application 객체는 무거운 작업을 해서는 절대 안된다. 그 이유는 application 객체가 지연되면 각 Component 들의 실행시간이 늦어지기 때문이다.)
 * 
 * 우리가 Activity 소스 등에서 getApplicationContext()
 * 함수를 이용해서 Context를 얻어 왔을 것이다.
 * 이렇게 얻어온 Context가 바로 Application 객체인 것이며,
 * 해당 함수를 이용해서 Application 객체에 접근할 수 있다.
 *
 **/









