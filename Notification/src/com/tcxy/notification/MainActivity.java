package com.tcxy.notification;

import java.util.Date;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;

public class MainActivity extends Activity {

	Notification notification;
	
	PendingIntent pendingIntent;
	
	NotificationManager notificationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	}

	public void show(View view){
		//1��Get a reference to the NotificationManager:

		//2��Instantiate the Notification:

		Date date = new Date();

		notification = new Notification(R.drawable.ic_launcher, "����һ��֪ͨ", date.getTime());

		//Notification notification = new Notification(parcel);

		//3��Define the notification's message and PendingIntent:
		Intent intent = new Intent();

		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));

		pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

		notification.setLatestEventInfo(this, "����", "����", pendingIntent);

		//4��Pass the Notification to the NotificationManager:

		notificationManager.notify(1, notification);


	}

	public void show2(View view){

		notification.setLatestEventInfo(this, "δ������", "����110��119�Ķ���", pendingIntent);

		notificationManager.notify(2, notification);
	} 
}
