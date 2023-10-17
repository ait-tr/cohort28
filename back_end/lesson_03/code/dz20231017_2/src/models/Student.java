package models;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Student {
    private String name;
    private List<Double> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public void addGrade(double grade){
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return new ArrayList<Double>(grades);
    }

    public Double getAverageGrade(){
        return grades.stream().mapToDouble(g -> g.doubleValue()).average().getAsDouble();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
