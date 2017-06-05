package com.sandra.xcavapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.sandra.xcavapp.Objetos.HorasMantenimiento;
import com.sandra.xcavapp.Objetos.HorasTrabajadas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HMantR1Fragment extends Fragment {

    Intent intent;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    public static ArrayList<HorasMantenimiento> items;


    public HMantR1Fragment() {
        // Required empty public constructor
    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hmant_r1, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        items = new ArrayList<HorasMantenimiento>();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.atras);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OperaR1Activity.class);
                startActivity(intent);
            }
        });

        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });*/

        database.getReference("Horas de mantenimiento").child("Retro1").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {

                    HorasMantenimiento parqueadero = dataSnapshot.getValue(HorasMantenimiento.class);
                    items.add(parqueadero);
                    //adapter.notifyDataSetChanged();
                    adapter.notifyItemInserted(items.size() - 1);

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                HorasMantenimiento parqueadero = dataSnapshot.getValue(HorasMantenimiento.class);
                for (HorasMantenimiento cl:items
                        ) {if(cl.getId().equals(key)){
                    cl.setFecha(parqueadero.getFecha());
                    cl.setTHoras(parqueadero.getTHoras());
                    cl.setTPagar(parqueadero.getTPagar());
                    break;

                }

                }

                adapter.notifyDataSetChanged();
                /*
                items.add(parqueadero);
                adapter.notifyItemInserted(items.size() - 1);
                //adapter.notifyItemChanged(Integer.parseInt(parqueadero.getCedula()));
                adapter.notifyDataSetChanged();*/

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {



            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recycler = (RecyclerView) view.findViewById(R.id.recicladorHTrabajadas);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);


        // Crear un nuevo adaptador

        adapter = new HMantenimientoAdapter(items,this.getContext());
        recycler.setAdapter(adapter);



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragmentmostrar, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
