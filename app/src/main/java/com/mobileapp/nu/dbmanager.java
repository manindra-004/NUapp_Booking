package com.mobileapp.nu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper
{
    public static final String dbname="dbcontact";

    public dbmanager(@Nullable Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qry="create table tb1_contact ( id integer primary key autoincrement, name text, contact text, email text, date text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        String qry="DROP TABLE IF EXISTS tb1_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public  String addrecord(String name, String contact, String email, String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        cv.put("date",date);
        float res=db.insert("tb1_contact",null,cv);

        if(res==-1)
            return "Failed";
        else
            return  "Successfully inserted";

    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tb1_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }
}

