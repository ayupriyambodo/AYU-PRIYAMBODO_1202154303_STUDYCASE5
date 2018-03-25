package com.example.ayupriyambodo.modul5a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    EditText ToDo, Deskripsi, Priority;
    database dtbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        setTitle("Add To Do");

        ToDo = findViewById(R.id.editTodo);
        Deskripsi = findViewById(R.id.editDeskripsi);
        Priority = findViewById(R.id.editPriority);
        dtbs = new database(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddToDo.this, Pengaturan.class);
        startActivity(intent);
        this.finish();
    }

    public void addTodo(View view) {
        if (dtbs.inputdata(new AddData(ToDo.getText().toString(), Deskripsi.getText().toString(), Priority.getText().toString()))) {
            Toast.makeText(this, "To Do List ditamah!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddToDo.this, Pengaturan.class));
            this.finish();
        } else {
            Toast.makeText(this, "tidak dapat menmbah list!", Toast.LENGTH_SHORT).show();
            ToDo.setText(null);
            Deskripsi.setText(null);
            Priority.setText(null);
        }
    }
}