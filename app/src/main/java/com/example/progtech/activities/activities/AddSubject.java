package com.example.progtech.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progtech.R;
import com.example.progtech.activities.DatabaseHelper;
import com.google.android.material.textfield.TextInputLayout;

public class AddSubject extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    TextInputLayout input_subject, input_jumlah_sks;
    Button btnAdd, btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        input_subject = findViewById(R.id.input_subject);
        input_jumlah_sks = findViewById(R.id.input_jumlah_sks);
        btnAdd = findViewById(R.id.btn_add_subject);
        btnViewData = findViewById(R.id.btn_view_data);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry1 = input_subject.getEditText().toString().trim();
                String newEntry2 = input_jumlah_sks.getEditText().toString().trim();
                if (newEntry1.length() != 0) {
                    AddData(newEntry1);
                    newEntry1 = "";
                } else {
                    toastMessage("You Must put something in the Subject field!");
                }
                if (newEntry2.length() != 0) {
                    AddData(newEntry2);
                    newEntry2 = "";
                } else {
                    toastMessage("You Must put something in the SKS field!");
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
