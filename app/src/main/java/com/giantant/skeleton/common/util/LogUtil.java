package com.giantant.skeleton.common.util;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/*
 * 로그 클래스
 * 이클립스에서 해당 로그를 더블클릭하면, 커서가 로그를 입력한 곳으로 이동된다
 */
public class LogUtil {

	public static String TAG = "GIANT";

	protected LogUtil() {

	}

	public static void D(String tag, Throwable currentThrowable) {
		// writeLogFile( " -> " + getFileNameAndLineNumber(currentThrowable)+getDateTime(), null);
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.d(tag, ">>> " + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void D(String tag, String msg,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.d(tag, ">>> " + msg + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void I(String tag,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.i(tag, ">>> " + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void I(String tag, String msg,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.i(tag, ">>> " + msg + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void E(String tag,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.e(tag, ">>> " + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void E( String tag, String msg,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.e(tag, ">>> " + msg + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void W(String tag,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.w(tag, ">>> " + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void W(String tag, String msg,Throwable currentThrowable) {
		if (TextUtils.isEmpty(tag))
			tag = TAG;
		Log.w(tag, ">>> " + msg + getFileNameAndLineNumber(currentThrowable));
		currentThrowable = null;
	}

	public static void Log(int logLevel,Throwable currentThrowable) {

		writeLogFile(" -> " + getFileNameAndLineNumber(currentThrowable)
				+ getDateTime(), null);

		if (true) {
			switch (logLevel) {
			case Log.DEBUG:
				Log.d(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			case Log.ERROR:
				Log.e(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			case Log.INFO:
				Log.i(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			case Log.VERBOSE:
				Log.v(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			case Log.WARN:
				Log.w(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			default:
				Log.d(TAG, ">>> " + getFileNameAndLineNumber(currentThrowable));
				break;
			}
		}
		currentThrowable = null;
	}

	private static String getFileNameAndLineNumber(Throwable throwable) {
		if (throwable == null) {
			return "";
		}
		String fileName = throwable.getStackTrace()[0].getFileName();
		String className = throwable.getStackTrace()[0].getClassName();
		String methodName = throwable.getStackTrace()[0].getMethodName();
		int lineNumber = throwable.getStackTrace()[0].getLineNumber();
		// return "at " + className + "." + methodName + "(" + fileName + ":" +  lineNumber + ")";
		throwable = null;
		return "> at " + methodName + "(" + fileName + ":" + lineNumber + ")";
	}

	private static String getDateTime() {
		Calendar cal = Calendar.getInstance();

		String dateToString, timeToString;

		dateToString = String.format(" %04d-%02d-%02d ",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));

		timeToString = String.format("%02d:%02d:%02d",
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));

		return dateToString + timeToString;
	}

	private static void writeLogFile(String logMsg, String fileName) {
		String logFilePath;
		if (fileName != null) {
			logFilePath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/GIANTApp/Log/" + fileName + ".txt";
		} else {
			logFilePath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/GIANTApp/Log/log.txt";
		}

		File file = new File(logFilePath);
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Log.d(TAG, "exception : " + e.toString());
			}
		} else {
			try {
				BufferedWriter bfw = new BufferedWriter(new FileWriter(
						logFilePath, true));
				bfw.write(logMsg);
				bfw.write("\n");
				bfw.flush();
				bfw.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
	}

}
