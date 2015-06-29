package com.example.same_location.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.same_locaiton.bean.Index_activityBean;
import com.example.same_location.R;
import com.example.same_location.base.BaseListAdapter;
import com.example.same_location.base.ViewHolder;

public class IndexActivityAdapter extends BaseListAdapter<Index_activityBean>{

	public IndexActivityAdapter(Activity context, List<Index_activityBean> list) {
		super(context, list);
	}

	@Override
	public View bindView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.iteam_activitylistview, null);
		}
		
		ImageView imageView = ViewHolder.get(convertView,R.id.activity_image);
		TextView titleTextView= ViewHolder.get(convertView, R.id.activity_title);
		TextView numberTextView = ViewHolder.get(convertView, R.id.activity_number);
		Index_activityBean index_activityBean = list.get(position);
		imageView.setImageResource(index_activityBean.ActivityImageResid);
		titleTextView.setText(index_activityBean.Activitytitle);
		numberTextView.setText(index_activityBean.ActivityNumber);
		return convertView;
	}

	

}
