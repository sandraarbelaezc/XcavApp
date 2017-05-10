package com.sandra.xcavapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sandra.xcavapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VolqR2Fragment extends Fragment {

    Intent intent;

    private Lista_EntradaV[] datos = new Lista_EntradaV[] {
            new Lista_EntradaV("GCE486", "1"),
            new Lista_EntradaV("SDC378", "7"),
            new Lista_EntradaV("IJC274", "4"),
            new Lista_EntradaV("VBN401", "2")
    };

    public VolqR2Fragment() {
        // Required empty public constructor
    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volq_r2, container, false);

        list = (ListView) view.findViewById(R.id.lista);

        VolqR2Fragment.Adapter adapter = new VolqR2Fragment.Adapter(getContext(),datos);

        list.setAdapter(adapter);

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

        return view;
    }

    public class Adapter extends ArrayAdapter<Lista_EntradaV> {

        public Adapter(Context context, Lista_EntradaV[] datos) {
            super(context, R.layout.listview_itemvadm, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_itemvadm, null, true);

            TextView tVolq = (TextView) item.findViewById(R.id.tVolq);
            tVolq.setText(datos[position].getVolqP());

            TextView tNumV = (TextView) item.findViewById(R.id.tNumV);
            tNumV.setText(datos[position].getNViajes());


            return item;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
