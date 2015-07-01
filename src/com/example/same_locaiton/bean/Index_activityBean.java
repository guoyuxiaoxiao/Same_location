package com.example.same_locaiton.bean;

import android.R.string;

public class Index_activityBean {
	public  int ActivityImageResid;
	public String Activitytitle;
	public String ActivityNumber;
	public String ActivityContent;
	public Index_activityBean(int activityImageResid, String activitytitle,
			String activityNumber,String activityContent) {
		super();
		ActivityImageResid = activityImageResid;
		Activitytitle = activitytitle;
		ActivityNumber = activityNumber;
		ActivityContent = activityContent;
	}
	
}
