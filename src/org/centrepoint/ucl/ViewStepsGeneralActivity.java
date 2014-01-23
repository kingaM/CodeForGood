package org.centrepoint.ucl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewStepsGeneralActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_steps_general);
		
		super.onCreate(savedInstanceState);
		int tabnum = 0;
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			tabnum = extras.getInt("tabnum",0);

		display(tabnum);
	}
	
	private void display(int tabnum) {
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_steps_general, menu);
		return true;
	}

}
