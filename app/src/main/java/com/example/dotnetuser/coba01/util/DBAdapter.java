package com.example.dotnetuser.coba01.util;

import com.example.dotnetuser.coba01.entity.quiz;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by dotnetuser on 6/13/2016.
 */
public class DBAdapter extends SQLiteAssetHelper {

    private static final String DB_NAME = "db_quiz";
    private static final int DB_VER = 1;
    private static final String TABLE_SOAL = "tb_soal";
    private static final String COL_SOAL_ID = "_id";
    private static final String COL_SOAL_SOAL = "soal";
    private static final String COL_SOAL_JAWABAN_A = "jawaban_a";
    private static final String COL_SOAL_JAWABAN_B = "jawaban_b";
    private static final String COL_SOAL_JAWABAN_C = "jawaban_c";
    private static final String COL_SOAL_JAWABAN_BENAR = "jawaban_benar";

    private static DBAdapter dbInstance = null;
    private static SQLiteDatabase db;

    private DBAdapter(Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    public static DBAdapter getDbInstance(Context context)
    {
        if (dbInstance==null)
        {
            dbInstance = new DBAdapter(context);
            db = dbInstance.getWritableDatabase();
        }
        return dbInstance;
    }

    @Override
    public synchronized void close()
    {
        super.close();
        if (dbInstance !=null)
        {
            dbInstance.close();
        }
    }

    public List<quiz> getAllSoal()
    {
        List<quiz> listSoal = new ArrayList<quiz>();
        Cursor cursor = db.query(TABLE_SOAL, new String[]
                {
                        COL_SOAL_ID,COL_SOAL_SOAL, COL_SOAL_JAWABAN_A, COL_SOAL_JAWABAN_B, COL_SOAL_JAWABAN_C, COL_SOAL_JAWABAN_BENAR
                },null, null, null, null, null);
        if (cursor.moveToFirst())
        {
            do {
                quiz Quiz = new quiz();
                Quiz.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_SOAL_ID)));
                Quiz.setSoal(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_SOAL)));
                Quiz.setJawaban_a(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_A)));
                Quiz.setJawaban_b(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_B)));
                Quiz.setJawaban_c(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_C)));
                Quiz.setJawaban_benar(cursor.getString(cursor.getColumnIndexOrThrow(COL_SOAL_JAWABAN_BENAR)));
                listSoal.add(Quiz);
            } while (cursor.moveToNext());
        }
        return listSoal;
    }

}
