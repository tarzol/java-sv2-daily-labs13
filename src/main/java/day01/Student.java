package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    @Override
    public int compareTo(Student o) {
        return this.id -o.id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'+"\n";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
