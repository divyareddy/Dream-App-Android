package com.swin.myapp;

import android.os.Bundle;
import android.app.*;
import com.googlecode.androidannotations.annotations.*;

@EFragment(R.layout.about)
public class About extends Fragment {

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		getActivity().setTitle("About");
	}

}