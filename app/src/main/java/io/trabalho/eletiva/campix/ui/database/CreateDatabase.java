package io.trabalho.eletiva.campix.ui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "campix.db";
    private static final int VERSION = 1;

    public CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE feed (_id integer primary key autoincrement, " +
                     "                   image blob,                            " +
                     "                   likes integer)                         ";

        db.execSQL(sql);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS feed");
        onCreate(db);
    }
}
