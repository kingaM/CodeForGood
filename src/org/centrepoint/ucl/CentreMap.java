package org.centrepoint.ucl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class CentreMap extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_centre_map);
		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		MapController myMapController = mapView.getController();
		myMapController.setCenter(new GeoPoint(51507334,-127683));
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.home);
		MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(resize(drawable),
				this);
		GeoPoint point = new GeoPoint(51514171, -1354681);
		//OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
		//itemizedoverlay.addOverlay(overlayitem);
		//mapOverlays.add(itemizedoverlay);
		
		
		HostelLocations hl = new HostelLocations();
		
		for(OverlayItem oi : hl.hostelLocations) {
			itemizedoverlay.addOverlay(oi);
		}
		
		mapOverlays.add(itemizedoverlay);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_centre_map, menu);
		return true;
	}
	
	private Drawable resize(Drawable image) {
	    Bitmap d = ((BitmapDrawable)image).getBitmap();
	    Bitmap bitmapOrig = Bitmap.createScaledBitmap(d, 30, 30, false);
	    return new BitmapDrawable(bitmapOrig);
	}

}