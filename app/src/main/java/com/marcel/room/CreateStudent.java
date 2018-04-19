package com.marcel.room;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Marcel Benavides on 12/4/18.
 */

public class CreateStudent extends AppCompatActivity{

    EditText nombre;
    EditText apellido;
    EditText carnet;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student);


        nombre = findViewById(R.id.txt_nombre);
        apellido = findViewById(R.id.txt_apellido);
        carnet = findViewById(R.id.txt_carnet);
        button = findViewById(R.id.button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Produccion")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(nombre.getText().toString(),apellido.getText().toString(),carnet.getText().toString());
                db.studentDao().insertAll(student);
                startActivity(new Intent(CreateStudent.this,MainActivity.class));
            }
        });
    }
}
