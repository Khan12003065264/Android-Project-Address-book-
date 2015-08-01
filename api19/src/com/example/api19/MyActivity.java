package com.example.api19;

import android.app.*;
import android.os.Bundle;
import android.widget.TabHost;

public class MyActivity extends Activity{
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        /*
        MyFragment frag= new MyFragment();
        FragmentManager manager= getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.mainTextView, frag, "fragment1");
        transaction.commit();
        */
    }
}
