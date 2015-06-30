package com.example.same_location.fragment;


import java.util.ArrayList;
import java.util.List;

import com.example.same_locaiton.bean.Index_activityBean;
import com.example.same_location.R;
import com.example.same_location.adapter.IndexActivityAdapter;
import com.example.same_location.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 首页
 * **/
public class IndexFragment extends BaseFragment{
	
	@ViewInject(R.id.ActivityListView)
	private ListView activityListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.activity_index, container, false);
		
		ViewUtils.inject(this, view);

		initViews();
		initDatas();
		
		
		
	/*	activityListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.i("ss", arg2+"");
			}
		});
		*/
		
		
		return view;
	}

	/**
	 * 初始化界面
	 * 
	 */
	public void initViews() {
		
		
		/*View autoComple = View.inflate(this.getActivity(), R.layout.autocomplete_index, null);
		activityListView.addHeaderView(autoComple);*/
		View flipper= View.inflate(this.getActivity(), R.layout.viewflipper_index,null);
		activityListView.addHeaderView(flipper);
	}

	/**
	 * 初始化弹窗
	 * 
	 */
	public void initPop() {
		
	}

	/**
	 * 初始化数据
	 * 
	 */
	private void initDatas() {
		
		Bundle bundle = this.getArguments();
		String cityname = bundle.getString("CityName"); 
		LogUtils.d(cityname);
		
		List<Index_activityBean> index_activityBeans = new ArrayList<Index_activityBean>();
		for (int i = 0; i < 20; i++) {
			index_activityBeans.add(new Index_activityBean(R.drawable.headset, "厦门大学学生公寓"+i, "55"+i));
		}
		activityListView.setAdapter(new IndexActivityAdapter(this.getActivity(), index_activityBeans));
	}


	/**
	 * 点击事件
	 * 
	 * @param v
	 */
	@OnClick({})
	public void onClick(View v) {
	}

	@OnItemClick(R.id.ActivityListView)
	public void onIteamClick(AdapterView<?> parent, View view, int position,
			long id){
		LogUtils.d(position+"");
	}
	
	
	
}
