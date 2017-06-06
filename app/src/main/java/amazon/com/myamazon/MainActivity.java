package amazon.com.myamazon;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import amazon.com.myamazon.Utilities.Utility;
import amazon.com.myamazon.tabs.TabLayout;

public class MainActivity extends ActionBarActivity implements VivzAdapter.ClickListener {
private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    private RecyclerView recyclerView;
    private VivzAdapter vivzAdapter;
    private  boolean mUserLearnedDrawer;
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";
    private  boolean mSavedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerView=findViewById(R.id.drawer);
        recyclerView= (RecyclerView) findViewById(R.id.drawerlist);

        vivzAdapter=new VivzAdapter(getApplicationContext(),getData());
        recyclerView.setAdapter(vivzAdapter);
        vivzAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        Utility utility=new Utility();
        mUserLearnedDrawer= Boolean.valueOf(utility.readFromSharedPref(this,KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null){
            mSavedInstanceState=true;
        }

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            /** Called when drawer is closed */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            /** Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer){

                    mUserLearnedDrawer=true;
                    Utility utility=new Utility();
                    utility.writeToSharedPref(getApplicationContext(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6){
                    toolbar.setAlpha(1-slideOffset);
                }
            }
        };

        if(!mUserLearnedDrawer && !mSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
    @Override
        public void run() {

        mDrawerToggle.syncState();

    }
});
navigateHome();
    }

    void navigateTp(String url) {
        amazon.com.myamazon.WebViewFragment webViewFragment=new WebViewFragment();
        WebViewFragment.url=url;
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,webViewFragment).commit();


    }
public static List<Information> getData(){
    List<Information> data=new ArrayList<>();
    int icon[]={R.drawable.homeicon,R.drawable.aboutus,R.drawable.call,R.drawable.share};
    String []titles={"ABOUT US","CALL","SHARE"};
    for(int i=0;i<titles.length && i<icon.length;i++){

          Information current =new Information();
        current.itemId=icon[i];
        current.title=titles[i];
        data.add(current);
    }
    return data;

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void navigateHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TabLayout rFragment = new TabLayout();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame, rFragment);
        ft.commit();
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

    @Override
    public void itemclicked(View view, int position) {

        if (position == 0) {
alertBox();

        } if (position == 1) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + getResources().getString(R.string.MOBILE_NO)));
            startActivity(callIntent);

        } if (position == 2) {
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
            i.putExtra(android.content.Intent.EXTRA_TEXT, getResources().getString(R.string.APPLINK));
            startActivity(Intent.createChooser(i, getResources().getString(R.string.LBL_SHARE_VIA)));

        }

    }



    protected void alertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setMessage("We deliver food when you think you might not get it."+"\n"+"\nDeveloped By:CoreApps Lab"+"\nWe build powerful,feature intensive,client oriented,user friendly Web & Smartphone applications"+"\n\nReach us at:\n"+getResources().getString(R.string.companyAddress)+"\n"+getResources().getString(R.string.companyContactPerson)+"\n"+getResources().getString(R.string.companyEmailAddress)+"\n"+getResources().getString(R.string.companyMobNo)+"\n")
        builder.setMessage("We listen to your needs, design it to your specifications, and build it to your dreams" + "\n" + "\nDeveloped By:Lnmiit" + "\nWe build powerful,feature intensive,client oriented,user friendly Web & Smartphone applications, Animations , Web Development" + "\n\nReach us at:\n" + getResources().getString(R.string.companyAddress) + "\n" + getResources().getString(R.string.companyContactPerson) + "\n" + getResources().getString(R.string.companyEmailAddress) + "\n" + getResources().getString(R.string.companyMobNo) + "\n")
                .setCancelable(true)
                .setTitle(getString(R.string.app_name));
        AlertDialog alert = builder.create();
        alert.show();
    }
}
