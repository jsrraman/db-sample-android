package com.rajaraman.db_sample.db.migration;

import com.noveogroup.android.log.Log;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.rajaraman.db_sample.db.model.Student;
import com.rajaraman.db_sample.db.model.Student$Table;
import com.rajaraman.db_sample.utils.AppConstants;

// Use this migration for altering the existing table (only add column is allowed)
// https://www.sqlite.org/omitted.html
// Migration from version 1 to 2
@Migration(version = 2, databaseName = AppConstants.STUDENTS_DB_NAME)
public class StudentDbMigration1 extends AlterTableMigration<Student> {

    public StudentDbMigration1() {
        super(Student.class);
    }

    @Override
    public void onPreMigrate() {
        super.onPreMigrate();
        Log.d("Database version->", FlowManager.getDatabase(AppConstants.STUDENTS_DB_NAME).
                getDatabaseVersion());

        addColumn(String.class, Student$Table.NICKNAME);
    }
}

//// This class is for testing db migration. Uncomment and comment the above definition
//// when you do not migration to happen while testing.
//public class StudentDbAlterTableMigration {
//}