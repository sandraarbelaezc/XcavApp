package com.sandra.xcavapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sandra.xcavapp.Objetos.HorasMantenimiento;
import com.sandra.xcavapp.Objetos.HorasTrabajadas;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorasR2Fragment extends Fragment {

    EditText eFechaT2, eHInicialT2, eHFinalT2, eFechaM2, eHInicialM2, eHFinalM2;
    Button bVerH, bAddHT2, bAddHM2;

    //************BASE DE DATOS***************
   // public final String TAG_HTRABAJADAS="Horas trabajadas";
    //public final String TAG_HMANTENIMIENTO="Horas de mantenimiento";

    //String Id, Fecha, HInicial, HFinal, THoras, TPagar;

    /*HorasTrabajadas horasTrab2;
    HorasMantenimiento horasMant2;

    FirebaseDatabase database;
    DatabaseReference myRef;*/

    //****************************************

    public HorasR2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horas_r2, container, false);

        bVerH = (Button) view.findViewById(R.id.bVerH);
        bAddHT2 = (Button) view.findViewById(R.id.bAddHT2);
        bAddHM2 = (Button) view.findViewById(R.id.bAddHM2);
        eFechaT2 = (EditText) view.findViewById(R.id.eFechaT2);
        eFechaM2 = (EditText) view.findViewById(R.id.eFechaM2);
        eHInicialT2 = (EditText) view.findViewById(R.id.eHInicialT2);
        eHInicialM2 = (EditText) view.findViewById(R.id.eHInicialM2);
        eHFinalT2 = (EditText) view.findViewById(R.id.eHFinalT2);
        eHFinalM2 = (EditText) view.findViewById(R.id.eHFinalM2);


        //*************BASE DE DATOS*****************************
        //database = FirebaseDatabase.getInstance();
        //***************************************************

        bAddHT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                /*Fecha = eFechaT2.getText().toString();
                HInicial = eHInicialT2.getText().toString();
                HFinal = eHFinalT2.getText().toString();
                Id = "Retro2";
                THoras = "THoras";
                TPagar = "TPago";*/

               // Snackbar.make(v, Fecha, Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();

                //myRef = database.getReference().child(TAG_HTRABAJADAS);
                //horasTrab2 = new HorasTrabajadas(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                //myRef.child(Id).child(Fecha).setValue(horasTrab2);
                //********************************************

            }
        });

        bAddHM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                /*Fecha = eFechaM2.getText().toString();
                HInicial = eHInicialM2.getText().toString();
                HFinal = eHFinalM2.getText().toString();
                Id = "Retro2";
                THoras = "THoras";
                TPagar = "TPago";

                myRef = database.getReference().child(TAG_HMANTENIMIENTO);
                horasMant2 = new HorasMantenimiento(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                myRef.child(Id).child(Fecha).setValue(horasMant2);*/
                //********************************************

            }
        });

        bVerH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*layout.setVisibility(View.GONE);
                Fragment fragment = new HTrabR1Fragment();
                FragmentActivity myContext = (FragmentActivity) getActivity();
                myContext.getSupportFragmentManager().beginTransaction().replace(R.id.horasR1, fragment).commit();*/
                //Intent intent = new Intent(getContext(), HTrabR1Fragment.class);
                //startActivity(intent);
            }
        });

        return view;

    }

}
