package org.centrepoint.ucl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ViewTopicsGeneralActivity extends ListActivity {

	private ArrayList<Topic> Topics;
	private static Topic Topic;
	private String displayed_category;
	private View layout;
	ViewTopicListAdapter adapter;
	DummyDatabaseService ds;

	public ViewTopicsGeneralActivity() {
		Topics = new ArrayList<Topic>();
		ds = new DummyDatabaseService();
		displayed_category = "general";
		adapter = null;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int tabnum = 0;
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			tabnum = extras.getInt("tabnum",0);

		switch (tabnum) {
		case 0: displayed_category = "general"; break;
		case 1: displayed_category = "housing"; break;
		case 2: displayed_category = "work"; break;
		case 3: displayed_category = "health"; break;
		case 4: displayed_category = "money"; break;
		}
		display(DummyServer.getTopicsSize());
	}

	public void display(int num_Topics) {
		Topics.clear();
		DummyServer.getTopicsData();
		String[] fields;
		for (int k = 0; k < num_Topics; k++) {
			fields = ds.retrieveTopic(k,displayed_category);
			if (fields != null) {
				Topics.add(new Topic(Integer.parseInt(fields[0]),fields[1],fields[2],
						fields[3],Integer.parseInt(fields[4]),fields[5],fields[6]));
			}
		}
		if (!Topics.isEmpty()) {
			adapter = new ViewTopicListAdapter(this, R.layout.topic_list_item, Topics);
			setListAdapter(adapter);
		}
		
	}

	public static Topic getTopic()
	{
		return Topic;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		Topic = Topics.get(position);
		Intent myIntent = new Intent(this, ReplyResultsList.class);
		myIntent.putExtra("topic_key",Topic.getTopicKey());
		startActivity(myIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.post_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.sendPost:
			showDialog();
			break;
		}
		return true;
	}

	private void showDialog() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		//alert.setTitle("Title");
		//alert.setMessage("Message");

		// Set an EditText view to get user input 
		LayoutInflater  factory = LayoutInflater.from(this);
		layout = factory.inflate(R.layout.new_topic,null);
		alert.setView(layout);

		alert.setPositiveButton("Post", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				EditText topicTxt = (EditText) layout.findViewById(R.id.titlePost);
				EditText contentTxt = (EditText) layout.findViewById(R.id.contentPost);

				String topic = topicTxt.getText().toString();
				if (topic == null || topic.equals(""))
					topic = "No  title";
				String content = contentTxt.getText().toString();
				if (content == null || content.equals(""))
					content = "No comment";

				Calendar cal = Calendar.getInstance();
				Date date = new Date();
				DateFormat df = DateFormat.getDateInstance();
				Log.i("DATE", df.format(date));
				ds.sendTopic(cal.getTimeInMillis()/1000000, displayed_category,
						df.format(date), "Anonymous", 0, topic, content);
				display(DummyServer.getTopicsSize());
			}
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Cancelled
			}
		});

		alert.show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onResume() {
		super.onResume();
		display(DummyServer.getTopicsSize());
	}

}
