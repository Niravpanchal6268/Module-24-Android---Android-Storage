package com.example.managements;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentsDB_Class extends SQLiteOpenHelper {
    private final static String DBNAME = "data";
    private final static int version = 1;

    public StudentsDB_Class(Context context) {
        super(context, DBNAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "create table student(id integer primary key autoincrement ,FNAME text,LNAME text,EMAIL text,COURSE text,ADDRESS text,PINCODE text,CITY text,TOTALFEE text,MOBILE text)";
        db.execSQL(s);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists student");
        onCreate(db);

    }

    public boolean insertdetail(String Fname, String Lname, String Email, String Course, String Address, String Pincode, String City, String Tfee, String Mobile) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FNAME", Fname);
        values.put("LNAME", Lname);
        values.put("EMAIL", Email);
        values.put("COURSE", Course);
        values.put("ADDRESS", Address);
        values.put("PINCODE", Pincode);
        values.put("CITY", City);
        values.put("TOTALFEE", Tfee);
        values.put("MOBILE", Mobile);
        long i = db.insert("student", null, values);
        if (i == -1) {
            return true;
        } else {
            return false;
        }

    }

    public Cursor showdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,FNAME,LNAME,EMAIL,MOBILE,COURSE from student", null);
        return cursor;

    }

    public boolean deletestudents(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from student where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long d = db.delete("student", "id=?", new String[]{String.valueOf(id)});
            if (d == -1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }


    }

    public boolean update(int id, String Fname, String Lname, String Email, String Mobile) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FNAME", Fname);
        values.put("LNAME", Lname);
        values.put("EMAIL", Email);
        values.put("MOBILE", Mobile);
        Cursor cursor = db.rawQuery("select * from student where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {

        long u=db.update("student",values,"id=?",new String[]{String.valueOf(id)});
        if(u==-1)
        {
            return  false;
            }
        else {
            return true;
        }


        } else {
                return  false;
        }


    }


}




