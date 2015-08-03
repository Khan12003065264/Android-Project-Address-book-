package com.example.api19;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Fahad Khan on 7/28/2015.
 */
public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View myView= inflater.inflate(R.layout.fragment1, container,false);

       // EditText editText= (EditText) myView.findViewById(R.id.editText);
        //editText.clearFocus();

        /*
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (hasFocus)
                {
                    //open keyboard
                    ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(v,
                            InputMethodManager.SHOW_FORCED);
                }
                else
                {
                    //close keyboard
                    ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            v.getWindowToken(), 0);
                }
            }
        });

        //Set on click listener to clear focus
        editText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View clickedView)
            {
                clickedView.clearFocus();
                clickedView.requestFocus();
            }
        });
        */
        return myView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //EditText editText= (EditText) getActivity().findViewById(R.id.editText);
        //editText.requestFocus();
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        EditText someEditText = (EditText)getActivity().findViewById(R.id.keyPad);
        someEditText.requestFocus();
        InputMethodManager mgr =      (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(someEditText, InputMethodManager.SHOW_IMPLICIT);
    }
    */
}