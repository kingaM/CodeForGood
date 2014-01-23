package org.centrepoint.ucl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ReplyResultsList extends ListActivity {

	ArrayList<Reply> replies;
	ReplyListAdapter adapter;
	DummyDatabaseService ds;
	private Integer topic_key;
	private View layout;

	public ReplyResultsList() {
		replies = new ArrayList<Reply>();
		ds = new DummyDatabaseService();
		adapter = null;
		this.topic_key = 0;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		display(DummyServer.getRepliesSize(), topic_key);
	}

	protected void display(int records, int topic_key) {
		replies.clear();
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			this.topic_key = extras.getInt("topic_key",0);
		DummyServer.getTopicsData();
		String[] fields;
		for (int k = 0; k < records; k++) {
			fields = ds.retrieveReply(k,this.topic_key);
			if (fields != null) {
				replies.add(new Reply(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),
						fields[2],fields[3],Integer.parseInt(fields[4]),fields[5]));
			}
		}
		if (!replies.isEmpty()) {
			adapter = new ReplyListAdapter(this, R.layout.reply_list_item, replies);
			setListAdapter(adapter);
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//Optional
	}

	protected void setTopicKey(int topic_key) {
		this.topic_key = topic_key;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.reply_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.sendReply:
			showDialog();
			break;
		}
		return true;
	}

	private void showDialog() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		LayoutInflater  factory = LayoutInflater.from(this);
		layout = factory.inflate(R.layout.new_reply,null);
		alert.setView(layout);

		alert.setPositiveButton("Reply", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {

				EditText content = (EditText) layout.findViewById(R.id.contentReply);
				String value = content.getText().toString();
				if ((value == null) || value.equals(""))
					value = "No comment";
				Calendar cal = Calendar.getInstance();
				Date date = new Date();
				DateFormat df = DateFormat.getDateInstance();
				Log.d("DATE", df.format(date));
				Log.i("Forming reply","Topic key: " + topic_key);
				ds.sendReply(cal.getTimeInMillis()/1000000, topic_key,
						df.format(date),"", 0, value);
				DummyServer.setRepliesData();
				display(DummyServer.getRepliesSize(), topic_key);
			}
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Cancelled.
			}
		});

		alert.show();
	}

	@Override
	public void onResume() {
		super.onResume();
		display(DummyServer.getRepliesSize(), topic_key);
	}
}