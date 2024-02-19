package com.example.profile_picture;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "image_database.db";
    private static final String TABLE_NAME = "selected_image";
    private static final String COLUMN_IMAGE_URI = "image_uri";
    private static final int DATABASE_VERSION = 1;

    public ImageDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_IMAGE_URI + " TEXT PRIMARY KEY)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void saveSelectedImage(String imageUri) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE_URI, imageUri);
        db.insertWithOnConflict(TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public String getSelectedImage() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IMAGE_URI};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        String imageUri = null;
        if (cursor.moveToFirst()) {
            imageUri = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URI));
        }
        cursor.close();
        db.close();
        return imageUri;
    }

}