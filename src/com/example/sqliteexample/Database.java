package com.example.sqliteexample;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	public Database(Context context) {
		super(context, "unhcr", null, 1);// modify here
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// modify this query to create your own table
		String sql = "CREATE TABLE IF NOT EXISTS refugees "
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " names TEXT NOT NULL, " + " age INTEGER NOT NULL, "
				+ " origin TEXT NOT NULL," + " gender TEXT NOT NULL)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS refugees";// modify to suit your
														// table
		db.execSQL(sql);
	}

	/**
	 * Saves an item into sqlite database
	 * 
	 * @param names
	 * @param quantity
	 */
	public void save(String names, String age, String origin, String gender)// Modify here to suit what you want to save
	{																	
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("names", names);// modify here
		values.put("age", age);// modify here
		values.put("origin", origin);// modify here
		values.put("gender", gender);
		db.insert("refugees", null, values);// modify here
		db.close();
	}

	/**
	 * Fetches all unsynced records from the database Where the status is no
	 * 
	 * @return
	 */
	public ArrayList<Refugee> fetch()// //modify here
	{
		ArrayList<Refugee> data = new ArrayList<Refugee>();// //modify here
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM refugees";// modify here
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
			do {

				String names = cursor.getString(1);
				String age = cursor.getString(2);
				String origin = cursor.getString(3);
				String gender = cursor.getString(4);

				Refugee x = new Refugee(names, age, origin, gender);
				data.add(x);

			} while (cursor.moveToNext()); // modify here
		}
		return data;
	}

	/**
	 * Counts All Records in sqlite
	 * 
	 * @return
	 */
	public int count() {
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM refugees";// modify here
		Cursor cursor = db.rawQuery(sql, null);
		return cursor.getCount();
	}
}
