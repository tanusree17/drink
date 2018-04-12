package drinkprime.com.assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.view.View.OnClickListener;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import android.util.Log;

public class LoginActivity extends AppCompatActivity {
    Button button;
    EditText phone;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.button2);
        phone   = (EditText) findViewById(R.id.editText6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class

                boolean result = false;

                try {
                    DbHandler mDbHelper = new DbHandler(LoginActivity.this);
                    result = mDbHelper.login(LoginActivity.this, phone.getText().toString());

                    if(!result) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
                        alertDialogBuilder.setTitle("Login Failed");

                        alertDialogBuilder
                                .setMessage("Please enter the correct mobile number!")
                                .setCancelable(false)
                                .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();
                    } else {
                        Intent myIntent = new Intent(LoginActivity.this, CheckOTPActivity.class);
                        startActivity(myIntent);
                    }
                }  catch (Exception e) {
                    Log.d("TAG", "exception: " + e);
                }


            }
        });
    }
}
