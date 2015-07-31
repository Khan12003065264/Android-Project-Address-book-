package com.example.api19;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

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
        spec.setIndicator("Contacts");
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Search");
        mTabHost.addTab(spec);

        spec = mTabHost.newTabSpec("tab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab3");
        mTabHost.addTab(spec);

        ArrayList<String> listItems= new ArrayList<String>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        ListView myList= (ListView) findViewById(R.id.myList);
        myList.setAdapter(adapter);
        listItems.add("Fahad");
        adapter.notifyDataSetChanged();
        adapter.add("Hussain");
        adapter.add("Khan");
        for(int i=0; i<10; i++)
            adapter.add("Item: "+(i+1));

        /*
        MyFragment frag= new MyFragment();
        FragmentManager manager= getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.mainTextView, frag, "fragment1");
        transaction.commit();
        */
    }
}
