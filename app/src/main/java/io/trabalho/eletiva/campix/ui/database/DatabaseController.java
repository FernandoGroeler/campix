package io.trabalho.eletiva.campix.ui.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.trabalho.eletiva.campix.Utils;

public class DatabaseController {
    private SQLiteDatabase db;
    private CreateDatabase database;

    public DatabaseController(Context context) {
        database = new CreateDatabase(context);
    }

    public String insertData(Bitmap image, int likes) {
        ContentValues valores;
        long resultado;
        byte[] img = Utils.getBitmapAsByteArray(image);

        db = database.getWritableDatabase();
        valores = new ContentValues();
        valores.put(database.IMAGE, img);
        valores.put(database.LIKESCOUNT, likes);

        resultado = db.insert(database.TABLE, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir o registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public List<Feed> selectAllData() {
        String sql = "select image, likescount from " + database.TABLE;

        db = database.getWritableDatabase();
        Cursor cur = db.rawQuery(sql, null);

        List<Feed> feeds = new ArrayList<>();

        if (cur.moveToFirst()) {
            do {
                byte[] img = cur.getBlob(0);
                int likescount = cur.getInt(1);

                feeds.addAll(Arrays.asList(
                        new Feed(img, likescount)
                ));
            }while(cur.moveToNext());
        }

        if (cur != null && !cur.isClosed()) {
            cur.close();
        }

        return feeds;
    }
}
