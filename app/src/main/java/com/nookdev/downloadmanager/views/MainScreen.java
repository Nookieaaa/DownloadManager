package com.nookdev.downloadmanager.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;

import com.nookdev.downloadmanager.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        attachFragment();
        setUpViews();
        //handleNewDownload();
    }



    private void handleNewDownload() {
        Intent startIntent = getIntent();

        switch (startIntent.getAction()){
            case Intent.ACTION_MAIN: {
                return;
            }
            case Intent.ACTION_VIEW:{
                FragmentManager fm = getSupportFragmentManager();
                if (fm.findFragmentByTag(DownloadDialog.TAG_NAME)==null)
                {
                    DownloadDialog dialog = new DownloadDialog();
                    String source = startIntent.getDataString();
                    String filename = URLUtil.guessFileName(startIntent.getDataString(), null, null);
                    dialog.setSource(source);
                    dialog.setFilename(filename);
                    dialog.show(fm, DownloadDialog.TAG_NAME);
                }
            }
        }

    }

    @OnClick (R.id.fab)
    public void fabClick(View v){
        Intent intent = new Intent(this, NewDownloadActivity.class);
        startActivity(intent);
       /* DownloadDialog dd = new DownloadDialog();
        dd.show(getSupportFragmentManager(),"dialog");*/
    }

    private void setUpViews() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void attachFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentByTag(DownloadsListFragment.TAG_NAME)==null) {
            FragmentTransaction ft = fm.beginTransaction();
            DownloadsListFragment downloadsListFragment = new DownloadsListFragment();
            ft.add(R.id.mainframe, downloadsListFragment, DownloadsListFragment.TAG_NAME);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_downloads_all) {
            // Handle the camera action
        } else if (id == R.id.menu_downloads_video) {

        } else if (id == R.id.menu_downloads_audio) {

        } else if (id == R.id.menu_downloads_apk) {

        } else if (id == R.id.menu_downloads_other) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
