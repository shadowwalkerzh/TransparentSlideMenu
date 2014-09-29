package com.wan.slidemenu.adapter;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.widget.TextView;

public class MyDrawerListener implements DrawerListener {

	private TextView title;
	private String defaultString;
	
	public MyDrawerListener(TextView title,String defaultString){
		this.title =  title;
		this.defaultString = defaultString;
	}
	
	@Override
	public void onDrawerClosed(View arg0) {
		title.setText(defaultString);
	}

	@Override
	public void onDrawerOpened(View arg0) {
		title.setText("我的菜单");
	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {

	}

	@Override
	public void onDrawerStateChanged(int arg0) {

	}

}
