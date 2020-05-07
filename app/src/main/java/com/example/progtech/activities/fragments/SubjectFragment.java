package com.example.progtech.activities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.progtech.R;
import com.example.progtech.activities.model.Subject;
import com.example.progtech.activities.adapter.RecycleAdapter;
import com.example.progtech.activities.adapter.myDbAdapter;
import com.example.progtech.activities.activity.insert;

import java.util.ArrayList;
import java.util.List;

public class SubjectFragment extends Fragment {
    private myDbAdapter db;
    private List<Subject> not = new ArrayList<>();
    private RecycleAdapter adapter;
    FloatingActionButton button_add;
    Button button_edit;
    RecyclerView recyclerView;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subject, container, false);

        db = new myDbAdapter(getActivity());
        recyclerView = view.findViewById(R.id.rv_home);

        not = db.allPlayers();
        if (not.isEmpty()) {
            Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("main-list", not.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new RecycleAdapter(getActivity(), not);
            recyclerView.setAdapter(adapter);
        }

        button_edit = view.findViewById(R.id.button_edit);
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        button_add = (FloatingActionButton) view.findViewById(R.id.button_tambah);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), insert.class), 1);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        db = new myDbAdapter(getActivity());
        recyclerView = view.findViewById(R.id.rv_home);

        not = db.allPlayers();
        if (not.isEmpty()) {
            Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("main-list", not.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new RecycleAdapter(getActivity(), not);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            db = new myDbAdapter(getActivity());
            recyclerView = view.findViewById(R.id.rv_home);

            not = db.allPlayers();
            if (not.isEmpty()) {
                Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("main-list", not.toString());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);

                adapter = new RecycleAdapter(getActivity(), not);
                recyclerView.setAdapter(adapter);
            }


        }
    }
}
