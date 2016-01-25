package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

import android.content.Intent;

@EActivity(R.layout.newgoal)
public class NewGoal extends Activity {

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setTitle("New Goal");
	}

	@Click(R.id.setgoal_goalsId)
	void navigateToTabbarActivity() {

		Intent intent = new Intent(getApplicationContext(),
				TabbarActivity_.class);
		startActivity(intent);

	}
	@Click(R.id.cancelgoal_goalsId)
	void switchToTabbarActivity() {

		Intent intent = new Intent(getApplicationContext(),
				TabbarActivity_.class);
		startActivity(intent);

	}

}