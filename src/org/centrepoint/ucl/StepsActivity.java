package org.centrepoint.ucl;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;

public class StepsActivity extends TabActivity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_steps);
		
		Resources res = getResources();
		
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, ViewStepsGeneralActivity.class);
		intent.putExtra("tabnum",0);
		spec = tabHost.newTabSpec("MenuTab1");
		spec.setIndicator("", res.getDrawable(R.drawable.one));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewStepsGeneralActivity.class);
		intent.putExtra("tabnum",1);
		spec = tabHost.newTabSpec("MenuTab2");
		spec.setIndicator("", res.getDrawable(R.drawable.two));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewStepsGeneralActivity.class);
		intent.putExtra("tabnum",2);
		spec = tabHost.newTabSpec("MenuTab3");
		spec.setIndicator("", res.getDrawable(R.drawable.three));
		spec.setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_steps, menu);
		return true;
	}

}
