package com.giantant.skeleton.common.util;

import java.util.Calendar;

public class CalendarUtil {
	private static CalendarUtil CalendarUtilInstance = null;
	private Calendar rightNow  = null;
	
	public static CalendarUtil getInstance() {
		
		if(CalendarUtilInstance == null){
			CalendarUtilInstance = new CalendarUtil();
		}
		
		return CalendarUtilInstance;
		
	}
	
	private CalendarUtil() {
		rightNow  = Calendar.getInstance();
	}
	
	public Calendar getRightNow() {
		if(rightNow  != null)
			return rightNow ;
		
		return null;
	}
}
