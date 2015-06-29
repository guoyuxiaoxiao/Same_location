package com.example.same_location;

import java.util.Timer;
import java.util.TimerTask;

import com.lidroid.xutils.view.annotation.ContentView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AnimeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim);
		
		final Intent intent = new Intent();
		Timer timer = new Timer();
		TimerTask task  =new TimerTask() {
			@Override
			public void run() {
				intent.setClass(AnimeActivity.this,MainActivity.class);
				AnimeActivity.this.startActivity(intent);
				finish();
			}
		};
		
		timer.schedule(task,5000);
	}
	
}
