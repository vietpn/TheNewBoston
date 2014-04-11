package com.thenewboston.travis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalDataActivity extends Activity implements OnClickListener {
	EditText sharedData;
	TextView dataResult;
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_prefs);

		setupVariables();
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bSave:
			String data = sharedData.getText().toString();
			
			// Saving data via File			
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case R.id.bLoad:
			String collected = null;
			FileInputStream fis = null;
			
			try {
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1) {
					collected = new String(dataArray);					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					fis.close();
					dataResult.setText(collected);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			break;
		}

	}

	private void setupVariables() {
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etsharedPrefs);
		dataResult = (TextView) findViewById(R.id.tvLoadSharedPrefs);

		save.setOnClickListener(this);
		load.setOnClickListener(this);

		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
