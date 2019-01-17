package com.orecy.loginregistrationform;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button Registrationbtn,Loginbtn;
EditText Fname,Lname,Phone,Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        openHelper = new DataBaseHelper(this);
        Fname =(EditText) findViewById(R.id.fnametxt);
        Lname =(EditText) findViewById(R.id.lnametxt);
        Phone =(EditText) findViewById(R.id.phonetxt);
        Email=(EditText) findViewById(R.id.emailtxt);
        Password=(EditText)findViewById(R.id.passtxt);
        Registrationbtn=(Button)findViewById(R.id.btnregister);
        Loginbtn =(Button)findViewById(R.id.lgnbtn);

        Registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper .getWritableDatabase();
                String fname =Fname.getText().toString();
                String lname =Lname.getText().toString();
                String phone =Phone.getText().toString();
                String email =Email.getText().toString();
                String password = Password.getText().toString();

                insertdata ( fname, lname, phone, email, password);
                Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_LONG).show();
            }
        });

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplication(), LoginActivity.class);
                startActivity(login);
            }
        });
    }
    public void insertdata (String fname,String lname, String phone,String email,String password){
        ContentValues contentValues= new ContentValues();
        contentValues.put(DataBaseHelper.COL_2, fname);
        contentValues.put(DataBaseHelper.COL_3, lname);
        contentValues.put(DataBaseHelper.COL_4, phone);
        contentValues.put(DataBaseHelper.COL_5, email);
        contentValues.put(DataBaseHelper.COL_6, password);

        long id = db.insert(DataBaseHelper.TABLE_NAME,null,contentValues);
       // db.insert (DataBaseHelper.TABLE_NAME, " null", contentValues);
        db.close();
    }
}
