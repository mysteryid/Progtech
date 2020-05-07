package com.example.progtech.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progtech.R;
import com.example.progtech.activities.activity.MainActivity;
import com.example.progtech.activities.activity.SplashActivity;
import com.example.progtech.activities.fragments.SubjectFragment;
import com.example.progtech.activities.model.Subject;

import java.util.List;

public class RecycleAdapter2 extends RecyclerView.Adapter<RecycleAdapter2.MyViewHolder2> {

    private Context context;
    private List<Subject> notesList;

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ip_student, parent, false);

        return new MyViewHolder2(itemView);
    }

    public RecycleAdapter2(Context context, List<Subject> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override

    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        final Subject user = notesList.get(position);

        holder.tvTitle.setText(user.getTitle());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public TextView tvAverage4;
        public TextView tvAverage375;
        public TextView tvAverage35;
        public TextView tvAverage3;


        public MyViewHolder2(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAverage4 = view.findViewById(R.id.average4);
            tvAverage375 = view.findViewById(R.id.average375);
            tvAverage35 = view.findViewById(R.id.average35);
            tvAverage3 = view.findViewById(R.id.average3);
        }
    }
}
