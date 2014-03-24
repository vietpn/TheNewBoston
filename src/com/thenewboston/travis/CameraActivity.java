package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CameraActivity extends Activity implements View.OnClickListener {

	ImageButton			ib;
	Button				b;
	ImageView			iv;
	Intent				i;
	int					cameraResult;
	final static int	cameraData	= 0;
	Bitmap				bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		initialize();
	}

	public void initialize() {
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		
		// Button
		ib = (ImageButton) findViewById(R.id.ibTabkePi);
		b = (Button) findViewById(R.id.bSetWall);

		// set on click
		ib.setOnClickListener(this);
		b.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibTabkePi:
			Log.d("Debug log", "run");
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;

		case R.id.bSetWall:

			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
