package com.sandra.xcavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sandra.xcavapp.Objetos.Administradores;
import com.sandra.xcavapp.Objetos.Operadores;


public class RegistroActivity extends AppCompatActivity {

    EditText eRUsername, eRContrasena, eRRepContrasena, eRCorreo, eRetro;
    Button bRegistrar, bCancelar;
    Intent intent;


    //******************BASE DE DATOS**************************
    public final String TAG_OPERADORES="Operadores";

    String Usuario, Contraseña, Correo, Id;
    int idC=0;

    FirebaseDatabase database;
    DatabaseReference myRef;

    Operadores operadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // Se esconde el titulo
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Pantalla completa

        setContentView(R.layout.activity_registro);

        eRUsername = (EditText) findViewById(R.id.eRUsername);
        eRContrasena = (EditText) findViewById(R.id.eRContrasena);
        eRRepContrasena =(EditText) findViewById(R.id.eRRepContrasena);
        eRCorreo = (EditText) findViewById(R.id.eRCorreo);
        eRetro = (EditText) findViewById(R.id.eRetro);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);
        bCancelar = (Button) findViewById(R.id.bCancelar);


        database = FirebaseDatabase.getInstance();

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //***********BASE DE DATOS*********************

                Usuario = eRUsername.getText().toString();
                Contraseña = eRContrasena.getText().toString();
                Correo = eRCorreo.getText().toString();
                Id= eRetro.getText().toString();

                myRef = database.getReference().child(TAG_OPERADORES);
                operadores = new Operadores(Id, Usuario, Contraseña, Correo);

                myRef.child(Id).setValue(operadores);

                //*********************************************

                intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
