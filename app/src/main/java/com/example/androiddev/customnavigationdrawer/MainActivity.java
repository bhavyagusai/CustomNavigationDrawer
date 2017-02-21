package com.example.androiddev.customnavigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androiddev.customnavigationdrawer.fragment.ClearanceNoticeFragment;
import com.example.androiddev.customnavigationdrawer.fragment.ProjectDirectoryFragment;

public class MainActivity extends FragmentActivity implements NavigationDrawerCallbacks {
    private Toolbar mToolbar;
    public static int navItemIndex = 0;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private static final String TAG_CLEARANCE = "clearance";
    private static final String TAG_PROJECT = "project";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_CHANGEPWD = "changepwd";
    private static final String TAG_SUPPORT = "support";
    private static final String TAG_LOGOUT  = "logout";
    public static String CURRENT_TAG = TAG_CLEARANCE;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mToolbar.setTitle("Clearance");

        //getSupportActionBar().setIcon(R.drawable.ic_actionbar_archive);
        //setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_CLEARANCE;
            Fragment newFragment = new ClearanceNoticeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, newFragment).commit();
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.e("click", "home click fire");
                mNavigationDrawerFragment.openDrawer(GravityCompat.START);  // OPEN DRAWER
        }
            mNavigationDrawerFragment.closeDrawer();
            return true;
    }
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        switch (position) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case 0:
                navItemIndex = 0;
                CURRENT_TAG = TAG_CLEARANCE;

                Fragment newFragment = new ClearanceNoticeFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, newFragment).commit();
                break;

            case 1:
                Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                navItemIndex = 1;
                CURRENT_TAG = TAG_PROJECT;

                Fragment projectFrag = new ProjectDirectoryFragment();
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.container, projectFrag).commit();
                break;

            case 2:
                Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                navItemIndex = 2;
                CURRENT_TAG = TAG_PROFILE;

                break;

            case 3:
                navItemIndex = 3;
                CURRENT_TAG = TAG_CHANGEPWD;
                break;

            case 4:
                navItemIndex = 4;
                CURRENT_TAG = TAG_SUPPORT;
                break;

            case 5:
                navItemIndex = 5;
                CURRENT_TAG = TAG_LOGOUT;
                break;

            default:
                navItemIndex = 0;
                //loadHomeFragment();
        }
    }

    /*private void loadHomeFragment() {


        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.container, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        //mNavigationDrawerFragment.closeDrawer();

    }*/



   /* private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                ClearanceNoticeFragment homeFragment = new ClearanceNoticeFragment();
                return homeFragment;

            case 1:
                // home
                ProjectDirectoryFragment projectDirectoryFragment = new ProjectDirectoryFragment();
                return projectDirectoryFragment;

            default:
                return new ClearanceNoticeFragment();
        }
    }*/
    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
