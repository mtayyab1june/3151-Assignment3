package com.example.mtayyab.firebaseproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private List<Student> studentList;
    private Context context;

    MyAdapter(Context c,List<Student> studentList)
    {
        this.context=c;
        this.studentList=studentList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.studentview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        final Student student=studentList.get(position);
        holder.sname.setText(student.getStudent_name());
        holder.sregno.setText(String.valueOf(student.getStudent_regno()));
        holder.sage.setText(String.valueOf(student.getStudent_age()));
        holder.sname.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
                LayoutInflater inflater=LayoutInflater.from(context);
                View dialogView=inflater.inflate(R.layout.update_dialog,null);
                dialogBuilder.setView(dialogView);

                final EditText editText1=(EditText) dialogView.findViewById(R.id.etxt1);
                final EditText editText2=(EditText) dialogView.findViewById(R.id.etxt2);
                final EditText editText3=(EditText) dialogView.findViewById(R.id.etxt3);
                final Button button1=(Button) dialogView.findViewById(R.id.btn1);
                final Button button2=(Button) dialogView.findViewById(R.id.btn2);

                dialogBuilder.setTitle("Student RegNo= "+student.getStudent_regno());
                button1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String name=editText1.getText().toString();
                        int regno=Integer.parseInt(editText2.getText().toString());
                        int age=Integer.parseInt(editText3.getText().toString());
                        DatabaseReference databaseStudent= FirebaseDatabase.getInstance().getReference("students").child(String.valueOf(regno));
                        Student student1=new Student(name,regno,age);
                        databaseStudent.setValue(student1);
                        Toast.makeText(context,"Student Updated",Toast.LENGTH_LONG).show();
                    }
                });

                button2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String name=editText1.getText().toString();
                        int regno=Integer.parseInt(editText2.getText().toString());
                        int age=Integer.parseInt(editText3.getText().toString());
                        DatabaseReference databaseStudent= FirebaseDatabase.getInstance().getReference("students").child(String.valueOf(regno));
                        databaseStudent.removeValue();
                        Toast.makeText(context,"Student Deleted",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alertDialog=dialogBuilder.create();
                alertDialog.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView sname;
        TextView sregno;
        TextView sage;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sname = (TextView) itemView.findViewById(R.id.txtv1);
            sregno = (TextView) itemView.findViewById(R.id.txtv2);
            sage = (TextView) itemView.findViewById(R.id.txtv3);
        }
    }
}
