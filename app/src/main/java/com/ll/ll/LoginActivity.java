package com.ll.ll;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity  {
    TextView regt;
    Button logmein;
    EditText uname,pword;
    private SQLiteDatabase db;
    private Cursor c;
    //username,password
    public static final String SELECT_SQL = "SELECT username,password FROM user WHERE id = 1;";
    //private  String SELECT_SQL = "SELECT username,password FROM user  WHERE username=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openDatabase();
        regt = (TextView) findViewById(R.id.reg);
        logmein = (Button)findViewById(R.id.signin);
        uname=(EditText)findViewById(R.id.uname);
        pword = (EditText)findViewById(R.id.passwd);
        //regt.setOnClickListener(this);

        //String b="SELECT username,password FROM user WHERE username='"+a+"'" ;


    }
  /*  public boolean authenticate()
    {
        if (c.getString(5)==uname.getText().toString() && c.getString(6)==pword.getText().toString())
            return true;
        else
            return false;
    }*/

    public void SignIn (View v){
        try {
           /* String u="user";
            String a=uname.getText().toString().trim();
            //new String[]{a}
            *//*c = db.query("SELECT username,password FROM user WHERE username='"+a+'");
            c.moveToFirst();*//*
            String [] sele = {"username","password"};*/
          //Cursor c= db.query(u,sele,null,null,null,null,null,null);
            c = db.rawQuery(SELECT_SQL, null);
            c.moveToFirst();
            if (uname.getText().toString().length() == 0) {
                uname.setError("Username is required!");
                return;
            }
                if (pword.getText().toString().length() == 0) {
                    pword.setError("Password is required!");
                    return;
                }
           // boolean stat = authenticate();
          /*  String u = c.getString(c.getColumnIndex("username"));
            String p = c.getString(c.getColumnIndex("password"));*/
           // uname.getText().toString()pword.getText().toString()
            if (c.getString(0).toString().equals(uname.getText().toString()) && c.getString(1).toString().equals(pword.getText().toString()))
            {
               /* GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                globalVariable.setStatus(1);*/
                GlobalClass.logOut=1;
                SharedPreferences sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",uname.getText().toString());
                editor.commit();
                startActivity(new Intent(this, HomeActivity.class));

            } else {
                Toast.makeText(this, "Login failed.. Please try again..!!", Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e)
        {
            Log.e("Login operation", "Exception found");
        }
       /* finally {
            startActivity(new Intent(this, LoginActivity.class));
        }*/
    }
    public void loginReg (View v){

        startActivity(new Intent(this, RegistrationActivity.class));
    }
    protected void openDatabase() {
        db = openOrCreateDatabase("userDB", Context.MODE_PRIVATE, null);
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        db.close();
        super.onPause();
       finish();
    }
}