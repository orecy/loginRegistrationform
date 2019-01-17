package com.orecy.loginregistrationform;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button Loginbtn,Registerbtn;
    EditText Email,Password;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();
        //object for dbhelper
        openHelper= new DataBaseHelper(this);
        db = openHelper.getReadableDatabase();
        //buttons
        Loginbtn=(Button)findViewById(R.id.lgnbtn);
        Registerbtn =(Button)findViewById(R.id.regbtn);
        // mail and passeword
        Email =(EditText)findViewById(R.id.emailtxt);
        Password =(EditText)findViewById(R.id.passtxt);

        //what happens when loginbtn clicked
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password= Password.getText().toString();
                cursor =db.rawQuery("SELECT * FROM Registration WHERE EMAIL= ? AND DatabaseHelper.COL_6=?",new String[]{email,password});
                // /cursor =db.rawQuery(String.format("SELECT * FROM %s WHERE%s =? AND %s =?", DataBaseHelper.TABLE_NAME, DataBaseHelper.COL_5, DataBaseHelper.COL_6),new String[]{
                    //    email,password
              // });
                if (cursor!=null){
                    if (cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"logined successfully" , Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"please enter the correct mail or password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //when registerbtn clicked
        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(register);
            }
        });
    }
}
