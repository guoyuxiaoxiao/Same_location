package com.example.same_location;

import java.util.Timer;
import java.util.TimerTask;

import com.example.same_location.base.BaseActivity;
import com.example.same_location.util.CityLocation;
import com.example.same_location.util.GPSLocation;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

public class AnimeActivity extends Activity {

	private boolean flag = false;
	private CityLocation cityLocation = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim);
		GPSLocation gpslocation = new GPSLocation(AnimeActivity.this);

		// 更新主线程对话框
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					new AlertDialog.Builder(AnimeActivity.this).setTitle("提示")
							.setMessage("请打开GPS")
							.setPositiveButton("确定", new OnClickListener() {
								// 点击确定，退出程序
								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									finish();
								}
							}).show();
					break;
				default:
					break;
				}

			}
		};
		flag = gpslocation.isGpsOpen();
		LogUtils.d(flag + "");
		Timer timer = new Timer();
		if (flag) {
			cityLocation = new CityLocation(this, null);
		}

		// 计时器
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// 如果gps开启，则跳转否则关闭程序
				//if (flag) {
					Intent intent = new Intent();
					intent.setClass(AnimeActivity.this, MainActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("CityName", cityLocation.CityName); // 压入数据
					intent.putExtras(bundle);
					AnimeActivity.this.startActivity(intent);
					finish();
				/*} else {
					Message message = new Message();
					message.what = 1;
					handler.sendMessage(message);
					// android.os.Process.killProcess(android.os.Process.myPid());
				}*/
				// finish();
			}
		};

		timer.schedule(task, 5000);
	}

}
