package com.example.user.tolet;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

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
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (HOUSE TEXT ,ROAD TEXT,THANA TEXT,DISTRICT TEXT, POSTADRS TEXT,CONTACT TEXT,ISBACHELOR TEXT,IMAGE BLOB) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(TaskItem taskItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO "+ TABLE_NAME + " VALUES (?,?,?,?,?,?,?,?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, taskItem.getHouseNo());
        statement.bindString(2, taskItem.getRoadNo());
        statement.bindString(3, taskItem.getThana());
        statement.bindString(4, taskItem.getDistrict());
        statement.bindString(5, taskItem.getPostAddress());
        statement.bindString(6, taskItem.getContactNo());
        statement.bindString(7, taskItem.getIsBachelor());
        statement.bindBlob(8, taskItem.byteImage);
        statement.executeInsert();

        return true;
    }

    public Cursor getAsRequested(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(sql,null);
        System.out.println(sql);
        if(res.getCount() == 0) System.out.println("nothing");
        return  res;
    }



}

