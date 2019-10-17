package com.example.addoutermodelinroomdb.activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.addoutermodelinroomdb.R;
import com.example.addoutermodelinroomdb.database.AppDatabase;
import com.example.addoutermodelinroomdb.database.ModelDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt_name, txt_family;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = findViewById(R.id.txt_name);
        txt_family = findViewById(R.id.txt_family);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "detaildb")
                .allowMainThreadQueries()
                .build();

        List<ModelDB> modelDBarray = new ArrayList<>();
        modelDBarray = db.detailDAO().getAllMyModelSaveDB();

        if (modelDBarray.size() != 0 && modelDBarray != null) {
            txt_name.setText(modelDBarray.get(0).getName());
            txt_family.setText(modelDBarray.get(0).getFamily());
        } else {
            txt_name.setText("-");
            txt_family.setText("-");
        }

    }
}