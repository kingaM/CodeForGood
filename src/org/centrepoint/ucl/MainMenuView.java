package org.centrepoint.ucl;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainMenuView extends TabActivity {
	
	private View layout;
	DummyDatabaseService ds = new DummyDatabaseService();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forums);

		Resources res = getResources();

		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, ViewTopicsGeneralActivity.class);
		intent.putExtra("tabnum",0);
		spec = tabHost.newTabSpec("MenuTab1");
		spec.setIndicator("General", res.getDrawable(R.drawable.general));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewTopicsGeneralActivity.class);
		intent.putExtra("tabnum",1);
		spec = tabHost.newTabSpec("MenuTab2");
		spec.setIndicator("Housing", res.getDrawable(R.drawable.housing));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewTopicsGeneralActivity.class);
		intent.putExtra("tabnum",2);
		spec = tabHost.newTabSpec("MenuTab3");
		spec.setIndicator("Work", res.getDrawable(R.drawable.work));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewTopicsGeneralActivity.class);
		intent.putExtra("tabnum",3);
		spec = tabHost.newTabSpec("MenuTab4");
		spec.setIndicator("Health", res.getDrawable(R.drawable.health));
		spec.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ViewTopicsGeneralActivity.class);
		intent.putExtra("tabnum",4);
		spec = tabHost.newTabSpec("MenuTab5");
		spec.setIndicator("Money", res.getDrawable(R.drawable.money));
		spec.setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}
	
	

		
}
