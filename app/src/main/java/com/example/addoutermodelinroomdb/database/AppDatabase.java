package com.example.addoutermodelinroomdb.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ModelDB.class} , version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DetailDAO detailDAO();
}
