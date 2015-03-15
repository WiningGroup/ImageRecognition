package com.wining.group.recognition.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	/**
	 * 初始化控件
	 */
	protected abstract void initComponent();

	/**
	 * 设置布局资源ID
	 * @return ResourceID
	 */
	protected abstract int setUpLayoutResource();

	/**
	 * 处理逻辑
	 */
	protected abstract void logic();

	/**
	 * 为控件设置监听
	 */
	protected void setUpCompontListener() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(setUpLayoutResource());
		initComponent();
		setUpCompontListener();

		logic();
	}

}
