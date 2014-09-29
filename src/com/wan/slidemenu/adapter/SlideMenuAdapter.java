package com.wan.slidemenu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wan.slidemenu.R;
import com.wan.slidemenu.bean.MenuItemBean;

public class SlideMenuAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<MenuItemBean> menuItemList;
	private int selectedPosition = 0;
	
	public SlideMenuAdapter(Context context ,ArrayList<MenuItemBean> list){
		this.context = context;
		this.menuItemList = list;
	}
	
	public void setSelectedPosition(int position){
		this.selectedPosition = position;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuItemList.size();
	}

	@Override
	public Object getItem(int position) {
		return menuItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder viewHolder = null;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.slidemenu_item, null);
			viewHolder = new ViewHolder();
			viewHolder.menuItemName = (TextView)convertView.findViewById(R.id.menu_name);
			viewHolder.menuItemIcon = (ImageView)convertView.findViewById(R.id.menu_icon);
			convertView.setTag(viewHolder);
		}
		viewHolder = (ViewHolder)convertView.getTag();
		viewHolder.menuItemName.setText(menuItemList.get(position).getMenuItemName());
		viewHolder.menuItemIcon.setImageResource(menuItemList.get(position).getMenuItemIcon());
		if(selectedPosition == position)
			convertView.setBackgroundResource(R.drawable.bg);
		else
			convertView.setBackgroundColor(Color.parseColor("#75293237"));
		return convertView;
	}

	class ViewHolder{
		TextView menuItemName;
		ImageView menuItemIcon;
	}
	
}
