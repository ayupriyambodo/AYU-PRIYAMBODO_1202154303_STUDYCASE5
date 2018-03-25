package com.example.ayupriyambodo.modul5a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by AYUPRIYAMBODO on 25/03/2018.
 */

public class database extends SQLiteOpenHelper {

    Context ctx;
    SQLiteDatabase db;

    public static final String nama_db = "pengaturan.db";
    public static final String nama_tabel = "daftartodo";
    public static final String kolom_1 = "todo";
    public static final String kolom_2 = "deskripsi";
    public static final String kolom_3 = "priority";

    public database(Context context){
        super(context, nama_db, null, 1);
        this.ctx = context;
        db = this.getWritableDatabase();
        db.execSQL("create table if not exists "+nama_tabel+"(todo varchar(35) primary key, deskripsi varchar(60), priority vaerchar(4))");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists "+nama_tabel+"(todo varchar(35) primary key, deskripsi varchar(60), priority vaerchar(4))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+nama_tabel);
        onCreate(sqLiteDatabase);
    }

    public boolean inputdata(AddData list){
        ContentValues vs1 = new ContentValues();
        vs1.put(kolom_1, list.getTodo());
        vs1.put(kolom_2, list.getDesk());
        vs1.put(kolom_3, list.getPrior());
        long hasil = db.insert(nama_tabel,null, vs1);
        if (hasil==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean removedata(String ToDo){
        return db.delete(nama_tabel,kolom_1+"=\""+ToDo+"\"",null)>0;
    }

    public void reddata(ArrayList<AddData> daftar){
        Cursor cursor = this.getReadableDatabase().rawQuery("select todo, deskripsi, priority from "+nama_tabel,null);
        while (cursor.moveToNext()){
            daftar.add(new AddData(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }
    }
}
