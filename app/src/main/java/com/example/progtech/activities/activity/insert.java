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

public class insert extends AppCompatActivity implements TextWatcher{

    Toolbar toolbar;
    TextInputLayout inputTitle, inputNote;
    Button button_save;
    myDbAdapter helper;
    String title,note;
    String input_nilai_saa1, input_nilai_saa2, input_nilai_saa3, input_nilai_uts, input_nilai_uas;
    String input_bobot_saa1, input_bobot_saa2, input_bobot_saa3, input_bobot_uts, input_bobot_uas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        inputTitle = findViewById(R.id.input_subject);
        inputNote = findViewById(R.id.input_sks);
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
                input_nilai_saa1 = inputNote.getEditText().getText().toString().trim();
                input_bobot_saa1 = inputNote.getEditText().getText().toString().trim();
                input_nilai_saa2 = inputNote.getEditText().getText().toString().trim();
                input_bobot_saa2 = inputNote.getEditText().getText().toString().trim();
                input_nilai_saa3 = inputNote.getEditText().getText().toString().trim();
                input_bobot_saa3 = inputNote.getEditText().getText().toString().trim();
                input_nilai_uts = inputNote.getEditText().getText().toString().trim();
                input_bobot_uts = inputNote.getEditText().getText().toString().trim();
                input_nilai_uas = inputNote.getEditText().getText().toString().trim();
                input_bobot_uas = inputNote.getEditText().getText().toString().trim();

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