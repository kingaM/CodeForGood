package org.centrepoint.ucl;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class GetHelp extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.helppage);

		// storing string resources into Array
		String[] choices = {"I am homeless and I need somewhere to stay",
				"I am a victim of abuse",
				"I am worried about my sexual health",
				"I am in debt and cannot pay my rent",
				"I am a refugee, asylum seeker or immigrant"};


		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.gethelp, choices));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		// listening to single list item on click
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				AlertDialog.Builder dialog = new AlertDialog.Builder(GetHelp.this);
				//change with [position]
				System.out.println(position);
				if(position == 0)
					dialog.setMessage("Call Shelter on 0808 800 4444\n8am-8pm Mon-Fri\n8am-5pm Sat-Sun\nFree from UK landlines");
				if(position == 1)
					dialog.setMessage("Childline: 0800 1111 (free, 24 hrs)\nNational Domestic Violence Helpline: 0808 2000 247 (free, 24 hrs).\nSamaritans: 08457 90 90 90 (24 hrs)");
				if(position == 2)
					dialog.setMessage("Brook: 0808 802 1234\nFamily Planning Association: 0845 122 8690\nBritish Pregnancy Advisory Service: 08457 30 40 30\nNHS Direct: 0845 4647");
				if(position == 3)
					dialog.setMessage("National Debt Helpline: 0800 808 4000");
				if(position == 4)
					dialog.setMessage("The Refugee Council is the leading charity in the UK working with asylum seekers and refugees\n\nwww.refugeecouncil.org.uk\n\nAdvice line: Call 0808 808 2255 or 0808 808 2259\nLanguages currently available include Kurdish Sorani, Farsi, Mandarin, Pashtu, Arabic, Tigrinya and English.\n\nOpening hours: Mondays, Tuesdays, Thursdays, Fridays: 9.30am - 1pm and 2pm - 5pm, Wednesdays: 2pm - 5pm\n");


				dialog.setIcon(android.R.drawable.arrow_down_float);
				dialog.setTitle("Info");
				dialog.setPositiveButton("Ok",
						new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int whichButton)
					{
					}
				});
//				dialog.setNegativeButton("Go Back",
//						new DialogInterface.OnClickListener(){
//					@Override
//					public void onClick(DialogInterface dialog, int whichButton)
//					{
//					}
//				});
				AlertDialog dialog2 = dialog.create();
				dialog.show();
			}
		});

	}
}