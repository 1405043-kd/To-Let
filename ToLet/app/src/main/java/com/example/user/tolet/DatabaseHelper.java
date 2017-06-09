package com.example.user.tolet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by Lotus Computer on 01-Jun-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "ads.db";
    public static final String TABLE_NAME = "ads_info";
    public static  int id = 0;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (HOUSE TEXT, ROAD TEXT, THANA TEXT, DISTRICT TEXT, POSTADRS TEXT, CONTACT TEXT, ISBACHELOR TEXT, IMAGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(TaskItem taskItem) {
        SQLiteDatabase db = this.getWritableDatabase();
    /*    String sql = "INSERT INTO "+ TABLE_NAME + " VALUES (?,?,?,?,?,?,?,?)";
       // System.out.println("hehe");
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, taskItem.getHouseNo());
        statement.bindString(2, taskItem.getRoadNo());
        statement.bindString(3, taskItem.getThana());
        statement.bindString(4, taskItem.getDistrict());
        statement.bindString(5, taskItem.getPostAddress());
        statement.bindString(6, taskItem.getContactNo());
        statement.bindString(7, taskItem.getIsBachelor());
        try {
            statement.bindBlob(8, taskItem.getByteImage());
        }
        catch (Exception e) {}

        statement.executeInsert();*/

        ContentValues filedata= new ContentValues();
        filedata.put("HOUSE", taskItem.getHouseNo());
        filedata.put("ROAD", taskItem.getRoadNo());
        filedata.put("THANA", taskItem.getThana());
        filedata.put("DISTRICT", taskItem.getDistrict());
        filedata.put("POSTADRS", taskItem.getPostAddress());
        filedata.put("CONTACT", taskItem.getContactNo());
        filedata.put("ISBACHELOR", taskItem.getIsBachelor());
      //  ByteArrayOutputStream out = new ByteArrayOutputStream();
      //  taskItem.getByteImage().compress(Bitmap.CompressFormat.PNG, 100, out);
      //  byte[] buffer=out.toByteArray();
        filedata.put("IMAGE", taskItem.getImageUri());
        db.insert(TABLE_NAME,null,filedata);
        return true;
    }

    public Cursor getAsRequested(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(sql,null);
        System.out.println(sql);
        if(res.getCount() > 0) System.out.println("nothing");
        return  res;
    }



}

