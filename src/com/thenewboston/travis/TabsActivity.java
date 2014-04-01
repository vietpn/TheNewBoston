package com.thenewboston.travis;

import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabsActivity extends Activity implements OnClickListener {
	TabHost th;
	TextView showResult;
	long start, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);

		// create tabhost
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();

		Button newTab = (Button) findViewById(R.id.bAddTab);
		Button bStart = (Button) findViewById(R.id.sbStartWatch);
		Button bStop = (Button) findViewById(R.id.sbSopWatch);

		showResult = (TextView) findViewById(R.id.tvShowResults);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);

		newTab.setOnClickListener(this);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);

		TabSpec spaces = th.newTabSpec("Tag1");
		spaces.setContent(R.id.tab1);
		spaces.setIndicator("StopWatch");
		th.addTab(spaces);

		spaces = th.newTabSpec("Tag2");
		spaces.setContent(R.id.tab2);
		spaces.setIndicator("Tab 2");
		th.addTab(spaces);

		spaces = th.newTabSpec("Tag3");
		spaces.setContent(R.id.tab3);
		spaces.setIndicator("Add a Tab");
		th.addTab(spaces);

		start = 0;
		stop = 0;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bAddTab:
			// How to create new tab here
			TabSpec ourSpec = th.newTabSpec("Tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {

				public View createTabContent(String tag) {
					TextView text = new TextView(TabsActivity.this);
					text.setText("You've created a new Tab!");
					return text;
				}
			});
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;
		case R.id.sbStartWatch:
			start = System.currentTimeMillis();
			break;
		case R.id.sbSopWatch:
			stop = System.currentTimeMillis();
			if (start != 0) {
				long result = stop - start;
				showResult.setText(String.format("%d hours, %d min, %d sec",
						TimeUnit.MILLISECONDS.toHours(result),
						TimeUnit.MILLISECONDS.toMinutes(result),
						TimeUnit.MILLISECONDS.toSeconds(result)));
				start = 0;
				stop = 0;
			}
			break;
		}
	}
}
