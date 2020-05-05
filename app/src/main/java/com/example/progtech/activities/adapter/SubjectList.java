package com.example.progtech.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progtech.R;
import com.example.progtech.activities.model.Subject;

import java.util.List;

public class SubjectList extends RecyclerView.Adapter<SubjectList.SubjectViewHolder> {

    private Context context;
    private List<Subject> listSubject;

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_student, parent, false);

        return new SubjectViewHolder(view);
    }

    public SubjectList(Context context, List<Subject> listSubject){
        this.context = context;
        this.listSubject = listSubject;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        final Subject subject = listSubject.get(position);

        holder.subject.setText(subject.getMataKuliah());
        holder.sks.setText(subject.getSks());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, subject.getMataKuliah(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSubject.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        public TextView subject;
        public TextView sks;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.input_subject);
            sks = itemView.findViewById(R.id.input_sks);
        }
    }
}

