package com.sandra.xcavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class AddViajeActivity extends AppCompatActivity {

    EditText eNViaje;
    Button bAdd, bCanc;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Pantalla completa
        setContentView(R.layout.activity_add_viaje);

        eNViaje = (EditText) findViewById(R.id.eNViaje);
        bAdd = (Button) findViewById(R.id.bAdd);
        bCanc = (Button) findViewById(R.id.bCanc);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AddViajeActivity.this, VolquetaFragment.class);
                startActivity(intent);
            }
        });

        bCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AddViajeActivity.this, VolquetaFragment.class);
                startActivity(intent);
            }
        });

    }
}
