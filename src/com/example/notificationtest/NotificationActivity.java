package com.example.notificationtest;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);
		//取消通知，这样的话只要将通知点击开之后状态栏的标志就会自动消失，而不用等到从后台去销毁活动。
		//NotificationManager对活动进行管理
		NotificationManager notificationManager=(NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(1);
	}

}
