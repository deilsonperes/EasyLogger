package com.d_peres.easylogger;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Log utility to improve code readability
 */
@SuppressWarnings({"WeakerAccess", "AccessStaticViaInstance", "FieldCanBeLocal", "unused"})
public class EasyLogger {
	
	private boolean debug = true;
	private String TAG;
	
	/**
	 * Creates a new instance of EasyLogger
	 *
	 * @param primary_tag   used to filter logs from various sources in one logcat filter
	 * @param secondary_tag uses the  'Class.getSimpleName()' method to determine the secondary tag
	 */
	public EasyLogger(@NonNull String primary_tag, Class secondary_tag) {
		this(primary_tag, secondary_tag.getSimpleName(), null);
	}
	
	/**
	 * Creates a new instance of EasyLogger
	 *
	 * @param primary_tag   used to filter logs from various sources in one logcat filter
	 * @param secondary_tag used to identify from where the log message came
	 */
	public EasyLogger(@NonNull String primary_tag, String secondary_tag) {
		this(primary_tag, secondary_tag, null);
	}
	
	/**
	 * Creates a new instance of EasyLogger
	 *
	 * @param primary_tag   used to filter logs from various sources in one logcat filter
	 * @param secondary_tag used to identify from where the log message came
	 * @param config        used to disable log from release application by checking BuildConfig.DEBUG variable
	 */
	public EasyLogger(String primary_tag, String secondary_tag, BuildConfig config) {
		if (config != null)
			debug = config.DEBUG; //TODO: Check if this works
		
		if (secondary_tag != null && secondary_tag.length() > 0)
			TAG = primary_tag + " " + secondary_tag;
		else
			TAG = primary_tag;
	}
	
	/**
	 * Verbose log
	 *
	 * @param log_message the message to be displayed
	 * @param args        the arguments as in 'String.format()' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void v(String log_message, Object... args) {
		if (debug)
			Log.v(TAG, String.format(log_message, args));
	}
	
	/**
	 * Debug log
	 *
	 * @param log_message the message to be displayed
	 * @param args        the arguments as in 'String.format()' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void d(String log_message, Object... args) {
		if (debug)
			Log.d(TAG, String.format(log_message, args));
	}
	
	/**
	 * Info log
	 *
	 * @param log_message the message to be displayed
	 * @param args        the arguments as in 'String.format()' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void i(String log_message, Object... args) {
		if (debug)
			Log.i(TAG, String.format(log_message, args));
	}
	
	/**
	 * Warn log
	 *
	 * @param log_message the message to be displayed
	 * @param args        the arguments as in 'String.format()' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void w(String log_message, Object... args) {
		if (debug)
			Log.w(TAG, String.format(log_message, args));
	}
	
	/**
	 * Error log
	 *
	 * @param error a {@link Throwable} to be logged
	 */
	public void e(Throwable error) {
		if (debug)
			Log.e(TAG, Log.getStackTraceString(error));
	}
	
	/**
	 * Error log
	 *
	 * @param log_message the message to be logged
	 * @param args        the arguments as in 'String.format()' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void e(String log_message, Object... args) {
		if (debug)
			Log.e(TAG, String.format(log_message, args));
	}
	
	/**
	 * Error log
	 *
	 * @param log_message the message to be logged
	 * @param error       a {@link Throwable} to be logged
	 * @param args        the arguments as in 'String.format(string, object...)' (e.g.: %s for string, %d for integer, etc.)
	 */
	public void e(String log_message, Throwable error, Object... args) {
		if (debug) {
			Log.e(TAG, String.format(log_message, args));
			Log.e(TAG, Log.getStackTraceString(error));
		}
	}
}
