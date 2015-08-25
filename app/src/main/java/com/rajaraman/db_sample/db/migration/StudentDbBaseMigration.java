package com.rajaraman.db_sample.db.migration;

import android.database.sqlite.SQLiteDatabase;

import com.noveogroup.android.log.Log;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.rajaraman.db_sample.utils.AppConstants;

// This class is needed when you need to migrate after introducing a new table. Let this class
// be there for DB migration, whenever a new table is added and version incremented, this would take
// care of adding the new table into the migrated db
@Migration(version = 1, databaseName = AppConstants.STUDENTS_DB_NAME)
public class StudentDbBaseMigration extends BaseMigration {

    @Override
    public void migrate(SQLiteDatabase database) {
        Log.d("Database version->" + database.getVersion());
    }
}