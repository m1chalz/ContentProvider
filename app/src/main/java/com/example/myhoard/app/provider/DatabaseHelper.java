package com.example.myhoard.app.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "mh.db";
	private static final int DB_VERSION = 3;

	private List<DatabaseTable> tables;

	public DatabaseHelper(Context context, List<DatabaseTable> tables) {
		super(context, DB_NAME, null, DB_VERSION);
		this.tables = tables;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.beginTransaction();
		try {
			for (DatabaseTable tb : tables) {
				tb.createTable(db);
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.beginTransaction();
		try {
			for (DatabaseTable tb : tables) {
				tb.upgradeTable(db, oldVersion, newVersion);
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
	}

}
