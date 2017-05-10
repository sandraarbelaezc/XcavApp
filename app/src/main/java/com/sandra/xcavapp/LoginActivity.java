package com.sandra.xcavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, eContrasena;
    Button bIniciar;
    TextView tRegistrese;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // Se esconde el titulo
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Pantalla completa
        setContentView(R.layout.activity_login);

        eUsername = (EditText) findViewById(R.id.eUsername);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bIniciar = (Button) findViewById(R.id.bInciar);
        tRegistrese = (TextView) findViewById(R.id.tRegistrese);

        tRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegistroActivity.class); //De Login a Registro
                startActivity(intent);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(eUsername.getText().toString().matches("Admin")){
                    intent = new Intent(LoginActivity.this, AdminR1Activity.class); //De Login a Registro
                    startActivity(intent);
                    finish();
                } else
                    if(eUsername.getText().toString().matches("Oper1")){
                        intent = new Intent(LoginActivity.this, OperaR1Activity.class); //De Login a Registro
                        startActivity(intent);
                        finish();
                    } else
                        if(eUsername.getText().toString().matches("Oper2")){
                            intent = new Intent(LoginActivity.this, OperaR2Activity.class); //De Login a Registro
                            startActivity(intent);
                            finish();
                        } else{
                            Toast.makeText(LoginActivity.this, "Debe ingresar un usuario válido", Toast.LENGTH_SHORT).show();
                        }


            }
        });
    }
}
