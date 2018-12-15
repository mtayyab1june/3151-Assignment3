package com.example.mtayyab.firebaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentActivity extends AppCompatActivity
{
    private TextView textView;
    private EditText editText1,editText2,editText3;
    private Button button;
    private DatabaseReference databaseStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        databaseStudent= FirebaseDatabase.getInstance().getReference("students");

        textView=(TextView) findViewById(R.id.txtv2);
        editText1=(EditText) findViewById(R.id.etxt1);
        editText2=(EditText) findViewById(R.id.etxt2);
        editText3=(EditText) findViewById(R.id.etxt3);
        button=(Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addStudent();
            }
        });
    }
    private void addStudent()
    {
        String name=editText1.getText().toString();
        int regno=Integer.parseInt(editText2.getText().toString());
        int age=Integer.parseInt(editText3.getText().toString());
        Student student=new Student(name,regno,age);
        databaseStudent.child(String.valueOf(regno)).setValue(student);
        Toast.makeText(this,"Student Added",Toast.LENGTH_LONG).show();
    }
}
