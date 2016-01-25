package com.swin.myapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import com.googlecode.androidannotations.annotations.EActivity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

@EActivity
public class TabbarActivity extends FragmentActivity {

	ActionBar actionBar;
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		TabListener<Goals_> tlGoals = new TabListener<Goals_>(this, "Goals",
				Goals_.class, "Goals");
		createTab("Goals", tlGoals);
		TabListener<DreamList_> tlDreamList = new TabListener<DreamList_>(this,
				"DreamList", DreamList_.class, "DreamList");
		createTab("DreamList", tlDreamList);
		TabListener<About_> tlAbout = new TabListener<About_>(this, "About",
				About_.class, "About");
		createTab("About", tlAbout);

	}

	public void createTab(String label, TabListener<?> tabListener) {
		Tab tab = actionBar.newTab();
		tab.setText(label);
		tab.setTabListener(tabListener);
		actionBar.addTab(tab);
	}

	public class TabListener<T extends Fragment> implements
			android.app.ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		private final String mTitle;

		/**
		 * Constructor used each time a new tab is created.
		 * 
		 * @param activity
		 *            The host Activity, used to instantiate the fragment
		 * @param tag
		 *            The identifier tag for the fragment
		 * @param clz
		 *            The fragment's Class, used to instantiate the fragment
		 */
		public TabListener(Activity activity, String tag, Class<T> clz,
				String title) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
			mTitle = title;
		}

		/* The following are each of the ActionBar.TabListener callbacks */

		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			getActionBar().setTitle(mTitle);
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}
	}

}