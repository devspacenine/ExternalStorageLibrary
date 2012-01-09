package com.devspacenine.externalstoragelibrary;

import java.io.File;

import android.os.Environment;

public class ExternalStorageManagerSdk4_7 extends ExternalStorageManager {

	@Override
	public File getRingtoneDirectory(String subDirectory) {
		return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Ringtones/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getNotificationDirectory(String subDirectory) {
		return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Notifications/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getAlarmDirectory(String subDirectory) {
		return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Alarms/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getMusicDirectory(String subDirectory) {
		return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

}
