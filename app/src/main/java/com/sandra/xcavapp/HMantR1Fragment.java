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


/**
 * A simple {@link Fragment} subclass.
 */
public class HMantR1Fragment extends Fragment {

    Intent intent;

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada("20/04/2017", "6 Hr", "$60.000"),
            new Lista_Entrada("20/04/2017", "2 Hr", "$20.000"),
            new Lista_Entrada("20/04/2017", "4 Hr", "$40.000"),
            new Lista_Entrada("20/04/2017", "5 Hr", "$50.000")
    };


    public HMantR1Fragment() {
        // Required empty public constructor
    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hmant_r1, container, false);

        list = (ListView) view.findViewById(R.id.lista);

        HMantR1Fragment.Adapter adapter = new HMantR1Fragment.Adapter(getContext(),datos);

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

    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listview_itemman, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_itemman, null, true);

            TextView Fech = (TextView) item.findViewById(R.id.tFec);
            Fech.setText(datos[position].getFech());

            TextView THoras = (TextView) item.findViewById(R.id.tTHor);
            THoras.setText(datos[position].getTHoras());

            TextView TPago = (TextView) item.findViewById(R.id.tTPag);
            TPago.setText(datos[position].getTPago());

            return item;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
