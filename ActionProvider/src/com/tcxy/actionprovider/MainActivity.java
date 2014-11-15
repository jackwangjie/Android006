package com.tcxy.actionprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ShareActionProvider;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);

		ShareActionProvider actionProvider = (ShareActionProvider) menu.findItem(R.id.action_settings).getActionProvider();

		actionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
		
		Intent intent = new Intent();
		
		intent.setAction(Intent.ACTION_SEND);
		
		intent.setType("text/*");
		
		intent.putExtra(Intent.EXTRA_TEXT,"¹þ¹þ¹þ");
		
		actionProvider.setShareIntent(intent);

		return true;

	}

}
