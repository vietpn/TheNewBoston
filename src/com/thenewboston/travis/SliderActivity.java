package com.thenewboston.travis;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class SliderActivity extends Activity implements OnClickListener,OnCheckedChangeListener, OnDrawerOpenListener {
	Button handl1, handl2, handl3, handl4;
	CheckBox checkbox;
	SlidingDrawer sd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slider);
		handl1 = (Button) findViewById(R.id.handle1);
		handl2 = (Button) findViewById(R.id.handle2);
		handl3 = (Button) findViewById(R.id.handle3);
		handl4 = (Button) findViewById(R.id.handle4);

		checkbox = (CheckBox) findViewById(R.id.dbSlidable);
		sd = (SlidingDrawer)findViewById(R.id.slidingD);		
		sd.setOnDrawerOpenListener(this);
		
		checkbox.setOnCheckedChangeListener(this);
		
		handl1.setOnClickListener(this);
		handl2.setOnClickListener(this);
		handl3.setOnClickListener(this);
		handl4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.handle1:

			break;

		case R.id.handle2:

			break;
		case R.id.handle3:

			break;
		case R.id.handle4:

			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}

	@Override
	public void onDrawerOpened() {
//		MediaPlayer mp = MediaPlayer.create(this, R.raw.explosion);
//		mp.start();
	}

}
