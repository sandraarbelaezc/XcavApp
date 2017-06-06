package com.sandra.xcavapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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


public class Horas2Fragment extends Fragment {

    EditText eFechaT2, eHInicialT2, eHFinalT2, eFechaM2, eHInicialM2, eHFinalM2;
    Button bVerH2, bAddHT2, bAddHM2;
    LinearLayout layout2;
    int con=0;

    //************BASE DE DATOS***************
    public final String TAG_HTRABAJADAS="Horas trabajadas";
    public final String TAG_HMANTENIMIENTO="Horas de mantenimiento";

    String Id, Fecha, HInicial, HFinal, THoras, TPagar;

    HorasTrabajadas horasTrab;
    HorasMantenimiento horasMant;

    FirebaseDatabase database;
    DatabaseReference myRef;

    //****************************************

    public Horas2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horas2, container, false);

        bVerH2 = (Button) view.findViewById(R.id.bVerH2);
        bAddHT2 = (Button) view.findViewById(R.id.bAddHT2);
        bAddHM2 = (Button) view.findViewById(R.id.bAddHM2);
        eFechaT2 = (EditText) view.findViewById(R.id.eFechaT2);
        eFechaM2 = (EditText) view.findViewById(R.id.eFechaM2);
        eHInicialT2 = (EditText) view.findViewById(R.id.eHInicialT2);
        eHInicialM2 = (EditText) view.findViewById(R.id.eHInicialM2);
        eHFinalT2 = (EditText) view.findViewById(R.id.eHFinalT2);
        eHFinalM2 = (EditText) view.findViewById(R.id.eHFinalM2);
        layout2 = (LinearLayout) view.findViewById(R.id.layout2);


        //*************BASE DE DATOS*****************************
        database = FirebaseDatabase.getInstance();
        //***************************************************

        bAddHT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                Fecha = eFechaT2.getText().toString();
                HInicial = eHInicialT2.getText().toString();
                HFinal = eHFinalT2.getText().toString();
                Id = "Retro2";
                THoras = "THoras";
                TPagar = "TPago";



                myRef = database.getReference().child(TAG_HTRABAJADAS);
                horasTrab = new HorasTrabajadas(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                myRef.child(Id).child(Fecha).setValue(horasTrab);
                //********************************************

            }
        });

        bAddHM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                Fecha = eFechaM2.getText().toString();
                HInicial = eHInicialM2.getText().toString();
                HFinal = eHFinalM2.getText().toString();
                Id = "Retro2";
                THoras = "THoras";
                TPagar = "TPago";

                myRef = database.getReference().child(TAG_HMANTENIMIENTO);
                horasMant = new HorasMantenimiento(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                myRef.child(Id).child(Fecha).setValue(horasMant);
                //********************************************

            }
        });

        bVerH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout2.setVisibility(View.GONE);
                Fragment fragment = new HTrabR2Fragment();
                FragmentActivity myContext = (FragmentActivity) getActivity();
                myContext.getSupportFragmentManager().beginTransaction().replace(R.id.horasR2, fragment).commit();
                //Intent intent = new Intent(getContext(), HTrabR1Fragment.class);
                //startActivity(intent);
            }
        });

        return view;
    }

}