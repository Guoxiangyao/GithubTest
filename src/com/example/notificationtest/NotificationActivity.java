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
		//ȡ��֪ͨ�������Ļ�ֻҪ��֪ͨ�����֮��״̬���ı�־�ͻ��Զ���ʧ�������õȵ��Ӻ�̨ȥ���ٻ��
		//NotificationManager�Ի���й���
		NotificationManager notificationManager=(NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(1);
	}

}
