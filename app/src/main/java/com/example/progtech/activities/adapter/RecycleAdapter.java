package com.example.progtech.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progtech.R;
import com.example.progtech.activities.model.Subject;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private Context context;
    private List<Subject> notesList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_student, parent, false);

        return new MyViewHolder(itemView);
    }

    public RecycleAdapter(Context context, List<Subject> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Subject user = notesList.get(position);

        holder.tvTitle.setText(user.getTitle());
        holder.tvNote.setText(user.getNote());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvNote;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvNote = view.findViewById(R.id.note);
        }
    }
}
