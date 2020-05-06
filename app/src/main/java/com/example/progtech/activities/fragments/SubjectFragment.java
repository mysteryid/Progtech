package com.example.progtech.activities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progtech.R;
import com.example.progtech.activities.adapter.DatabaseHelper;
import com.example.progtech.activities.adapter.SubjectList;
import com.example.progtech.activities.model.Subject;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.progtech.activities.activities.AddSubject;

import java.util.ArrayList;
import java.util.List;

public class SubjectFragment extends Fragment {
    private DatabaseHelper databaseHelper;
    private List<Subject> nota = new ArrayList<>();
    private SubjectList subjectList;
    FloatingActionButton button_add;
    RecyclerView recyclerView;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subject,container,false);

        databaseHelper = new DatabaseHelper(getActivity());
        recyclerView= view.findViewById(R.id.rv);

        nota = databaseHelper.allPlayers();
        if (nota.isEmpty()){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Log.e("main-list", nota.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            subjectList = new SubjectList(getActivity(), nota);
            recyclerView.setAdapter(subjectList);
        }


        button_add = (FloatingActionButton) view.findViewById(R.id.button_tambah);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), AddSubject.class), 1);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        databaseHelper = new DatabaseHelper(getActivity());
        recyclerView= view.findViewById(R.id.rv);

        nota = databaseHelper.allPlayers();
        if (nota.isEmpty()){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Log.e("main-list", nota.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            subjectList = new SubjectList(getActivity(), nota);
            recyclerView.setAdapter(subjectList);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            databaseHelper = new DatabaseHelper(getActivity());
            recyclerView= view.findViewById(R.id.rv);

            nota = databaseHelper.allPlayers();
            if (nota.isEmpty()){
                Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
            }
            else{
                Log.e("main-list", nota.toString());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);

                subjectList = new SubjectList(getActivity(), nota);
                recyclerView.setAdapter(subjectList);
            }


        }
    }
}
