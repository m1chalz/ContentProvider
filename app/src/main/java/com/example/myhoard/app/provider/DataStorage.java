package com.example.myhoard.app.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * The contract between the data provider and application. Contains
 * definitions for the supported URIs and data columns.
 */
public final class DataStorage {
	/**
	 * This authority is used for writing to or querying from the database
	 * provider. Note: This is set at first run and cannot be changed without
	 * breaking apps that access the provider.
	 */
	public static final String AUTHORITY = "com.example.myhoard.app.provider";
	/**
	 * The content:// style URL for the top-level database authority
	 */
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

	/**
	 * Columns from Collections table.
	 */
	protected interface CollectionsColumns {

		/**
		 * Name. Column name.
		 * <p>Type: TEXT</p>
		 */
		public static final String NAME = "name";

		/**
		 * Description. Column name.
		 * <p>Type: TEXT</p>
		 */
		public static final String DESCRIPTION = "description";

		/**
		 * Item picture filename. Column name.
		 * <p>Type: TEXT</p>
		 */
		public static final String AVATAR_FILE_NAME = "avatarFileName";
	}

	public static final class Collections implements BaseColumns, CollectionsColumns {
		public static final String TABLE_NAME = "collections";
		public static final Uri CONTENT_URI = Uri.parse(DataStorage.CONTENT_URI + "/" + TABLE_NAME);
		public static final String[] TABLE_COLUMNS = new String[] {
				_ID,
				NAME,
				DESCRIPTION,
				AVATAR_FILE_NAME
		};

		/**
		 * This utility class cannot be instantiated
		 */
		private Collections() {}
	}
}
