package com.example.progtech.activities.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.example.progtech.R;
import com.example.progtech.activities.adapter.myDbAdapter;

public class insert extends AppCompatActivity implements TextWatcher {

    Toolbar toolbar;
    TextInputLayout inputTitle, inputNote;
    TextInputLayout nsaa1,nsaa2,nsaa3,nsaa4,nsaa5;
    TextInputLayout bsaa1,bsaa2,bsaa3,bsaa4,bsaa5;
    Button button_save;
    myDbAdapter helper;
    String title, note;
    String input_nilai_saa1, input_nilai_saa2, input_nilai_saa3, input_nilai_uts, input_nilai_uas;
    String input_bobot_saa1, input_bobot_saa2, input_bobot_saa3, input_bobot_uts, input_bobot_uas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        inputTitle = findViewById(R.id.input_subject);
        inputNote = findViewById(R.id.input_sks);
        nsaa1 = findViewById(R.id.input_nilai_saa1);
        bsaa1 = findViewById(R.id.input_bobot_saa1);
        nsaa2 = findViewById(R.id.input_nilai_saa2);
        bsaa2 = findViewById(R.id.input_bobot_saa2);
        nsaa3 = findViewById(R.id.input_nilai_saa3);
        bsaa3 = findViewById(R.id.input_bobot_saa3);
        nsaa4 = findViewById(R.id.input_nilai_uts);
        bsaa4 = findViewById(R.id.input_bobot_uts);
        nsaa5 = findViewById(R.id.input_nilai_uas);
        bsaa5 = findViewById(R.id.input_bobot_uas);
        button_save = findViewById(R.id.button_save);

        helper = new myDbAdapter(this);

        inputTitle.getEditText().addTextChangedListener((TextWatcher) this);
        inputNote.getEditText().addTextChangedListener(this);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = inputTitle.getEditText().getText().toString().trim();
                note = inputNote.getEditText().getText().toString().trim();
                input_nilai_saa1 = nsaa1.getEditText().getText().toString().trim();
                input_bobot_saa1 = bsaa1.getEditText().getText().toString().trim();
                input_nilai_saa2 = nsaa2.getEditText().getText().toString().trim();
                input_bobot_saa2 = bsaa2.getEditText().getText().toString().trim();
                input_nilai_saa3 = nsaa3.getEditText().getText().toString().trim();
                input_bobot_saa3 = bsaa3.getEditText().getText().toString().trim();
                input_nilai_uts = nsaa4.getEditText().getText().toString().trim();
                input_bobot_uts = bsaa4.getEditText().getText().toString().trim();
                input_nilai_uas = nsaa5.getEditText().getText().toString().trim();
                input_bobot_uas = bsaa5.getEditText().getText().toString().trim();
                long id = helper.insertData(title, note, input_nilai_saa1, input_bobot_saa1, input_nilai_saa2, input_bobot_saa2, input_nilai_saa3, input_bobot_saa3, input_nilai_uts, input_bobot_uts, input_nilai_uas, input_bobot_uas);
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