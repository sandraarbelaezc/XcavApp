package com.sandra.xcavapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sandra.xcavapp.Objetos.HorasTrabajadas;

import java.util.ArrayList;

/**
 * Creado por Hermosa Programación
 */
public class HTrabajadasAdapter extends RecyclerView.Adapter<HTrabajadasAdapter.HTrabajadasViewHolder> {
    private ArrayList<HorasTrabajadas> items;
    Context ctx;


    public static class HTrabajadasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Campos respectivos de un item
        //public ImageView imagen;
        public TextView Fecha;
        public TextView TPagar;
        public TextView THoras;
        ArrayList<HorasTrabajadas> items = new ArrayList<HorasTrabajadas> ();
        Context ctx;

        public HTrabajadasViewHolder(View v, Context ctx, ArrayList<HorasTrabajadas> items) {
            super(v);
            this.items = items;
            this.ctx = ctx;
            v.setOnClickListener(this);
            //imagen = (ImageView) v.findViewById(R.id.imagen);
            Fecha = (TextView) v.findViewById(R.id.cardFecha);
            THoras = (TextView) v.findViewById(R.id.cardTHoras);
            TPagar = (TextView) v.findViewById(R.id.cardTPagar);

        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            HorasTrabajadas horasTrabajadas = this.items.get(position);

            //Intent intent = new Intent(this.ctx,MainActivity.class);
            /*intent.putExtra("nombre",horasTrabajadas.getNombre());
            intent.putExtra("cedula",horasTrabajadas.getCedula());
            intent.putExtra("barrio",horasTrabajadas.getBarrio());
            intent.putExtra("bandera","1");*/
            //this.ctx.startActivity(intent);
        }
    }

    public HTrabajadasAdapter(ArrayList<HorasTrabajadas> items, Context ctx) {

        this.items = items;
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public HTrabajadasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.h_trabajadas_card, viewGroup, false);
        HTrabajadasViewHolder hTrabajadasViewHolder = new HTrabajadasViewHolder(v,ctx,items);
        return hTrabajadasViewHolder;
    }

    @Override
    public void onBindViewHolder(HTrabajadasViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.Fecha.setText(items.get(i).getFecha());
        viewHolder.THoras.setText("Total horas:"+String.valueOf(items.get(i).getTHoras()));
        viewHolder.TPagar.setText("Total pagar:"+String.valueOf(items.get(i).getTPagar()));
    }
}
