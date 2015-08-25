Sample Android application to illustrate the concepts of Android ORM libraries like DBFlow etc.

# General Instructions

There are three basic migration classes available. For adding new tables no migration class is required.

## BaseMigration
This is a generic base migration class which can be used to run the migration from old database but typically this may not be required for migrations.
 
For example
```Java
@Migration(version = AppConstants.STUDENTS_DB_VERSION, databaseName = AppConstants.STUDENTS_DB_NAME)
public class StudentDbBaseMigration extends BaseMigration {
    @Override
    public void migrate(SQLiteDatabase database) {
        Log.d("Database version->" + database.getVersion());
    }
}
```
Note:
 - In the migration annotation above, version = current db version (use the version value from the constants) 
 - The version of the database object passed in the migrate method above points to the database found in the device.

For ex:
In the device, say, db version is 1 and the latest version the app is being migrated is 3. The above migrate method will get executed as the version is 3. Here the database.getVersion() will return 1 indicating the db version of the app found in the device. So use this migration class for any other miscellaneous migration logic that may not be possible by AlterTableMigration and UpdateTableMigration classes but generally prefer using the specific migration classes like AlterTableMigration, UpdateTableMigration etc

## AlterTableMigration
Use this migration class if you are adding a column to an existing table

For example
```Java
@Migration(version=2, databaseNameAppConstants.STUDENTS_DB_NAME)
public class StudentDbMigration1 extends AlterTableMigration<Student> {
    public StudentDbMigration1() {
        super(Student.class);
    }
    
    @Override
    public void onPreMigrate() {
        super.onPreMigrate();
        Log.d("Database version->" + String.valueOf(FlowManager.getDatabase(AppConstants.STUDENTS_DB_NAME).
                getDatabaseVersion()));
        addColumn(String.class, Student$Table.NICKNAME);
    }
}
```
Note
 - In the migration annotation above, version should typically point to the subsequent version where the new schema change is being introduced. Here the current version before migration is 1 and after migration it will be 2, so version value should be 2. The version value in this annotation is always hardcoded also keep the naming convention as xxxMigrationN, where 'N' indicates it is the migration script for moving from v1 to v2. 

Similarly we need to have separate migration classes for subsequent table alterations. Please refer StudentDbMigration2 class

## UpdateTableMigration
Use this migration class if you are updating a column to the existing table. Please refer StudentDbMigration3 class
