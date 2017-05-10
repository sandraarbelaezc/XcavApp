package com.sandra.xcavapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorasR2Fragment extends Fragment {

    Button bVerH2;

    public HorasR2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horas_r2, container, false);

        bVerH2 = (Button) view.findViewById(R.id.bVerH2);

       /* bVerH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HTrabR2Fragment.class);
                startActivity(intent);
            }
        });*/

        return view;

    }



}
