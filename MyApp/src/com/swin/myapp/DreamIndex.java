package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.*;

@EActivity(R.layout.dreamindex)
public class DreamIndex extends Activity {

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setTitle("Dream Index");
	}

	@ViewById
	ListView listViewId;
	DreamIndexData[] listItems = {
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamIndexData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title.") };

	@AfterViews
	void updateList() {
		DreamIndexAdapter adapter = new DreamIndexAdapter(this,
				R.layout.dreamindex_list_item, listItems);
		listViewId.setAdapter(adapter);
		listViewId.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent intent = new Intent(getApplicationContext(),
						DreamDetail_.class);
				startActivity(intent);

			}
		});

	}

}