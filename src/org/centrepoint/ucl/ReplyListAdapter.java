package org.centrepoint.ucl;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReplyListAdapter extends ArrayAdapter<Reply> {

	int resource;
	String response;
	Context context;
	private Reply reply;
	private TextView score;

	// Initialise adapter
	public ReplyListAdapter(Context context, int resource, ArrayList<Reply> items) {
		super(context, resource, items);
		this.resource = resource;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemView;

		reply = getItem(position);

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
		score = (TextView) itemView.findViewById(R.id.reply_list_score);
		TextView date = (TextView) itemView.findViewById(R.id.reply_list_date);
		ImageView down = (ImageView) itemView.findViewById(R.id.reply_list_down);
		ImageView up = (ImageView) itemView.findViewById(R.id.reply_list_up);
		TextView username = (TextView) itemView.findViewById(R.id.reply_list_username);
		TextView content = (TextView) itemView.findViewById(R.id.reply_list_content);

		// Assign the appropriate data from our alert object above
		score.setText(Integer.toString(reply.getScore()));
		date.setText(reply.getDate());
		username.setText(reply.getUsername());
		content.setText(reply.getContent()+"\n");
		
		up.setOnTouchListener(new OnTouchListener()
        {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				reply.incrementScore();
				
				score.setText(Integer.toString(reply.getScore()));
				return false;
			}
       });
		
		down.setOnTouchListener(new OnTouchListener()
        {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				reply.decrementScore();
				score.setText(Integer.toString(reply.getScore()));
				return false;
			}
       });

		return itemView;
	}

}
