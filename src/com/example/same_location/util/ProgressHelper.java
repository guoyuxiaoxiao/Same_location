package com.example.same_location.util;

import com.example.same_location.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


/**
 * 加载进度条工具类 单例
 * @version Revision: 0.0.1
 */
public class ProgressHelper {

	private static ProgressHelper sInstance = null;

	public static ProgressHelper getInstance() {
		if (sInstance == null) {
			synchronized (ProgressHelper.class) {
				if (sInstance == null) {
					sInstance = new ProgressHelper();
				}
			}
		}
		return sInstance;
	}

	private ProgressDialog mDialog = null;

	private ProgressHelper() {
	}

	public void show(Context context, boolean isCancel) {
		cancel();
		mDialog = new ProgressDialog(context, R.style.Dialog);
		mDialog.setCanceledOnTouchOutside(false);
		mDialog.setCancelable(isCancel);
		mDialog.show();
		View v = LayoutInflater.from(context).inflate(R.layout.dialog_progress,
				null);
		mDialog.setContentView(v);
	}

	public void show(Context context, String message, boolean isCancel) {
		cancel();
		mDialog = new ProgressDialog(context, R.style.Dialog);
		mDialog.setCanceledOnTouchOutside(false);
		mDialog.setCancelable(isCancel);
		if (context == null || mDialog == null) {
			return;
		}
		try {
			mDialog.show();
		} catch (Exception e) {
		}

		View v = LayoutInflater.from(context).inflate(R.layout.dialog_progress,
				null);
		TextView txvMessage = (TextView) v
				.findViewById(R.id.txv_dialog_progress_content);
		mDialog.setContentView(v);
		txvMessage.setText(message);
	}

	public void cancel() {
		if (mDialog != null) {
			mDialog.dismiss();
		}
	}

}
