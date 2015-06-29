package com.example.same_location;

import com.example.same_location.base.BaseActivity;
import com.example.same_location.fragment.FindFragment;
import com.example.same_location.fragment.IndexFragment;
import com.example.same_location.fragment.MineFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@ViewInject(R.id.autoCompleteTextView1)
	private AutoCompleteTextView autoCompleteTextView;
	@ViewInject(R.id.rdoBtnIndex)
	private RadioButton rdoBtnIndex;
	private FragmentManager fgManager;
	private Fragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 绑定界面UI
		ViewUtils.inject(this);

		initView();
	}

	private void initView() {
		fgManager = getSupportFragmentManager();
		fragment = new IndexFragment();
		// 默认选中首页
		rdoBtnIndex.performClick();
	}

	@OnClick({ R.id.rdoBtnIndex, R.id.rdoBtnFind, R.id.rdoBtnMine, })
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.rdoBtnIndex: {// 首页模块
			autoCompleteTextView.setVisibility(View.VISIBLE);
			switchContent(fragment, new IndexFragment(), "home");
			break;
		}
		case R.id.rdoBtnFind: {// 发现模块
			autoCompleteTextView.setVisibility(View.VISIBLE);
			switchContent(fragment, new FindFragment(),
					"goodsCategory");
			break;
		}
		case R.id.rdoBtnMine: {// 我的模块
			switchContent(fragment, new MineFragment(), "mineLPai");
			autoCompleteTextView.setVisibility(View.GONE);
			break;
		}
		}
	}

	
	public void switchContent(android.support.v4.app.Fragment from,
			Fragment to, String tag) {
		if (fragment != to) {
			fragment = to;
			FragmentTransaction transaction = fgManager.beginTransaction();
			try {
				if (!to.isAdded()) { // 先判断是否被add过
					transaction.hide(from).add(R.id.ActivityContent, to, tag)
							.commit(); // 隐藏当前的fragment，add下一个到Activity中
				} else {
					transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
