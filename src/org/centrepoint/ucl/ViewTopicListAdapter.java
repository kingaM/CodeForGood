package org.centrepoint.ucl;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewTopicListAdapter extends ArrayAdapter<Topic> {

	int resource;
	String response;
	Context context;

	// Initialise adapter
	public ViewTopicListAdapter(Context context, int resource, ArrayList<Topic> items) {
		super(context, resource, items);
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemView;

		Topic Topic = getItem(position);

		// Inflate the view
		if (convertView == null) {
			itemView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater) getContext().getSystemService(inflater);
			vi.inflate(resource, itemView, true);
		} else {
			itemView = (LinearLayout) convertView;
		}
		// Get the text boxes
		TextView title = (TextView) itemView.findViewById(R.id.post_list_title);
		TextView username = (TextView) itemView.findViewById(R.id.post_list_username);

		// Assign the appropriate data from our alert object above
		title.setText(Topic.getTitle());
		username.setText(Topic.getMessage());

		return itemView;
	}
	
	
}
