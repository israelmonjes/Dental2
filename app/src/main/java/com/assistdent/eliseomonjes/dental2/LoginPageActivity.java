package com.assistdent.eliseomonjes.dental2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Button btingresar =  findViewById(R.id.login);
        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String users=((TextInputEditText) findViewById(R.id.username)).getText().toString();
                String pass=((TextInputEditText) findViewById(R.id.password)).getText().toString();
                if (users.equals("eliseo")&& pass.equals("12345678"))
                {
                    startActivity(new Intent(LoginPageActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }






}


