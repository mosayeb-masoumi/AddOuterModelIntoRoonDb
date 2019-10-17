package com.example.addoutermodelinroomdb;

public class MyModel {
    private String name;
    private String family ;

    public MyModel(String name, String family) {
        this.name = name;
        this.family = family;
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
