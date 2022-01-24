package day01;

import java.util.List;

public class StudentComparable implements Comparable<StudentComparable>{

    private String id;
    private String name;
    //private List<Integer> marks;

    public StudentComparable(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(StudentComparable o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "StudentComparable{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /*public List<Integer> getMarks() {
        return marks;
    }*/

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
