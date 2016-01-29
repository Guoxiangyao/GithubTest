package com.example.notificationtest;

/**
 * 通知的使用：当某个应用程序希望向用户发出一些提示信息，而该
 * 应用程序又不在前台运行，就可以借助通知实现。
 * 发出一条通知以后，手机最上方的状态栏会显示一个通知的图标
 * 下拉状态栏后会显示一个通知的图标
 * 创建通知的一般步骤：
 * 1.首先需要一个NotificationManager来对通知进行管理，
 * 可以调用getSystemService()方法来获得。getSystemService()方法
 * 接收一个字符串参数用于确定获取系统的那个服务。
 * 2.创建一个Motification对象，这个对象用于存储通知所需的各种信息，
 * 我们可以使用它的有参构造函数来进行创建
 * 3.设定通知的布局
 * 4.最后调用notify()方法将通知显示出来。
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
		// 发送通知的点击事件只能实现监听的接口
		button.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.send_notice:
			NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			// 状态栏显示的内容
			Notification notification = new Notification(
					R.drawable.ic_launcher, "This is ticker text",
					System.currentTimeMillis());
			// setLatestEventInfo是给通知设置一个标准布局

			Intent intent = new Intent(this, NotificationActivity.class);
			// getActivity是指去获取一个活动的意思，还有getBraodcast、getService
			// 第四个参数用于确定pendingIntent的行为
			/**
			 * FLAG_CANCEL_CURRENT：如果该PendingIntent已经存在，则在生成新的之前取消当前的。
			 * FLAG_NO_CREATE：如果该PendingIntent不存在，直接返回null而不是创建一个PendingIntent.
			 * FLAG_ONE_SHOT:该PendingIntent只能用一次，在send()方法执行后，自动取消。
			 * FLAG_UPDATE_CURRENT：如果该PendingIntent已经存在，则用新传入的Intent更新当前的数据。
			 */
			
			//构造意图构造延迟意图实例
			PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
					PendingIntent.FLAG_CANCEL_CURRENT);
			//将延迟意图写入布局
			notification.setLatestEventInfo(this, "This is content title",
					"This is content text", pi);
			//设置消息的提示方式，这里采用默认的提示方式
			notification.defaults=Notification.DEFAULT_ALL;
			manager.notify(1, notification);
			break;
		default:
			break;
		}
	}
}
