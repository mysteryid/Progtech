package com.example.progtech.activities.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.progtech.R;
import com.example.progtech.activities.DatabaseHelper;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mlistView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mlistView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }
    private void populateListView(){
        Log.d(TAG, "popuulateListView: Displaying data in the ListView.");

        //get the data and append to a list;
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in colummn 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }

        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mlistView.setAdapter(adapter);
    }

    private void toasMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
