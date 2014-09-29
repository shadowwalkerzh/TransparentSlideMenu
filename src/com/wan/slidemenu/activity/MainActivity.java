package com.wan.slidemenu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wan.slidemenu.MenuControl;
import com.wan.slidemenu.R;

public class MainActivity extends FragmentActivity {

	private Button headBtn;
	private TextView titleView;
	private MenuControl menuControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		headBtn = (Button) findViewById(R.id.menu);
		titleView = (TextView)findViewById(R.id.title);

		//初始化菜单
		menuControl = new MenuControl(this);
		menuControl.initMenu(titleView);

		// ActionBar上的Button监听
		headBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				menuControl.toggleMenu();
			}
		});
	}

}
