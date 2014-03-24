package com.thenewboston.travis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CameraActivity extends Activity implements View.OnClickListener {

	ImageButton					ib;
	Button						b;
	ImageView					iv;
	Intent						intent;
	int							cameraResult;
	private static final int	TAKE_PHOTO_CODE	= 1;
	Bitmap						bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		initialize();

		// get default for imageview here
		InputStream is = getResources().openRawResource(R.drawable.logo);
		bmp = BitmapFactory.decodeStream(is);
		iv.setImageBitmap(bmp);
	}

	public void initialize() {
		// Image view
		iv = (ImageView) findViewById(R.id.ivReturnedPic);

		// Button
		ib = (ImageButton) findViewById(R.id.ibTabkePi);
		b = (Button) findViewById(R.id.bSetWall);

		// Set on click
		ib.setOnClickListener(this);
		b.setOnClickListener(this);

	}

	@SuppressLint("InlinedApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibTabkePi:
			intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(MediaStore.EXTRA_OUTPUT,
					Uri.fromFile(getTempFile(this)));
			startActivityForResult(intent, TAKE_PHOTO_CODE);
			break;

		case R.id.bSetWall:
			// note this here.
			DisplayMetrics metrics = new DisplayMetrics(); 
			getWindowManager().getDefaultDisplay().getMetrics(metrics);
		    
			// get the height and width of screen 
		    int height = metrics.heightPixels; 
		    int width = metrics.widthPixels;
		    
		    WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
			try {
				// use wallpaper manager to set wallpaper for android
				wallpaperManager.setBitmap(bmp);
				wallpaperManager.suggestDesiredDimensions(width, height);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	// create file temp file here
	private File getTempFile(Context context) {
		// it will return /sdcard/image.tmp
		final File path = new File(Environment.getExternalStorageDirectory(),context.getPackageName());
		if (!path.exists()) {
			path.mkdir();
		}
		return new File(path, "theNewBostonImg.tmp");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == TAKE_PHOTO_CODE) {
			final File file = getTempFile(this);
			try {
				bmp = Media.getBitmap(getContentResolver(),Uri.fromFile(file));
				// do whatever you want with the bitmap (Resize, Rename, Add ToGallery, etc)
				iv.setImageBitmap(bmp);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

}
