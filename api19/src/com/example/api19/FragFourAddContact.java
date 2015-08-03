package com.example.api19;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Fahad Khan on 8/2/2015.
 */
public class FragFourAddContact extends Fragment {
    EditText name;
    EditText contact;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.f4addcontact, container, false);

        name = (EditText) view.findViewById(R.id.editText2);
        contact= (EditText) view.findViewById(R.id.editText3);
        Button  myButton= (Button) view.findViewById(R.id.button3);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyActivity.phoneBook.add(new ContactInfo(R.drawable.ic_launcher, name.getText().toString(), contact.getText().toString()));
                getActivity().getFragmentManager().beginTransaction().replace(R.id.tab4, new MyFragment4()).commit();
            }
        });

        return view;
    }
}