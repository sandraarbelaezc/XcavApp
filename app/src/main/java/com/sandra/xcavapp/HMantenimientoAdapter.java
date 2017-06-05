package com.sandra.xcavapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sandra.xcavapp.Objetos.HorasMantenimiento;
import com.sandra.xcavapp.Objetos.HorasTrabajadas;

import java.util.ArrayList;

/**
 * Created by sandra on 01/06/2017.
 */

public class HMantenimientoAdapter extends RecyclerView.Adapter<HMantenimientoAdapter.HMantenimientoViewHolder>  {

    private ArrayList<HorasMantenimiento> items;
    Context ctx;

    public static class HMantenimientoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // Campos respectivos de un item
        //public ImageView imagen;
        public TextView Fecha;
        public TextView TPagar;
        public TextView THoras;
        ArrayList<HorasMantenimiento> items = new ArrayList<HorasMantenimiento> ();
        Context ctx;

        public HMantenimientoViewHolder(View v, Context ctx, ArrayList<HorasMantenimiento> items) {
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
            HorasMantenimiento horasMantenimiento = this.items.get(position);

            //Intent intent = new Intent(this.ctx,MainActivity.class);
            /*intent.putExtra("nombre",horasTrabajadas.getNombre());
            intent.putExtra("cedula",horasTrabajadas.getCedula());
            intent.putExtra("barrio",horasTrabajadas.getBarrio());
            intent.putExtra("bandera","1");*/
            //this.ctx.startActivity(intent);
        }
    }

    public HMantenimientoAdapter(ArrayList<HorasMantenimiento> items, Context ctx) {

        this.items = items;
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public HMantenimientoAdapter.HMantenimientoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.h_mantenimiento_card, viewGroup, false);
        HMantenimientoAdapter.HMantenimientoViewHolder hMantenimientoViewHolder = new HMantenimientoAdapter.HMantenimientoViewHolder(v,ctx,items);
        return hMantenimientoViewHolder;
    }

    @Override
    public void onBindViewHolder(HMantenimientoAdapter.HMantenimientoViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.Fecha.setText(items.get(i).getFecha());
        viewHolder.THoras.setText("Total horas:"+String.valueOf(items.get(i).getTHoras()));
        viewHolder.TPagar.setText("Total pagar:"+String.valueOf(items.get(i).getTPagar()));
    }

}
