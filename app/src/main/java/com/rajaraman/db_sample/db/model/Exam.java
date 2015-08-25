package com.rajaraman.db_sample.db.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.rajaraman.db_sample.utils.AppConstants;

@Table(databaseName = AppConstants.STUDENTS_DB_NAME)
public class Exam extends BaseModel {
    @Column
    @PrimaryKey
    public long id;

    @Column
    public String name;
}