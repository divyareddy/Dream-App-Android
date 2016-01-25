package com.swin.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DreamListAdapter extends ArrayAdapter<DreamListData> {

	DreamListData[] data;
	Context context;
	int layoutResourceId;

	public DreamListAdapter(Context context, int layoutResourceId,
			DreamListData[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		DreamListHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new DreamListHolder();
			holder.imgIcon = (ImageView) row.findViewById(R.id.icon);
			holder.txtTitle = (TextView) row.findViewById(R.id.firstLine);
			holder.txtSecondLine = (TextView) row.findViewById(R.id.secondLine);
			row.setTag(holder);
		} else {
			holder = (DreamListHolder) row.getTag();
		}

		DreamListData dataValue = data[position];
		holder.txtTitle.setText(dataValue.title);
		holder.imgIcon.setImageResource(dataValue.icon);
		holder.txtSecondLine.setText(dataValue.secondLine);

		return row;
	}

	static class DreamListHolder {
		ImageView imgIcon;
		TextView txtTitle;
		TextView txtSecondLine;
	}

}