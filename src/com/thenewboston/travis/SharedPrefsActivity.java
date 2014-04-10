package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefsActivity extends Activity implements OnClickListener {

	EditText sharedData;
	TextView dataResult;

	public static String filename = "MySharedString";
	SharedPreferences someData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_prefs);
		setupVariables();

		someData = getSharedPreferences(filename, 0);
	}

	private void setupVariables() {
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etsharedPrefs);
		dataResult = (TextView) findViewById(R.id.tvLoadSharedPrefs);

		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bSave:
			String stringData = sharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();

			editor.putString("sharedString", stringData);
			editor.commit();
			
			sharedData.setText("");
			break;

		case R.id.bLoad:
			someData = getSharedPreferences(filename, 0);
			String dataReturned = someData.getString("sharedString", "Coundn't Load Data");
			dataResult.setText(dataReturned);
			break;
		}

	}

}
