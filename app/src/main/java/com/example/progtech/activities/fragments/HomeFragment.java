package com.example.progtech.activities.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.progtech.R;
import com.example.progtech.activities.adapter.CardStudent;
import com.example.progtech.activities.model.Student;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView rvStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //cara 1
        return inflater.inflate(R.layout.fragment_home, container, false);

        //cara 2
        //View view = inflater.inflate(R.layout.fragment_home, container, false);
        //
        //
        //return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvStudent = view.findViewById(R.id.rv_student);
        getStudent();
    }

    private void getStudent() {
        final ArrayList<Student> students = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://reinerjasin.000webhostapp.com/api/list.php";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("student");
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject obj = list.getJSONObject(i);
                        Student s = new Student(obj.getString("id"), obj.getString("nim"), obj.getString("name"), obj.getString("email"), obj.getString("phone"), obj.getString("gender"));
                        students.add(s);
                    }
                    showStudent(students);
                } catch (Exception e) {
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("OnFailureStudent", "onFailure: " + error.getMessage());
            }
        });
    }

    private void showStudent(ArrayList<Student> students) {
        rvStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardStudent cardStudent = new CardStudent(getContext());
        cardStudent.setListStudent(students);
        rvStudent.setAdapter(cardStudent);
    }
}
