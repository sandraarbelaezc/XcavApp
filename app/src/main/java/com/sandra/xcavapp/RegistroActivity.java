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

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsername, eRContrasena, eRRepContrasena, eRCorreo;
    Button bRegistrar, bRegAdm, bRegOpe, bCancelar;
    RadioGroup rgroup;
    RadioButton rbAdmin, rbOpera;
    CheckBox cbR1, cbR2;
    Intent intent;

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
        //bRegistrar = (Button) findViewById(R.id.bRegistrar);
        bRegAdm = (Button) findViewById(R.id.bRegAdm);
        bRegOpe = (Button) findViewById(R.id.bRegOpe);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        //rgroup = (RadioGroup) findViewById(R.id.rgroup);
        //rbAdmin = (RadioButton) findViewById(R.id.rbAdmin);
        //rbOpera = (RadioButton) findViewById(R.id.rbOpera);
        cbR1 = (CheckBox) findViewById(R.id.cbR1);
        cbR2 = (CheckBox) findViewById(R.id.cbR2);

        bRegAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bRegOpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
