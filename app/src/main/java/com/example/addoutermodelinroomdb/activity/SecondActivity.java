package com.example.addoutermodelinroomdb.activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.addoutermodelinroomdb.MyModel;
import com.example.addoutermodelinroomdb.R;
import com.example.addoutermodelinroomdb.database.AppDatabase;
import com.example.addoutermodelinroomdb.database.ModelDB;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ArrayList<MyModel> arrayMyModel = new ArrayList<>();
        arrayMyModel.add(new MyModel("hassan","hassany"));
        arrayMyModel.add(new MyModel("hassani","hassan"));



//        db
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "detaildb")
                .allowMainThreadQueries()
                .build();

        ArrayList<MyModel> myModel = new ArrayList<>();
        for (MyModel m: arrayMyModel) {
            myModel.add(m);


            // insert each row of outer model in each row of db
            ModelDB modelDB = new ModelDB(m.getName(),m.getFamily());
            db.detailDAO().insertAll(modelDB);

        }

        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }
}
