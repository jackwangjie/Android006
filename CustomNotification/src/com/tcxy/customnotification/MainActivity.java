package com.tcxy.customnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void show(View view){

		NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification(R.drawable.ic_lock_airplane_mode,"自定义通知",System.currentTimeMillis());

		RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
		
		notification.contentView = remoteViews;
		
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		notification.contentIntent = pendingIntent;
		
		notificationManager.notify(1,notification);
		
	}

}
