package org.centrepoint.ucl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class AboutUsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);
		
		VideoView videoview = (VideoView) findViewById(R.id.videoView1);

		Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.aboutus);

		videoview.setVideoURI(uri);
		videoview.start();

	}
}
