package com.aqurd.app.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aqurd.app.models.Brand;
import com.aqurd.app.models.Connection;
import com.aqurd.app.models.Model;

import java.util.ArrayList;

public class SqliteDB extends SQLiteOpenHelper {

    Context mContext;

    private static final String DATABASE_NAME="aquardDB.db";
    private static final String TABLE_NAME1="BRAND";
    private static final String TABLE_NAME1_COL1="ID";
    private static final String TABLE_NAME1_COL2="NAME";

    private static final String TABLE_NAME2="MODEL";
    private static final String TABLE_NAME2_COL1="ID";
    private static final String TABLE_NAME2_COL2="NAME";
    private static final String TABLE_NAME2_COL3="ID_BRAND";

    private static final String TABLE_NAME3="CONNECTION";
    private static final String TABLE_NAME3_COL1="ID";
    private static final String TABLE_NAME3_COL2="NAKLADKA";
    private static final String TABLE_NAME3_COL3="SMET";
    private static final String TABLE_NAME3_COL4="ID_MODEL";

    public static String DB_LOCATION= "/data/data/com.aqurd.app/database";
    public static String DB_FILEPATH = "";

    private static int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public SqliteDB(Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
       sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT)");
        db.execSQL("create table " + TABLE_NAME2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, FOREIGN KEY(ID_BRAND) REFERENCES "+ TABLE_NAME1+"(ID) )");
        db.execSQL("create table " + TABLE_NAME3+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAKLADKA TEXT, SMET TEXT, FOREIGN KEY(ID_MODEL) REFERENCES "+ TABLE_NAME2+"(ID) )");
        db.execSQL("PRAGMA foreign_keys=ON;");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);

    }

    public void openDatabase(){
        DB_FILEPATH = mContext.getDatabasePath(DATABASE_NAME).getPath();
        if(sqLiteDatabase!=null && sqLiteDatabase.isOpen()){
            return;
        }
        sqLiteDatabase = SQLiteDatabase.openDatabase(DB_FILEPATH ,null,SQLiteDatabase.OPEN_READWRITE);
       // sqLiteDatabase = getWritableDatabase();
    }


    public void closeDatabase(){
        if(sqLiteDatabase !=null){
            sqLiteDatabase.close();
        }
    }

    public Connection getConnection(){
        Connection con = new Connection();
        SQLiteDatabase db = this.getWritableDatabase();
        String name_0 = null;
        String name_1 = null;
        String selectQuery = "SELECT * from "+TABLE_NAME3;
        Cursor cursor=(db).rawQuery(selectQuery,null);
        while (cursor.moveToNext()) {
            name_0=cursor.getString(1);
            name_1=cursor.getString(2);
            con.addConnection(name_0,name_1);
        }
        cursor.close();
        (db).close();
        return con;
    }

    public ArrayList<Model> getAllModels()
    {
        ArrayList<Model> list= new ArrayList<Model>();
        SQLiteDatabase db = this.getWritableDatabase();
        String name_0 = null;
        boolean IsOn_1 = false;
        String selectQuery = "SELECT * from "+TABLE_NAME2;
        Cursor cursor=(db).rawQuery(selectQuery,null);
        while (cursor.moveToNext()) {
            name_0=cursor.getString(1);
            //if(cursor.getInt(2) > 0) IsOn_1=true;
            //else IsOn_1=false;
            Model model = new Model(name_0);
            list.add(model);
        }
        cursor.close();
        (db).close();
        return list;
    }


    public ArrayList<Brand> getAllBrands()
    {
        ArrayList<Brand> list= new ArrayList<Brand>();
        SQLiteDatabase db = this.getWritableDatabase();
        String name_0 = null;
        String selectQuery = "SELECT * from "+TABLE_NAME1;
        Cursor cursor=(db).rawQuery(selectQuery,null);
        while (cursor.moveToNext()) {
            name_0=cursor.getString(1);
            Brand brand = new Brand(name_0);
            list.add(brand);
        }
        cursor.close();
        (db).close();
        return list;
    }

}
