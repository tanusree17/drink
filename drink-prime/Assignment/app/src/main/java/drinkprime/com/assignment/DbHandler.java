package drinkprime.com.assignment;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import 	android.app.AlertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DbHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DrinkPrime.db";

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_Table = "CREATE TABLE IF NOT EXISTS USERS(username VARCHAR,password VARCHAR, email VARCHAR, phone VARCHAR, city VARCHAR)";
        db.execSQL(SQL_CREATE_Table);

        String SQL_INSERT_Table = "insert into USERS values('admin', 'admin', 'admin@admin.com', '1234567890', 'Bangalore');";
        db.execSQL(SQL_INSERT_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //  db.execSQL(SQL_DELETE_ENTRIES);
        //  onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  onUpgrade(db, oldVersion, newVersion);
    }

    public void register(String name, String email, String phone, String city) {
         SQLiteDatabase db = this.getWritableDatabase();
         String SQL_INSERT_Data = "insert into USERS values('" + name + "', 'test1234','"  + email + "','" + phone + "','" +
                 city + "');";
         db.execSQL(SQL_INSERT_Data);
    }

    public boolean login(Context context, String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultSet = db.rawQuery("Select * from USERS where phone = " + phone + ";",null);
        String phone_number = "";
        final Context that = context;
        boolean result = false;
        if(resultSet != null) {
            resultSet.moveToFirst();
            if(resultSet.getCount() > 0) {
                phone_number = resultSet.getString(0);
                result = true;
            } else {
                result = false;
            }
            resultSet.close();
        }
        return result;
    }
}