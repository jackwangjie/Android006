package com.tcxy.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
//		View view = menu.getItem(R.id.action_settings).getActionView();
//		
//		TextView name = (TextView)view.findViewById(R.id.tv_name);
//		TextView number = (TextView)view.findViewById(R.id.tv_number);
//		
//		name.setText("ÐÕÃû");
//		
//		number.setText("µç»°");
		
		return true;
	}
	
	
}
