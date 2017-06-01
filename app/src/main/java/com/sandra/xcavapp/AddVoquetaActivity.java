package com.sandra.xcavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sandra.xcavapp.Objetos.Volquetas;

public class AddVoquetaActivity extends AppCompatActivity {

    EditText ePlaca, eCap;
    Button bAdd, bCanc;

    //************BASE DE DATOS***************
    public final String TAG_VOLQUETAS="Volquetas";

    String Placa, Capacidad, Distancia, NViajes, TPagar;

    Volquetas volquetas;

    FirebaseDatabase database;
    DatabaseReference myRef;
    //****************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Pantalla completa
        setContentView(R.layout.activity_add_voqueta);

        ePlaca = (EditText) findViewById(R.id.ePlaca);
        eCap = (EditText) findViewById(R.id.eCap);
        bAdd = (Button) findViewById(R.id.bAdd);
        bCanc = (Button) findViewById(R.id.bCanc);

        //*************BASE DE DATOS*****************************
        database = FirebaseDatabase.getInstance();
        //***************************************************

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //**********BASE DE DATOS********************
                Placa = ePlaca.getText().toString();
                Capacidad = eCap.getText().toString();
                Distancia = "12 Km";
                NViajes = "3 viajes";
                TPagar = "Pago";

                myRef = database.getReference().child(TAG_VOLQUETAS);
                volquetas = new Volquetas(Placa, Capacidad, Distancia, NViajes, TPagar);

                myRef.child(Placa).setValue(volquetas);
                //********************************************

            }
        });

        bCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddVoquetaActivity.this, VolquetaFragment.class);
                startActivity(intent);
            }
        });

    }
}
