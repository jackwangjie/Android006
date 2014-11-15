package com.test.alertdialogtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showDialog2(View view){

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

		View v = inflater.inflate(R.layout.dialog_layout,(ViewGroup)findViewById(R.id.liner_root));

		TextView tv_messsage = (TextView)v.findViewById(R.id.tv_message);

		tv_messsage.setText("你人品太差了");

		builder.setView(v);

		AlertDialog dialog = builder.create();

		dialog.show();
	}


	public void showDialog(View view){

		final CharSequence [] items = {"选项1","选项2","选项3"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		/*	builder.setItems(items,new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {

				Toast.makeText(MainActivity.this, "选中了"+items[which],Toast.LENGTH_SHORT).show();
			}
		});*/

		builder.setSingleChoiceItems(items,0, new OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {

				Toast.makeText(MainActivity.this, "选中了"+items[which],Toast.LENGTH_SHORT).show();
				dialog.cancel();
			}
		});

		builder.create().show();

	}
}
