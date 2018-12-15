package com.example.mtayyab.firebaseproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<Student> studentList;
    DatabaseReference databaseStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        databaseStudent= FirebaseDatabase.getInstance().getReference("students");

        recyclerView=(RecyclerView) findViewById(R.id.rcview);
        RecyclerView.LayoutManager myLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        studentList=new ArrayList<>();
        databaseStudent.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                studentList.clear();
                for (DataSnapshot studentSnapshot1 :  dataSnapshot.getChildren())
                {
                    Student student=studentSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }
                myAdapter=new MyAdapter(DisplayActivity.this,studentList);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
            }
        });

    }
}
