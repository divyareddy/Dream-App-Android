package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

import android.content.*;
import android.widget.*;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView.*;
import com.swin.myapp.ConfirmDialog.ConfirmDialogListener;

@EFragment(R.layout.dreamlist)
@OptionsMenu(R.menu.dreamlist)
public class DreamList extends Fragment implements ConfirmDialogListener

{

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		getActivity().setTitle("Dream List");
	}

	@ViewById
	ListView listViewId;
	DreamListData[] listItems = {
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title."),
			new DreamListData(android.R.drawable.ic_dialog_email, "Title",
					"Sub text that is longer than title.") };

	@AfterViews
	void updateList() {
		DreamListAdapter adapter = new DreamListAdapter(getActivity(),
				R.layout.dreamlist_list_item, listItems);
		listViewId.setAdapter(adapter);
		listViewId.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			}
		});

	}

	@OptionsItem
	void actionAddIdSelected() {

		Intent intent = new Intent(getActivity(), CreateDream_.class);
		startActivity(intent);

	}

	@OptionsItem
	void actionSearchIdSelected() {
	}

	@OptionsItem
	void actionDeleteIdSelected() {
		DialogFragment newFragment = ConfirmDialog.newInstance(
				R.string.dreamlist_confirmdialog_dialog_title, "DreamList");
		newFragment.setRetainInstance(true);
		newFragment.show(getFragmentManager(), "dialog");

	}

	@OptionsItem
	void actionIndexIdSelected() {

		Intent intent = new Intent(getActivity(), DreamIndex_.class);
		startActivity(intent);

	}

	@Override
	public void doDialogClickConfirmDialog(DialogInterface dialog, int which) {
		String text = "";
		if (which == DialogInterface.BUTTON_POSITIVE) {
			text = "Positive";
		} else {
			text = "Negative";
		}
		Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
	}

}