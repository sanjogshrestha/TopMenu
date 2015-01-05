package com.sanjogpractise.practisetopmenu;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.view.MenuItemCompat;


public class TopMain extends Activity implements View.OnClickListener
{
	private MenuDrawer mMenuDrawer;
    private TextView mContentTextView;
    // Google Map 
    private GoogleMap googleMap;
    

	 private static final int MENU_OVERFLOW = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_layoutsample);
	        
	        mMenuDrawer = (MenuDrawer) findViewById(R.id.drawer);
	        mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);
	        
	        mContentTextView = (TextView) findViewById(R.id.contentText);
	        
	        
	        
	        findViewById(R.id.item1).setOnClickListener(this);
	        findViewById(R.id.item2).setOnClickListener(this);
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem overflowItem = menu.add(0, MENU_OVERFLOW, 0, null);
        MenuItemCompat.setShowAsAction(overflowItem, MenuItem.SHOW_AS_ACTION_ALWAYS);

        overflowItem.setIcon(R.drawable.ic_launcher);
        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
         case android.R.id.home:
             NavUtils.navigateUpFromSameTask(this);
             return true;
         case MENU_OVERFLOW:
             mMenuDrawer.toggleMenu();
             return true;
     }
     return super.onOptionsItemSelected(item);
	}
	 @Override
	    public void onClick(View v) {
	        String tag = (String) v.getTag();
	        mContentTextView.setText(String.format("%s clicked.", tag));
	        mMenuDrawer.setActiveView(v);
	    }
}
