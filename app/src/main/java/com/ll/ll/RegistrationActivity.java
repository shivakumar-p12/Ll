package com.ll.ll;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,age,username,password;
    Button newregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText name = (EditText)findViewById(R.id.rname);
        EditText age = (EditText)findViewById(R.id.rage);
        EditText username = (EditText)findViewById(R.id.runame);
        EditText password = (EditText)findViewById(R.id.rpwds);
        Button newregister = (Button)findViewById(R.id.registerme);
    }
    public void registerNew (View v){
        startActivity(new Intent(this, HomeActivity.class));
    }
}
