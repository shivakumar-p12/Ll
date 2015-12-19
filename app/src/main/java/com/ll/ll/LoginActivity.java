package com.ll.ll;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity  {
    TextView regt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        regt = (TextView) findViewById(R.id.reg);
        //regt.setOnClickListener(this);
    }
    public void loginReg (View v){
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}