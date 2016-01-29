package com.example.notificationtest;

/**
 * ֪ͨ��ʹ�ã���ĳ��Ӧ�ó���ϣ�����û�����һЩ��ʾ��Ϣ������
 * Ӧ�ó����ֲ���ǰ̨���У��Ϳ��Խ���֪ͨʵ�֡�
 * ����һ��֪ͨ�Ժ��ֻ����Ϸ���״̬������ʾһ��֪ͨ��ͼ��
 * ����״̬�������ʾһ��֪ͨ��ͼ��
 * ����֪ͨ��һ�㲽�裺
 * 1.������Ҫһ��NotificationManager����֪ͨ���й���
 * ���Ե���getSystemService()��������á�getSystemService()����
 * ����һ���ַ�����������ȷ����ȡϵͳ���Ǹ�����
 * 2.����һ��Motification��������������ڴ洢֪ͨ����ĸ�����Ϣ��
 * ���ǿ���ʹ�������вι��캯�������д���
 * 3.�趨֪ͨ�Ĳ���
 * 4.������notify()������֪ͨ��ʾ������
 * 
 */
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.send_notice);
		// ����֪ͨ�ĵ���¼�ֻ��ʵ�ּ����Ľӿ�
		button.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.send_notice:
			NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			// ״̬����ʾ������
			Notification notification = new Notification(
					R.drawable.ic_launcher, "This is ticker text",
					System.currentTimeMillis());
			// setLatestEventInfo�Ǹ�֪ͨ����һ����׼����

			Intent intent = new Intent(this, NotificationActivity.class);
			// getActivity��ָȥ��ȡһ�������˼������getBraodcast��getService
			// ���ĸ���������ȷ��pendingIntent����Ϊ
			/**
			 * FLAG_CANCEL_CURRENT�������PendingIntent�Ѿ����ڣ����������µ�֮ǰȡ����ǰ�ġ�
			 * FLAG_NO_CREATE�������PendingIntent�����ڣ�ֱ�ӷ���null�����Ǵ���һ��PendingIntent.
			 * FLAG_ONE_SHOT:��PendingIntentֻ����һ�Σ���send()����ִ�к��Զ�ȡ����
			 * FLAG_UPDATE_CURRENT�������PendingIntent�Ѿ����ڣ������´����Intent���µ�ǰ�����ݡ�
			 */
			
			//������ͼ�����ӳ���ͼʵ��
			PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
					PendingIntent.FLAG_CANCEL_CURRENT);
			//���ӳ���ͼд�벼��
			notification.setLatestEventInfo(this, "This is content title",
					"This is content text", pi);
			//������Ϣ����ʾ��ʽ���������Ĭ�ϵ���ʾ��ʽ
			notification.defaults=Notification.DEFAULT_ALL;
			manager.notify(1, notification);
			break;
		default:
			break;
		}
	}
}
