package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

public class SimpleBrowserActivity extends Activity implements OnClickListener {
	WebView ourBrow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_browser);

		ourBrow = (WebView) findViewById(R.id.wvBrowser);
		ourBrow.loadUrl("http://google.com.vn");
	}

	@Override
	public void onClick(View v) {
		
	}

}
