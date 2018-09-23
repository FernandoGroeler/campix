package io.trabalho.eletiva.campix.ui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "campix.db";
    private static final int VERSION = 5;

    public static final String IMAGE = "image";
    public static final String LIKESCOUNT = "likescount";
    public static final String TABLE = "feed";

    public CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +
                TABLE + " (_id integer primary key autoincrement, " +
                IMAGE + " blob, " +
                LIKESCOUNT + " integer) ";

        db.execSQL(sql);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
