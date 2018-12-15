package com.example.mtayyab.task1;

public class Student
{
    private String student_name;
    private int student_regno;
    private int student_age;
    public Student()
    {
    }
    public Student(String student_name,int student_regno,int student_age)
    {
        this.student_name=student_name;
        this.student_regno=student_regno;
        this.student_age=student_age;
    }

    public void setStudent_name(String student_name)
    {
        this.student_name = student_name;
    }

    public void setStudent_regno(int student_regno)
    {
        this.student_regno = student_regno;
    }

    public void setStudent_age(int student_age)
    {
        this.student_age = student_age;
    }

    public String getStudent_name()
    {
        return student_name;
    }

    public int getStudent_regno()
    {
        return student_regno;
    }

    public int getStudent_age()
    {
        return student_age;
    }
}
