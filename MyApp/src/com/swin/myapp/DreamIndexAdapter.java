package com.swin.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DreamIndexAdapter extends ArrayAdapter<DreamIndexData> {

	DreamIndexData[] data;
	Context context;
	int layoutResourceId;

	public DreamIndexAdapter(Context context, int layoutResourceId,
			DreamIndexData[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		DreamIndexHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new DreamIndexHolder();
			holder.imgIcon = (ImageView) row.findViewById(R.id.icon);
			holder.txtTitle = (TextView) row.findViewById(R.id.firstLine);
			holder.txtSecondLine = (TextView) row.findViewById(R.id.secondLine);
			row.setTag(holder);
		} else {
			holder = (DreamIndexHolder) row.getTag();
		}

		DreamIndexData dataValue = data[position];
		holder.txtTitle.setText(dataValue.title);
		holder.imgIcon.setImageResource(dataValue.icon);
		holder.txtSecondLine.setText(dataValue.secondLine);

		return row;
	}

	static class DreamIndexHolder {
		ImageView imgIcon;
		TextView txtTitle;
		TextView txtSecondLine;
	}

}