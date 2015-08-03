package com.example.api19;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fahad Khan on 8/1/2015.
 */

public class customAdapter extends BaseAdapter {

    ArrayList<ContactInfo> myList;
    Context myContext;
    customAdapter(Context myContext)
    {
        myList=new ArrayList<ContactInfo>();
        this.myContext= myContext;

        Resources res= myContext.getResources();
        String [] names= res.getStringArray(R.array.contactLisNametData);
        String [] number= res.getStringArray(R.array.contactLisPhonetData);
        int[] images= {R.drawable.ic_launcher};

        for (int i=0; i<3; i++)
            myList.add(new ContactInfo(images[0], names[i], number[i]));
    }

    @Override
    public int getCount()
    {
        return myList.size();
    }
    @Override
    public Object getItem(int index)
    {
        return myList.get(index);
    }
    @Override
    public long getItemId(int pk)
    {
        //important for dbs
        return pk;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) myContext.getSystemService(myContext.LAYOUT_INFLATER_SERVICE);
        View myRow= inflater.inflate(R.layout.customadapter, parent, false);

        ImageView image= (ImageView) myRow.findViewById(R.id.imageView);
        TextView name= (TextView) myRow.findViewById(R.id.textView2);
        TextView number= (TextView) myRow.findViewById(R.id.textView3);

        ContactInfo rowData= myList.get(pos);
        image.setImageResource(rowData.image);
        name.setText(rowData.contactName);
        number.setText(rowData.contactNumber);

        return  myRow;
    }
    public void addContact(int pos, int image, String newName, String number)
    {
        myList.add(new ContactInfo(image,newName,number));
    }
}
