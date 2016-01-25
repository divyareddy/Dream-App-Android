package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

import android.content.Intent;

@EActivity(R.layout.createdream)
public class CreateDream extends Activity {

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setTitle("Create Dream");
	}

	@Click(R.id.createdream_dreamlistId)
	void navigateToTabbarActivity() {

		Intent intent = new Intent(getApplicationContext(),
				TabbarActivity_.class);
		startActivity(intent);

	}

}