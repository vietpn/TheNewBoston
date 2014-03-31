package com.thenewboston.travis;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class SplashActivity extends Activity {
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//ourSong = MediaPlayer.create(this, R.raw);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Boolean music = getPrefs.getBoolean("checkbox", true);
		if(music){
			//ourSong.start();
			Log.d("_debug_", "start");
		}else{
			//ourSong.start();
			Log.d("_debug_", "stop");
		}
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent(
							"android.intent.action.MENU");
					startActivity(openStartingPoint);
				}
			}
		};

		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}
