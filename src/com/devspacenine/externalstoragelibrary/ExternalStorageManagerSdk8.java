package com.devspacenine.externalstoragelibrary;

import java.io.File;

import android.os.Environment;

public class ExternalStorageManagerSdk8 extends ExternalStorageManager {

	@Override
	public File getRingtoneDirectory(String subDirectory) {
		return new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_RINGTONES).getAbsolutePath() + "/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getNotificationDirectory(String subDirectory) {
		return new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath() + "/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getAlarmDirectory(String subDirectory) {
		return new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_ALARMS).getAbsolutePath() + "/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

	@Override
	public File getMusicDirectory(String subDirectory) {
		return new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_MUSIC).getAbsolutePath() + "/"
				+ ((subDirectory == null) ? "" : subDirectory));
	}

}
