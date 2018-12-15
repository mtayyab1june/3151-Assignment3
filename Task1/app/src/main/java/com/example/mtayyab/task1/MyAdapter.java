package com.example.mtayyab.task1;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        Student student=studentList.get(position);
        holder.sname.setText(student.getStudent_name());
        holder.sregno.setText(String.valueOf(student.getStudent_regno()));
        holder.sage.setText(String.valueOf(student.getStudent_age()));
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
