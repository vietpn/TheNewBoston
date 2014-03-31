package com.thenewboston.travis;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

	String classes[] = { "StartingPoint", "TextPlay", "Email", "Camera",
			"Data", "Slider", "example6", "example6", "example6" };

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String cheese = classes[position] + "Activity";
		try {
			Class ourClass = Class.forName("com.thenewboston.travis." + cheese);
			Intent ourIntent = new Intent(this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent about = new Intent("com.thenewboston.travis.AboutActivity");
			startActivity(about);
			break;

		case R.id.preferences:
			Intent prefs = new Intent("com.thenewboston.travis.PrefsActivity");
			startActivity(prefs);
			break;
		}
		return false;

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set layout no title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// set fullscreen layout
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

}
