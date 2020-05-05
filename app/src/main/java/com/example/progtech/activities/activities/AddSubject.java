package com.example.progtech.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.progtech.R;
import com.google.android.material.textfield.TextInputLayout;
import com.example.progtech.activities.adapter.DatabaseHelper;

public class AddSubject extends AppCompatActivity implements TextWatcher{

    Toolbar toolbar;
    TextInputLayout inputSubject, inputSks;
    Button button_add_subject;
    DatabaseHelper databaseHelper;
    String subject,sks;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        inputSubject = findViewById(R.id.input_subject);
        inputSks = findViewById(R.id.input_sks);
        button_add_subject = findViewById(R.id.btn_add_subject);

        databaseHelper = new DatabaseHelper(this);

        inputSubject.getEditText().addTextChangedListener((TextWatcher) this);
        inputSks.getEditText().addTextChangedListener(this);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_add_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject = inputSubject.getEditText().getText().toString().trim();
                sks = inputSks.getEditText().getText().toString().trim();
                long id = databaseHelper.insertData(subject,sks);
                finish();
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void finish() {
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        super.finish();
    }
}