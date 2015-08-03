package com.example.api19;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Fahad Khan on 7/31/2015.
 */
public class MyFragment4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

        ListView myList = (ListView) view.findViewById(R.id.tab4List);
        LocalAdapter adapterView = new LocalAdapter(this, MyActivity.phoneBook);
        myList.setAdapter(adapterView);

        /*
        adapterView.add(new ContactInfo(R.drawable.ic_launcher, "Fahad", "264"));
        adapterView.add(new ContactInfo(R.drawable.ic_launcher, "Umer", "266"));
        adapterView.add(new ContactInfo(R.drawable.ic_launcher, "Wahab", "278"));*/

        Button myButton= (Button) view.findViewById(R.id.button2);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().replace(R.id.tab4, new FragFourAddContact()).commit();
            }
        });

        return view;
    }
}

class LocalAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactInfo> listData;
    Fragment myfrag;

    LocalAdapter(Fragment myfrag, ArrayList<ContactInfo> listData) {
        this.context = myfrag.getActivity();
        this.listData = listData;
        this.myfrag= myfrag;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View myRow = inflater.inflate(R.layout.tab4list, parent, false);
        ContactInfo rowData = listData.get(position);

        ImageView image = (ImageView) myRow.findViewById(R.id.imageView);
        image.setImageResource(rowData.image);

        TextView name = (TextView) myRow.findViewById(R.id.textView2);
        name.setText(rowData.contactName);

        TextView number = (TextView) myRow.findViewById(R.id.textView3);
        number.setText(rowData.contactNumber);

        myRow.setOnClickListener(new PassableOnClickListener(myfrag,position));

        return myRow;
    }

    public void add(ContactInfo obj)
    {
        listData.add(obj);
        notifyDataSetChanged();
    }
}

class PassableOnClickListener implements View.OnClickListener
{
    Fragment myFrag;
    int number;

    public PassableOnClickListener(Fragment myFrag, int lastSelected)
    {
        this.myFrag = myFrag;
        this.number= lastSelected;
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("listNumber", Integer.toString(number));
        ProfileFragment fragobj = new ProfileFragment();
        fragobj.setArguments(bundle);

        myFrag.getActivity().getFragmentManager().beginTransaction().replace(R.id.tab4, fragobj).commit();
    }
};