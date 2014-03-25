package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataActivity extends Activity implements View.OnClickListener {
	Button		start, startFor;
	EditText	sendET;
	TextView	goAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}

	private void initialize() {
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		sendET = (EditText) findViewById(R.id.etSend);
		goAnswer = (TextView) findViewById(R.id.tvGot);

		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(DataActivity.this, OpenedClassActivity.class);
			a.putExtras(basket);
			startActivity(a);
			break;

		case R.id.bSAFR:
			
			break;
		}

	}

}
