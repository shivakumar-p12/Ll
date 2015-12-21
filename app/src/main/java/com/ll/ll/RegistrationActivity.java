package com.ll.ll;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText rname,rage,username,password;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqlliteDatabase;
    Button newregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
         rname = (EditText)findViewById(R.id.rname);
         rage = (EditText)findViewById(R.id.rage);
         username = (EditText)findViewById(R.id.runame);
         password = (EditText)findViewById(R.id.rpwds);
         newregister = (Button)findViewById(R.id.registerme);
    }
    public void registerNew (View v){
        String name= rname.getText().toString();
        int age = Integer.parseInt(rage.getText().toString());
        String uname= username.getText().toString();
        String pswd=password.getText().toString();
        userDbHelper=new UserDbHelper(context);
        sqlliteDatabase=userDbHelper.getWritableDatabase();
        userDbHelper.addinnformation(name,age,uname,pswd,sqlliteDatabase);
        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
        userDbHelper.close();
        //startActivity(new Intent(this, HomeActivity.class));
    }
}
