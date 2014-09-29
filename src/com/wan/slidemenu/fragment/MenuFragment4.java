package com.wan.slidemenu.fragment;

import com.wan.slidemenu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuFragment4 extends Fragment {
	
	private int title;
	private TextView content;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Bundle bundle = getArguments();
		if (bundle != null & bundle.containsKey("position"))
		{
			title = bundle.getInt("position");
		}
		View contentView = inflater.inflate(R.layout.menu_fragment, null);
		content = (TextView)contentView.findViewById(R.id.menu1);
		content.setText("第"+title+"条测试数据。");
		return contentView;
	}
	
}
