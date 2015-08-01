package com.example.api19;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Fahad Khan on 7/31/2015.
 */
public class MyFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        ListView myList= (ListView) view.findViewById(R.id.myList);

        ArrayList<String> listItems= new ArrayList<String>();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listItems);
        myList.setAdapter(adapter);

        for(int i=0; i<10; i++)
            adapter.add("Item: "+(i+1));

        //adapter.notifyDataSetChanged();   //either change list and notify adapter
        return view;
    }
}