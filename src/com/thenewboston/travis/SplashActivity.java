package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
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
