package com.rajaraman.db_sample.db.migration;

import android.database.sqlite.SQLiteDatabase;

import com.noveogroup.android.log.Log;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.rajaraman.db_sample.utils.AppConstants;

// This is a generic base migration class which will give you a place holder
// to run the migrations
// Note:
// 1. version = x -> current db version (use the version value from the constants)
// 2. The version of the database object passed in the migrate method below points to the database
// found in the device.
// For ex:  In the device, say db version is 1 and the latest version is 3. This migrate will execute
// only if version is 3 and in the database.getVersion will return 1. So use this migration class
// for any miscellaneous migration but generally use the specific versions like AlterTableMigration,
// UpdateTableMigration etc
@Migration(version = AppConstants.STUDENTS_DB_VERSION, databaseName = AppConstants.STUDENTS_DB_NAME)
public class StudentDbBaseMigration extends BaseMigration {
    @Override
    public void migrate(SQLiteDatabase database) {
        Log.d("Database version->" + database.getVersion());
    }
}