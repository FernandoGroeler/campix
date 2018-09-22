package io.trabalho.eletiva.campix.ui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseController {
    private SQLiteDatabase db;
    private CreateDatabase database;

    public DatabaseController(Context context) {
        database = new CreateDatabase(context);
    }
}
