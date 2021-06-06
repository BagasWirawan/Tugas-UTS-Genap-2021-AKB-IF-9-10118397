package com.example.a10118397_v4;
/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String NAMA_DATABASE  = "mahasiswa.db";
    private static final String NAMA_TABEL  = "catatan";
    private static final String COL_1  = "ID";
    private static final String COL_2  = "JUDUL";
    private static final String COL_3  = "KATEGORI";
    private static final String COL_4  = "ISI";

    public SQLiteHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAMA_TABEL + " (" +
                COL_1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_2+ " TEXT, " +
                COL_3+ " TEXT, " +
                COL_4+ " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL);

    }

    public boolean insertData(String judul, String kategori, String isi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,judul);
        values.put(COL_3,kategori);
        values.put(COL_4,isi);
        long result = db.insert(NAMA_TABEL, null, values);
        return result != -1;
    }

    public Cursor getDataAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + NAMA_TABEL, null);
    }

    public boolean updateData(String id, String judul, String kategori, String isi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1,id);
        values.put(COL_2,judul);
        values.put(COL_3,kategori);
        values.put(COL_4,isi);

        db.update(NAMA_TABEL, values, COL_1+" = ? ", new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(NAMA_TABEL, COL_1+ " = ? ", new String[]{id});
    }
}
