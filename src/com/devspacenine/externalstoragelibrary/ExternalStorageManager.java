package com.devspacenine.externalstoragelibrary;

import java.io.File;

import android.os.Build;


public abstract class ExternalStorageManager {

	/**
     * Static singleton instance of {@link ExternalStorageManager} holding the
     * SDK-specific implementation of the class.
     */
	private static ExternalStorageManager mInstance;
	
	public static ExternalStorageManager getInstance() {
		
		if(mInstance == null) {
			String className;
			
			/*
             * Check the version of the SDK we are running on. Choose an
             * implementation class designed for that version of the SDK.
             *
             * Unfortunately we have to use strings to represent the class
             * names. If we used the conventional ExternalStorageManagerSdk4_7.class.getName()
             * syntax, we would get a ClassNotFoundException at runtime on pre-Eclair SDKs.
             * Using the above syntax would force Dalvik to load the class and try to
             * resolve references to all other classes it uses. Since the pre-Eclair
             * does not have those classes, the loading of ExternalStorageManagerSdk4_7 would fail.
             */
			if(Build.VERSION.SDK_INT < 8)
				className = "com.devspacenine.externalstoragelibrary.ExternalStorageManagerSdk4_7";
			else
				className = "com.devspacenine.externalstoragelibrary.ExternalStorageManagerSdk8";
			
			/*
             * Find the required class by name and instantiate it.
             */
			try {
				Class<? extends ExternalStorageManager> clazz =
					Class.forName(className).asSubclass(ExternalStorageManager.class);
				mInstance = clazz.newInstance();
			}catch(Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return mInstance;
	}
	
	/**
	 * Returns the device's external ringtone directory as a File object.
	 */
	public abstract File getRingtoneDirectory(String subDirectory);
	
	/**
	 * Returns the device's external notification directory as a File object.
	 */
	public abstract File getNotificationDirectory(String subDirectory);
	
	/**
	 * Returns the device's external alarm directory as a File object.
	 */
	public abstract File getAlarmDirectory(String subDirectory);
	
	/**
	 * Returns the device's external music directory as a File object.
	 */
	public abstract File getMusicDirectory(String subDirectory);
}
