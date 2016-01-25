package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

import android.content.Intent;

@EActivity(R.layout.dreamdetail)
@OptionsMenu(R.menu.dreamdetail)
public class DreamDetail extends Activity {

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setTitle("Dream Detail");
	}

	@OptionsItem
	void actionShareIdSelected() {

		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_TEXT, "Test");

		startActivity(intent);

	}

}