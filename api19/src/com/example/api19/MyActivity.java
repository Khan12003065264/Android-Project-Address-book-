package com.example.api19;

import android.app.*;
import android.os.Bundle;
import android.widget.TabHost;

import java.util.ArrayList;

public class MyActivity extends Activity{
    /**
     * Called when the activity is first created.
     */
    static public ArrayList<ContactInfo> phoneBook= new ArrayList<ContactInfo>();
    static Activity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mainActivity=this;

        setContentView(R.layout.main);

        TabHost mTabHost = (TabHost)findViewById(R.id.myTab);
        mTabHost.setup();

        TabHost.TabSpec spec = mTabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        //spec.setContent(new Intent().setClass(this, MyFragment.class));
        spec.setIndicator("Search");
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Logs");
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Favorites");
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("tab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Contacts");
        mTabHost.addTab(spec);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.add(R.id.tab4, new MyFragment4());
        ft.commit();

        /*
        MyFragment frag= new MyFragment();
        FragmentManager manager= getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.mainTextView, frag, "fragment1");
        transaction.commit();
        */
    }
}
