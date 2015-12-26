package com.ll.ll;

import android.content.ContentValues;
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
    EditText rname,rage,username,password,remail,rphone;
   // Context context=this;
   // UserDbHelper userDbHelper;
    //SQLiteDatabase sqlliteDatabase;
   public String TABLE_name="user";
    private SQLiteDatabase db;

    Button newregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        createDatabase();

         rname = (EditText)findViewById(R.id.rname);
         rage = (EditText)findViewById(R.id.rage);
         username = (EditText)findViewById(R.id.runame);
         password = (EditText)findViewById(R.id.rpwds);
        remail=(EditText)findViewById(R.id.email);
        rphone = (EditText) findViewById(R.id.phone);
         newregister = (Button)findViewById(R.id.registerme);
    }
    protected void createDatabase(){
        db=openOrCreateDatabase("userDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(email VARCHAR ,phone NUMERIC UNIQUE , name VARCHAR, age INTEGER,username VARCHAR, password VARCHAR,id INTEGER PRIMARY KEY NOT NULL);");
       /* String query = "INSERT INTO user (email,phone,name,age,username,password) VALUES('email',9876543210,'name', 123,'uname','pswd',1);";
        db.execSQL(query);*/
        String nothing="nothing";
        int no=0;
       /* String quer = "INSERT INTO user (email,phone,name,age,username,password,id) VALUES ('"+nothing+"','"+nothing+"','"+nothing+"','"+no+"','"+nothing+"','"+nothing+"');";
        db.execSQL(quer);*/
    }
    protected void insertIntoDB(){
        String name= rname.getText().toString().trim();
        int agea = Integer.parseInt(rage.getText().toString().trim());
        String uname= username.getText().toString().trim();
        String pswd=password.getText().toString().trim();
        String email=remail.getText().toString().trim();
        String phone=rphone.getText().toString().trim();
       /* if(name.equals("") || add.equals("")){
            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }*/
        //String query = "UPDATE user SET email= '"+email+"',phone ='"+phone+"', name='" + name + "', age='" + age + "', username='"+uname +"', password='"+pswd+"', id = 1;";
        //String query = "INSERT INTO user (email,phone,name,age,username,password,id) VALUES('"+email+"','"+phone+"','"+name+"', '"+age+"','"+uname+"','"+pswd+"',1);";
        ContentValues contentValues  = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("name",name);
        contentValues.put("age",agea);
        contentValues.put("username",uname);
        contentValues.put("password",pswd);
        contentValues.put("id",1);
        db.insertWithOnConflict(TABLE_name,"id", contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        //db.execSQL(query);
        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }
    public void registerNew (View v){
        if( rname.getText().toString().length() == 0 )
           rname.setError( "Username is required!" );
        if (rage.getText().toString().length() == 0)
            rage.setError( "Password is required!" );
        if( username.getText().toString().length() == 0 )
            username.setError( "Username is required!" );
        if (password.getText().toString().length() == 0)
            password.setError( "Password is required!" );
        if( remail.getText().toString().length() == 0 )
            username.setError( "Username is required!" );
        if (rphone.getText().toString().length() == 0)
            password.setError( "Password is required!" );
        insertIntoDB();
        /*String name= rname.getText().toString();
        int age = Integer.parseInt(rage.getText().toString());
        String uname= username.getText().toString();
        String pswd=password.getText().toString();
        userDbHelper=new UserDbHelper(context);
        userDbHelper.addinnformation(name,age,uname,pswd,sqlliteDatabase);
        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
        userDbHelper.close();*/
        startActivity(new Intent(this, LoginActivity.class));
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        db.close();
        super.onPause();
        finish();
    }
}
