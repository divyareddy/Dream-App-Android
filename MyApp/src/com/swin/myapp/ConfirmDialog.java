package com.swin.myapp;

import android.app.*;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class ConfirmDialog extends DialogFragment implements OnClickListener {
	public interface ConfirmDialogListener {
		public void doDialogClickConfirmDialog(DialogInterface dialog, int which);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		title = args.getInt("title");
		if (args.containsKey("tab")) {
			tab = args.getString("tab");
		}
	}

	public int title;
	public String tab;
	ConfirmDialogListener listener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			listener = (ConfirmDialogListener) activity;
		} catch (ClassCastException e) {
		}
	}

	private static ConfirmDialog instance(int title, String tab) {
		ConfirmDialog frag = new ConfirmDialog();
		Bundle args = new Bundle();
		args.putInt("title", title);
		if (!tab.isEmpty()) {
			args.putString("tab", tab);
		}
		frag.setArguments(args);
		return frag;
	}

	public static ConfirmDialog newInstance(int title) {
		return instance(title, "");
	}

	public static ConfirmDialog newInstance(int title, String tab) {
		return instance(title, tab);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		return new AlertDialog.Builder(getActivity()).setTitle(title)
				.setMessage("Are you sure?").setPositiveButton("Yes", this)
				.setNegativeButton("No", this).create();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (listener == null) {
			listener = ((ConfirmDialogListener) getFragmentManager()
					.findFragmentByTag(tab));
		}

		listener.doDialogClickConfirmDialog(dialog, which);
	}
}