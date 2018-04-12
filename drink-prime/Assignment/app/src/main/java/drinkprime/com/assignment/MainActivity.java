package drinkprime.com.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import android.util.Log;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    TextView login;
    EditText name;
    EditText email;
    EditText phone;
    EditText city;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (TextView) findViewById(R.id.textView3);
        register = (Button) findViewById(R.id.button);
        name   = (EditText) findViewById(R.id.editText);
        email   = (EditText) findViewById(R.id.editText3);
        phone   = (EditText) findViewById(R.id.editText4);
        city   = (EditText) findViewById(R.id.editText5);

        register.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class

                try {
                    DbHandler mDbHelper = new DbHandler(MainActivity.this);
                    mDbHelper.register(name.getText().toString(), email.getText().toString(), phone.getText().toString(), city.getText().toString());
                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                } catch (Exception e) {
                    Log.d("TAG", "exceptionn: " + e);
                }

            }
        });

        login.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class

                try {
                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                } catch (Exception e) {
                    Log.d("TAG", "exception: " + e);
                }

            }
        });


    }


}
