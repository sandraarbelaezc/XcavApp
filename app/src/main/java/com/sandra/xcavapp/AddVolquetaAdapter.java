package com.sandra.xcavapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sandra.xcavapp.Objetos.Volquetas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandra on 05/06/2017.
 */

public class AddVolquetaAdapter extends RecyclerView.Adapter<AddVolquetaAdapter.AddVolquetaViewHolder> {

    private ArrayList<Volquetas> items;
    Context ctx;

    public static class AddVolquetaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView Placa;
        public TextView Capacidad;
        public TextView Distancia;
        public TextView NViajes;
        public TextView TPagar;
        ArrayList<Volquetas> items = new ArrayList<Volquetas>();
        Context ctx;

        public AddVolquetaViewHolder(View v, Context ctx, ArrayList<Volquetas> items) {
            super(v);
            this.items = items;
            this.ctx = ctx;
            v.setOnClickListener(this);

            Placa = (TextView) v.findViewById(R.id.cardPlaca);
            Capacidad = (TextView) v.findViewById(R.id.cardCap);
            Distancia = (TextView) v.findViewById(R.id.cardDist);
            NViajes = (TextView) v.findViewById(R.id.cardnVi);
            TPagar = (TextView) v.findViewById(R.id.cardTPagar);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Volquetas volquetas = this.items.get(position);
        }
    }

    public AddVolquetaAdapter(ArrayList<Volquetas> items, Context ctx) {

        this.items = items;
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AddVolquetaAdapter.AddVolquetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.add_volquetas_card, viewGroup, false);
        AddVolquetaAdapter.AddVolquetaViewHolder addVolquetaViewHolder = new AddVolquetaAdapter.AddVolquetaViewHolder(v,ctx,items);
        return addVolquetaViewHolder;
    }

    @Override
    public void onBindViewHolder(AddVolquetaAdapter.AddVolquetaViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.Placa.setText(items.get(i).getPlaca());
        viewHolder.Capacidad.setText("Capacidad:"+String.valueOf(items.get(i).getCapacidad()));
        viewHolder.Distancia.setText("Distancia:"+String.valueOf(items.get(i).getDistancia()));
        viewHolder.NViajes.setText("Nº Viajes:"+String.valueOf(items.get(i).getNViajes()));
        viewHolder.TPagar.setText("T Pagar:"+String.valueOf(items.get(i).getTPagar()));
    }
}
