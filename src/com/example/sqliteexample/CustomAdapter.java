package com.example.sqliteexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Refugee> data;// modify here

	public CustomAdapter(Context context, ArrayList<Refugee> data) // modify here
	{
		this.mContext = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,
					false);// modify here
			viewHolder = new ViewHolder();
			viewHolder.textViewNames = (TextView) convertView.findViewById(R.id.textViewNames);// modify
																				// here
			viewHolder.textViewOrigin = (TextView) convertView.findViewById(R.id.textViewOrigin);// modify
																			// here
			viewHolder.textViewAge = (TextView) convertView.findViewById(R.id.textViewAge);// modify
																			// here
			viewHolder.textViewGender = (TextView) convertView.findViewById(R.id.textViewGender);// modify
																				// here
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Refugee b = data.get(position);// modify here
		viewHolder.textViewNames.setText(b.getNames());// modify here
		viewHolder.textViewOrigin.setText(b.getOrigin());// modify here
		viewHolder.textViewAge.setText(b.getAge());// modify here
		viewHolder.textViewGender.setText(b.getGender());// modify here
		return convertView;
	}

	static class ViewHolder {
		TextView textViewNames;// modify here
		TextView textViewOrigin;// modify here
		TextView textViewAge;// modify here
		TextView textViewGender;// modify here
	}

}
