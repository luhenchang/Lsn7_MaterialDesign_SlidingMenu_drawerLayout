package com.example.ls.lsn7_materialdesign_slidingmenu_drawerlayout;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private MyDrawerListener drawerableLinstner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        drawerableLinstner = new MyDrawerListener();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        drawerLayout.addDrawerListener(drawerableLinstner);
        /*drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            *//**
         * @param drawerView 这个是抽屉里面移动的子布局。
         * @param slideOffset 这个是抽屉里面移动的距离比例0-1
         *//*
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset){
                View zhong_view = drawerLayout.findViewById(R.id.neirou);
                View rightview = drawerView;
                float scale = 1 - slideOffset;//1-0
                float leftScale = (float) (1 - 0.3 * scale);//1-(0.3-0)=0.7->1
                float rightScale = (float) (0.7f + 0.3 * scale);//0.7+(0.3-0)=1->0.7
                rightview.setScaleX(leftScale);
                rightview.setScaleY(leftScale);

                zhong_view.setScaleX(rightScale);
                zhong_view.setScaleY(rightScale);
                zhong_view.setTranslationX(rightview.getMeasuredWidth() * (1 - scale));//0-width;

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        drawerLayout.removeDrawerListener(drawerableLinstner);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    class MyDrawerListener implements DrawerLayout.DrawerListener {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            //中间的布局
            View zhong_view = drawerLayout.findViewById(R.id.neirou);
            //左边侧滑的布局
            View rightview = drawerView;
            float leftScaleXY = (float) (1 - (1 - slideOffset) * 0.2);
            float centerScaleXY= (float) (1-slideOffset*0.2);
            rightview.setScaleX(leftScaleXY);
            rightview.setScaleY(leftScaleXY);

            zhong_view.setScaleX(centerScaleXY);
            zhong_view.setScaleY(centerScaleXY);
            zhong_view.setTranslationX(rightview.getMeasuredWidth() * slideOffset);//0-width;
        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
