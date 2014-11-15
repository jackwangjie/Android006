package com.tcxy.progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends Activity {

	private Handler handler = new MyHandler();

	private ProgressDialog dialog;

	class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			dialog.setProgress((Integer)msg.obj);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showDialog(View view){

		ProgressDialog progressDialog = ProgressDialog.show(this, "","ÕýÔÚ¼ÓÔØ",true);

		progressDialog.show();
	}

	public void showDialog2(View view){

		dialog = new ProgressDialog(this);

		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

		dialog.setProgress(0);

		dialog.show();

		new Thread(){
			public void run() {
				int progress=0;
				while(progress<100){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progress++;

					Message msg = handler.obtainMessage();
					msg.obj = progress;
					handler.sendMessage(msg);
				}
			};
		}.start();
	}

}
