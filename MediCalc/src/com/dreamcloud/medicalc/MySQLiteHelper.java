package com.dreamcloud.medicalc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dreamcloud.medcontent.MedicationContent;

/**
 * Created by Yoder on 5/15/2014.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{

    //table title
    public static final String TABLE_MEDI = "medi";

    //Columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String DESCRIPTION = "description";

    public static final String[] COLUMNS = {ID, NAME, TYPE, DESCRIPTION};

    private static final String DATABASE_NAME = "medication";
    private static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void addItem(MedicationContent.MedicationItem item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, MedicationContent.getItemName(item.id)); //Item name
        values.put(TYPE, item.type);
    }

    public MedicationContent.MedicationItem getItem (int id) {
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEDI_TABLE = "CREATE TABLE medi (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "type TEXT, " +
                "description TEXT )";

        db.execSQL(CREATE_MEDI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop old table
        db.execSQL("DROP TABLE IF EXISTS medi");

        //create fresh medi table
        this.onCreate(db);
    }



}
