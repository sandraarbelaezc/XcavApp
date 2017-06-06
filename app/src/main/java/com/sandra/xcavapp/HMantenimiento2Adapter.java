package com.sandra.xcavapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sandra.xcavapp.Objetos.HorasMantenimiento;

import java.util.ArrayList;

/**
 * Created by sandra on 05/06/2017.
 */

public class HMantenimiento2Adapter extends RecyclerView.Adapter<HMantenimiento2Adapter.HMantenimiento2ViewHolder>  {

    private ArrayList<HorasMantenimiento> items;
    Context ctx;

    public static class HMantenimiento2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Campos respectivos de un item
        //public ImageView imagen;
        public TextView Fecha;
        public TextView TPagar;
        public TextView THoras;
        ArrayList<HorasMantenimiento> items = new ArrayList<HorasMantenimiento> ();
        Context ctx;

        public HMantenimiento2ViewHolder(View v, Context ctx, ArrayList<HorasMantenimiento> items) {
            super(v);
            this.items = items;
            this.ctx = ctx;
            v.setOnClickListener(this);
            //imagen = (ImageView) v.findViewById(R.id.imagen);
            Fecha = (TextView) v.findViewById(R.id.cardFecha2);
            THoras = (TextView) v.findViewById(R.id.cardTHoras2);
            TPagar = (TextView) v.findViewById(R.id.cardTPagar2);

        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            HorasMantenimiento horasMantenimiento = this.items.get(position);

            //Intent intent = new Intent(this.ctx,MainActivity.class);
            /*intent.putExtra("nombre",horasTrabajadas.getNombre());
            intent.putExtra("cedula",horasTrabajadas.getCedula());
            intent.putExtra("barrio",horasTrabajadas.getBarrio());
            intent.putExtra("bandera","1");*/
            //this.ctx.startActivity(intent);
        }
    }

    public HMantenimiento2Adapter(ArrayList<HorasMantenimiento> items, Context ctx) {

        this.items = items;
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public HMantenimiento2Adapter.HMantenimiento2ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.h_mantenimiento2_card, viewGroup, false);
        HMantenimiento2Adapter.HMantenimiento2ViewHolder hMantenimiento2ViewHolder = new HMantenimiento2Adapter.HMantenimiento2ViewHolder(v,ctx,items);
        return hMantenimiento2ViewHolder;
    }

    @Override
    public void onBindViewHolder(HMantenimiento2Adapter.HMantenimiento2ViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.Fecha.setText(items.get(i).getFecha());
        viewHolder.THoras.setText("Total horas:"+String.valueOf(items.get(i).getTHoras()));
        viewHolder.TPagar.setText("Total pagar:"+String.valueOf(items.get(i).getTPagar()));
    }

}

