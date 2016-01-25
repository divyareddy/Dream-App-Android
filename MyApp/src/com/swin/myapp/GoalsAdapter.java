package com.swin.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GoalsAdapter extends ArrayAdapter<GoalsData> {

	GoalsData[] data;
	Context context;
	int layoutResourceId;

	public GoalsAdapter(Context context, int layoutResourceId, GoalsData[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		GoalsHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new GoalsHolder();
			holder.imgIcon = (ImageView) row.findViewById(R.id.icon);
			holder.txtTitle = (TextView) row.findViewById(R.id.firstLine);
			holder.txtSecondLine = (TextView) row.findViewById(R.id.secondLine);
			row.setTag(holder);
		} else {
			holder = (GoalsHolder) row.getTag();
		}

		GoalsData dataValue = data[position];
		holder.txtTitle.setText(dataValue.title);
		holder.imgIcon.setImageResource(dataValue.icon);
		holder.txtSecondLine.setText(dataValue.secondLine);

		return row;
	}

	static class GoalsHolder {
		ImageView imgIcon;
		TextView txtTitle;
		TextView txtSecondLine;
	}

}