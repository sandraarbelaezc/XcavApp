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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VolquetaFragment extends Fragment {

    Intent intent;
    Button bAddV;

    private Lista_EntradaV[] datos = new Lista_EntradaV[] {
            new Lista_EntradaV("RDT456", "6 "),
            new Lista_EntradaV("SEV378", "2"),
            new Lista_EntradaV("LGC274", "4"),
            new Lista_EntradaV("GCR541", "5")
    };

    public VolquetaFragment() {
        // Required empty public constructor
    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volqueta, container, false);

        list = (ListView) view.findViewById(R.id.lista);
        bAddV = (Button) view.findViewById(R.id.bAddV);

        VolquetaFragment.Adapter adapter = new VolquetaFragment.Adapter(getContext(),datos);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(getContext(), AddViajeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        bAddV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), AddVoquetaActivity.class); //De Login a Registro
                startActivity(intent);
            }
        });

        return view;
    }

    public class Adapter extends ArrayAdapter<Lista_EntradaV> {

        public Adapter(Context context, Lista_EntradaV[] datos) {
            super(context, R.layout.listview_itemvol, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_itemvol, null, true);

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
