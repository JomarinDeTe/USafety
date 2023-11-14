package com.example.usafety;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Home extends Fragment  {
    Button start;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        start = root.findViewById(R.id.btnHomeStart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Action fragment = new Action();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.container, fragment).commit();
            }
        });






        return root;
    }



}