package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
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

		Bundle gotBasket = getIntent().getExtras();
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
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
		default:
			setData = "";
			break;
		}
		test.setText(setData);
	}

}
