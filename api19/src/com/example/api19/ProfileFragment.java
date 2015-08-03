package com.example.api19;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fahad Khan on 8/2/2015.
 */
public class ProfileFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.profile, container, false);

        String strtext = getArguments().getString("listNumber");

        TextView name= (TextView) view.findViewById(R.id.textView6);
        TextView number= (TextView) view.findViewById(R.id.textView7);
        ImageView image= (ImageView) view.findViewById(R.id.imageView2);

        ContactInfo myContact= MyActivity.phoneBook.get(Integer.parseInt(strtext));
        name.setText(myContact.contactName);
        number.setText(myContact.contactNumber);
        image.setImageResource(myContact.image);

        Button myButton= (Button) view.findViewById(R.id.button5);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().replace(R.id.tab4, new MyFragment4()).commit();
            }
        });

        Button delButton= (Button) view.findViewById(R.id.button4);
        delButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyActivity.phoneBook.remove(Integer.parseInt(strtext));
                getActivity().getFragmentManager().beginTransaction().replace(R.id.tab4, new MyFragment4()).commit();
            }
        });

        return view;
    }
}
