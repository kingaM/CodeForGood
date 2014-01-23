package org.centrepoint.ucl;

import java.util.List;
import org.centrepoint.ucl.RMWidget.RadialMenuEntry;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private RMWidget PieMenu;
	private LinearLayout ll;
	

	// private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DummyServer.getRepliesData();
		DummyServer.getTopicsData();
		// ------------------------------------------------------------------------------------------
		// Generating Pie view
		// ------------------------------------------------------------------------------------------
		setContentView(R.layout.radial_menu);

		/*
		 * There are 3 ways to add the view to also make it removeable. 1.)
		 * Dialog box. Use the .show() and .dismiss() commands 2.) Just add to
		 * an existing layer using the addView() and removeView() commands 3.)
		 * Add new layout using the addContentView; then use the addView() and
		 * removeView()
		 */

		ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		addContentView(ll, params);
		
		int xScreenSize = (getResources().getDisplayMetrics().widthPixels);
		int yScreenSize = (getResources().getDisplayMetrics().heightPixels);
		int xCenter = xScreenSize / 2;
		int yCenter = yScreenSize / 2;


		PieMenu = new RMWidget(getBaseContext());

		PieMenu.setSourceLocation(xCenter, yCenter);
		PieMenu.setShowSourceLocation(false);
		PieMenu.setCenterLocation(xCenter, yCenter + 25);

		PieMenu.setCenterCircle(new close());
		PieMenu.addMenuEntry(new forum());		
		PieMenu.addMenuEntry(new findUs());
		PieMenu.addMenuEntry(new getHelp());
		PieMenu.addMenuEntry(new stories());
		PieMenu.addMenuEntry(new aboutUs());

		ll.addView(PieMenu);
		PieMenu.setAnimationSpeed(1500);
	}
	
	
	public class close implements RadialMenuEntry {

		@Override
		public String getName() {
			return "Close";
		}

		@Override
		public String getLabel() {
			return null;
		}

		@Override
		public int getIcon() {
			//return 0;
			return android.R.drawable.ic_menu_rotate;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {

			//System.out.println("Close Menu Activated");
			//((LinearLayout) PieMenu.getParent()).removeView(PieMenu);

		}
	}
	
	public class stories implements RadialMenuEntry {
		@Override
		public String getName() {
			return "Clicked find us";
		}

		@Override
		public String getLabel() {
			return "Life\nStories";
		}

		@Override
		public int getIcon() {
			return R.drawable.diary;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {
			Intent it = new Intent(MainActivity.this, LifeStories.class);
			startActivity(it);
		}
	}
	public class getHelp implements RadialMenuEntry {
		@Override
		public String getName() {
			return "Clicked get help";
		}

		@Override
		public String getLabel() {
			return "Get Help";
		}

		@Override
		public int getIcon() {
			return R.drawable.help2;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {
			Intent it = new Intent(MainActivity.this, GetHelp.class);
			startActivity(it);
		}
	}

	public class forum implements RadialMenuEntry {
		@Override
		public String getName() {
			return "Clicked forum";
		}

		@Override
		public String getLabel() {
			return "Forum";
		}

		@Override
		public int getIcon() {
			return R.drawable.users_2;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {
			Intent it = new Intent(MainActivity.this, MainMenuView.class);
			startActivity(it);
		}
	}

	
	public class findUs implements RadialMenuEntry {
		@Override
		public String getName() {
			return "Clicked find us";
		}

		@Override
		public String getLabel() {
			return "Find Us";
		}

		@Override
		public int getIcon() {
			return R.drawable.find_us2;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {
		Intent it = new Intent(MainActivity.this, CentreMap.class);
		startActivity(it);
		}
	}


	public class aboutUs implements RadialMenuEntry {
		@Override
		public String getName() {
			return "Clicked about us";
		}

		@Override
		public String getLabel() {
			return "About Us";
		}

		@Override
		public int getIcon() {
			return R.drawable.aboutus;
		}

		@Override
		public List<RadialMenuEntry> getChildren() {
			return null;
		}

		@Override
		public void menuActiviated() {
			Intent it = new Intent(MainActivity.this, AboutUsActivity.class);			
			startActivity(it);
		}
	}
}
