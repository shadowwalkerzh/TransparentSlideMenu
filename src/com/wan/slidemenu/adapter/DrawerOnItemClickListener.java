package com.wan.slidemenu.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.wan.slidemenu.R;
import com.wan.slidemenu.utils.BaseUtils;

public class DrawerOnItemClickListener implements OnItemClickListener {

	private FragmentActivity fa;
	private SlideMenuAdapter slideMenuAdapter;
	private DrawerLayout menuLayout;

	public DrawerOnItemClickListener(DrawerLayout menuLayout,
			FragmentActivity fa, SlideMenuAdapter slideMenuAdapter) {
		this.fa = fa;
		this.slideMenuAdapter = slideMenuAdapter;
		this.menuLayout = menuLayout;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Fragment fragment = BaseUtils.getFragmentByName(fa,
				"com.wan.slidemenu.fragment", position);
		FragmentManager fm = fa.getSupportFragmentManager();
		Bundle args = new Bundle();
		args.putInt("position", position);
		fragment.setArguments(args);
		fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
		slideMenuAdapter.setSelectedPosition(position);
		slideMenuAdapter.notifyDataSetChanged();
		menuLayout.closeDrawer(parent);
	}

}
