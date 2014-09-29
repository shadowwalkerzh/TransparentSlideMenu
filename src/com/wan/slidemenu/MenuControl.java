package com.wan.slidemenu;

import java.util.ArrayList;

import com.wan.slidemenu.adapter.DrawerOnItemClickListener;
import com.wan.slidemenu.adapter.MyDrawerListener;
import com.wan.slidemenu.adapter.SlideMenuAdapter;
import com.wan.slidemenu.bean.MenuItemBean;
import com.wan.slidemenu.utils.BaseUtils;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MenuControl {

	private FragmentActivity fa = null;
	private DrawerLayout menuLayout;
	private ListView menuElementsList;

	private SlideMenuAdapter slideMenuAdapter;
	private ArrayList<MenuItemBean> menuItemList;

	public MenuControl(FragmentActivity fa) {
		this.fa = fa;
	}

	public void initMenu(TextView titleView) {
		menuLayout = (DrawerLayout) fa.findViewById(R.id.menu_layout);
		menuElementsList = (ListView) fa.findViewById(R.id.menu_elements);
		// 设置阴影
		menuLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		menuItemList = new ArrayList<MenuItemBean>();

		menuItemList = BaseUtils.arrayToList(fa);
		slideMenuAdapter = new SlideMenuAdapter(fa, menuItemList);
		menuElementsList.setAdapter(slideMenuAdapter);
		menuElementsList.getLayoutParams().width = BaseUtils.getScreenPixels(fa).getScreenWidth()*2/3;
		menuElementsList.setOnItemClickListener(new DrawerOnItemClickListener(
				menuLayout, fa, slideMenuAdapter));
		menuLayout.setDrawerListener(new MyDrawerListener(titleView, "菜单测试"));
	}

	public void toggleMenu() {

		if (menuLayout.isDrawerOpen(GravityCompat.START)) {
			menuLayout.closeDrawer(GravityCompat.START);
		} else
			menuLayout.openDrawer(GravityCompat.START);
	}
}
