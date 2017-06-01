package com.sandra.xcavapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.vision.text.Line;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sandra.xcavapp.Objetos.HorasMantenimiento;
import com.sandra.xcavapp.Objetos.HorasTrabajadas;
import com.sandra.xcavapp.Objetos.Operadores;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorasFragment extends Fragment {

    EditText eFechaT1, eHInicialT1, eHFinalT1, eFechaM1, eHInicialM1, eHFinalM1;
    Button bVerH, bAddHT1, bAddHM1;
    LinearLayout layout;

    //************BASE DE DATOS***************
    public final String TAG_HTRABAJADAS="Horas trabajadas";
    public final String TAG_HMANTENIMIENTO="Horas de mantenimiento";

    String Id, Fecha, HInicial, HFinal, THoras, TPagar;

    HorasTrabajadas horasTrab;
    HorasMantenimiento horasMant;

    FirebaseDatabase database;
    DatabaseReference myRef;

    //****************************************

    public HorasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horas, container, false);

        bVerH = (Button) view.findViewById(R.id.bVerH);
        bAddHT1 = (Button) view.findViewById(R.id.bAddHT1);
        bAddHM1 = (Button) view.findViewById(R.id.bAddHM1);
        eFechaT1 = (EditText) view.findViewById(R.id.eFechaT1);
        eFechaM1 = (EditText) view.findViewById(R.id.eFechaM1);
        eHInicialT1 = (EditText) view.findViewById(R.id.eHInicialT1);
        eHInicialM1 = (EditText) view.findViewById(R.id.eHInicialM1);
        eHFinalT1 = (EditText) view.findViewById(R.id.eHFinalT1);
        eHFinalM1 = (EditText) view.findViewById(R.id.eHFinalM1);
        layout = (LinearLayout) view.findViewById(R.id.layout);


        //*************BASE DE DATOS*****************************
        database = FirebaseDatabase.getInstance();
        //***************************************************

        bAddHT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                Fecha = eFechaT1.getText().toString();
                HInicial = eHInicialT1.getText().toString();
                HFinal = eHFinalT1.getText().toString();
                Id = "Hitachi";
                THoras = "Horas";
                TPagar = "Pago";

                myRef = database.getReference().child(TAG_HTRABAJADAS);
                horasTrab = new HorasTrabajadas(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                myRef.child(Id).setValue(horasTrab);
                //********************************************

            }
        });

        bAddHM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                Fecha = eFechaM1.getText().toString();
                HInicial = eHInicialM1.getText().toString();
                HFinal = eHFinalM1.getText().toString();
                Id = "Hitachi";
                THoras = "Horas";
                TPagar = "Pago";

                myRef = database.getReference().child(TAG_HMANTENIMIENTO);
                horasMant = new HorasMantenimiento(Id, Fecha, HInicial, HFinal, THoras, TPagar);

                myRef.child(Id).setValue(horasMant);
                //********************************************

            }
        });

        bVerH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout.setVisibility(View.GONE);
                Fragment fragment = new HTrabR1Fragment();
                FragmentActivity myContext = (FragmentActivity) getActivity();
                myContext.getSupportFragmentManager().beginTransaction().replace(R.id.horasR1, fragment).commit();
                //Intent intent = new Intent(getContext(), HTrabR1Fragment.class);
                //startActivity(intent);
            }
        });

        return view;
    }



}
