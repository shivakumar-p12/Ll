package com.ll.ll;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                   // File f = new File("/data/data/your_application_package/shared_prefs/user_pref.xml");
                    SharedPreferences sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE);
                    String st=sharedPreferences.getString("name","loggedout");
                   if(st.equals("loggedout"))// (globalVariable.getStatus()==0)
                   {
                       Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
                       startActivity(intent);
                   }
                    else
                   {
                       Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
                       startActivity(intent);
                   }
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
