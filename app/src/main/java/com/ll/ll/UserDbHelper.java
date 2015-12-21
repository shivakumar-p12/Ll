package com.ll.ll;

/**
 * Created by rdm-09 on 19-Dec-15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MUhammad zubair on 6/22/2015.
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="userinfo1.db";
    private static final int DATABASE_VERSION=5;
    private static final String ID="id";
    private static final String CREATE_QUERY="CREATE TABLE "+ User.NewUserInfo.TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ User.NewUserInfo.NAME+" TEXT, "+User.NewUserInfo.AGE+" INTEGER,"+ User.NewUserInfo.USER_NAME+" TEXT, "+User.NewUserInfo.USER_PSWD+" TEXT );";


    public UserDbHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATION", "Database created / opened.....");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "Table create..."+CREATE_QUERY);
    }
    public void addinnformation(String name,int age,String uname,String pswd,SQLiteDatabase db){

        ContentValues contentValue = new ContentValues();

        contentValue.put(ID,1);
        contentValue.put(User.NewUserInfo.NAME,name);
        contentValue.put(User.NewUserInfo.AGE,age);
        contentValue.put(User.NewUserInfo.USER_NAME,uname);
        contentValue.put(User.NewUserInfo.USER_PSWD,pswd);
        db.insert(User.NewUserInfo.TABLE_NAME,null,contentValue);
        Log.e("DATABASE OPERATION", "One row is insert");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}