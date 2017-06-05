package com.sandra.xcavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RetroActivity extends AppCompatActivity {

    EditText eRetroS;
    Button bAceptar, bCancel;
    TextView tNombreO;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //***********Login con facebook**************
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        //*******************************************
        setContentView(R.layout.activity_retro);

        //*************Login con facebook********* Esto ya no es necesario porq la validación se hace con firebase
        /*if(AccessToken.getCurrentAccessToken() == null){
            goLoginActivity();
        }*/

        eRetroS = (EditText) findViewById(R.id.eRetroS);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        bCancel = (Button) findViewById(R.id.bCancel);
        tNombreO = (TextView) findViewById(R.id.tNombreO);

        //****************Login en firebase*********
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user!=null){
            String name = user.getDisplayName();

            tNombreO.setText(name);
        } else {
            goLoginActivity();
        }
        //*******************************************

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (eRetroS.getText().toString().matches("Retro1")){
                    intent = new Intent(RetroActivity.this, OperaR1Activity.class);
                    startActivity(intent);
                    finish();
                } else
                    if(eRetroS.getText().toString().matches("Retro2")){
                        intent = new Intent(RetroActivity.this, OperaR2Activity.class);
                        startActivity(intent);
                        finish();
                    } else
                        Toast.makeText(RetroActivity.this, "Debe definir si operará la Retro1 o la Retro2", Toast.LENGTH_SHORT).show();
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                FirebaseAuth.getInstance().signOut();
                goLoginActivity();
            }
        });

    }

    private void goLoginActivity() {
        intent = new Intent(RetroActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
