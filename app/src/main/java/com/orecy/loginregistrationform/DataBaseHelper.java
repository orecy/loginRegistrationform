package com.orecy.loginregistrationform;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

/**
 * Created by ORECY on 12/16/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME =" emplomanage.db ";
    public static final String TABLE_NAME =" Registration";
    public static final String COL_1 =" ID";
    public static final String COL_2 =" FIRSTNAME";
    public static final String COL_3 =" LASTNAME";
    public static final String COL_4 =" PHONE";
    public static final String COL_5 =" EMAIL";
    public static final String COL_6 =" PASSWORD";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public  String DROP_TABLE_REGISTRATION= " DROP TABLE IF EXISTS " + TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME  TEXT, COL_3 TEXT,COL_4 TEXT,COL_5 TEXT,COL_6 TEXT); ");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if(newVersion>oldVersion)
           // copyDatabase();
    db.execSQL( DROP_TABLE_REGISTRATION );
       onCreate(db);
    }
}
