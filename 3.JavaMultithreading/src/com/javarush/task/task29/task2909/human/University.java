package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {

    protected int age;
    protected String name;
    private List<Student> students = new ArrayList<>();


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        for (int i=0; i<students.size(); i++) {
            if (students.get(i).getAverageGrade() == averageGrade) {
                return students.get(i);
            }
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxGrade = null;
        for (int i=0; i<students.size(); i++) {

            if (
                    studentWithMaxGrade == null
                    || students.get(i).getAverageGrade() > studentWithMaxGrade.getAverageGrade()
            ) {
                studentWithMaxGrade = students.get(i);
            }

        }

        return studentWithMaxGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMinGrade = null;
        for (int i=0; i<students.size(); i++) {

            if (
                    studentWithMinGrade == null
                            || students.get(i).getAverageGrade() < studentWithMinGrade.getAverageGrade()
            ) {
                studentWithMinGrade = students.get(i);
            }

        }

        return studentWithMinGrade;

    }

    public void expel(Student student)
    {
        students.remove(student);
    }
}