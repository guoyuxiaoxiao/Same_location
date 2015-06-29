package com.example.same_location.fragment;

import com.example.same_location.R;
import com.example.same_location.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 发现
 * **/
public class FindFragment extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.activity_find, container, false);
		ViewUtils.inject(this, view);

		initViews();
		initDatas();
		return view;
	}

	/**
	 * 初始化界面
	 * 
	 */
	public void initViews() {
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
	}


	/**
	 * 点击事件
	 * 
	 * @param v
	 */
	@OnClick({ })
	public void onClick(View v) {

	}

	
	
	
	
}
