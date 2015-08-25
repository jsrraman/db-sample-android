package com.rajaraman.db_sample.db.migration;

import com.noveogroup.android.log.Log;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.raizlabs.android.dbflow.sql.migration.UpdateTableMigration;
import com.rajaraman.db_sample.db.model.Student;
import com.rajaraman.db_sample.db.model.Student$Table;
import com.rajaraman.db_sample.utils.AppConstants;

// Migration from version 2 to 3
@Migration(version = 3, databaseName = AppConstants.STUDENTS_DB_NAME)
public class StudentDbMigration2 extends AlterTableMigration<Student> {

    // You need to have
    public StudentDbMigration2() {
        super(Student.class);
    }

    @Override
    public void onPreMigrate() {
        super.onPreMigrate();
        Log.d("Database version->" + String.valueOf(FlowManager.getDatabase(AppConstants.STUDENTS_DB_NAME).
                getDatabaseVersion()));

        addColumn(String.class, Student$Table.FULLNAME);
    }

//    private void updateStudentTable() {
//
//        // Warning:
//        // DO NOT create an instance of Update class inside UpdateTableMigration, as this will try to call
//        // getDatabase recursively and we will end up in illegal state exception similar to the one
//        // explained here - http://stackoverflow.com/questions/15955799/getdatabase-called-recursively
//        // Creating an instance of Update class outside this class is absolutely fine. For reference
//        // check updateStudentDbData() of DbActivity
//
//        // *************** DO NOT UNCOMMENT ***********************
////
////        ConditionQueryBuilder<Student> whereConditionQueryBuilder = new ConditionQueryBuilder<>(Student.class,
////                Condition.column(Student$Table.NICKNAME).is("NickName1"))
////                .or(Condition.column(Student$Table.NICKNAME).is("NickName2"));
////
////        // UPDATE Student SET nickName = "RAM" WHERE nickName = "NickName1" OR nickName = "NickName2"
////        new Update(Student.class).set(
////                Condition.column(Student$Table.NICKNAME).is("Ram"))
////                .where(whereConditionQueryBuilder);
//        // *************** DO NOT UNCOMMENT ***********************
//
//        // Just call set method of this class which does the same thing
//        set(Condition.column(Student$Table.NICKNAME).is("Ram")).where(
//                    Condition.column(Student$Table.NICKNAME).is("NickName1"),
//                    Condition.column(Student$Table.NICKNAME).is("NickName2"));
//    }
}

//// This class is for testing db migration. Uncomment and comment the above definition
//// when you do not migration to happen while testing.
//public class StudentDbUpdateTableMigration {
//}