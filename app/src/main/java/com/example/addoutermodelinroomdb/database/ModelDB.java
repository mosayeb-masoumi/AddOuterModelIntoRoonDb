package com.example.addoutermodelinroomdb.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ModelDB {
    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "family")
    private String family;

    public ModelDB(String name, String family) {
        this.name = name;
        this.family = family;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
