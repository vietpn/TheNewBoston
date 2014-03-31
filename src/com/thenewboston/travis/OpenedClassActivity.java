package com.thenewboston.travis;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClassActivity extends Activity implements OnClickListener,
		OnCheckedChangeListener {
	TextView	question, test;
	Button		returnData;
	RadioGroup	selectionList;
	String		gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		
		// get data from Preference
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		// name: name, default: Travis is...
		String et = getData.getString("name", "Travis is...");
		// name: list, default: 4
		String value = getData.getString("list", "4");
		if(value.contentEquals("1")){
			question.setText(et);
		}
	}

	private void initialize() {
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);

		returnData.setOnClickListener(this);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bReturn:
			// create new Intent
			Intent person = new Intent();
			Bundle backpack = new Bundle();
			backpack.putString("answer", setData);
			person.putExtras(backpack);
			// set Result for intent person
			setResult(RESULT_OK, person);
			// close current activity
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rCrazay:
			setData = "Probably right!";
			break;
		case R.id.rSexy:
			setData = "Definitely right!";
			break;
		case R.id.rBoth:
			setData = "Spot On!";
			break;
		}
		test.setText(setData);
	}

}
