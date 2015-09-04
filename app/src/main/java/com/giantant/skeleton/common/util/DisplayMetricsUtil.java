package com.giantant.skeleton.common.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.giantant.skeleton.base.RootApplication;

public class DisplayMetricsUtil{
	
	public static  int getDpi(){
		DisplayMetrics outMetrics = new DisplayMetrics();
		((WindowManager) RootApplication.getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.densityDpi;
	}
	
	public static float getDensity(){
		DisplayMetrics outMetrics = new DisplayMetrics();
		((WindowManager)RootApplication.getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.density;
	}
	/**
	 * @deprecated TypedValue class 사용 (applyDimmension,...)
	 * @param dp
	 * 
	 */
	public static float DpToPx(float dp){
		return dp / getDensity();
	}
	/**
	 * @deprecated TypedValue class 사용 (applyDimmension,...)
	 * @param px
	 * @return
	 */
	public static float PxToDp(float px){
		return px * getDensity();
	}
	
}
