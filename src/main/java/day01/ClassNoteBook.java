package day01;

import java.util.*;

public class ClassNoteBook {

    Map<Student, List<Integer>> studentList = new TreeMap<>(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId() - o2.getId();
        }
    });

    public void addStudent(Student student) {
        studentList.put(student, new ArrayList<>());
    }

    public boolean addMark(int id, int mark) {
        for (Map.Entry<Student, List<Integer>> actual : studentList.entrySet()) {
            if ( actual.getKey().getId() == id ) {
                //put( actual.getValue()
                actual.getValue().add(mark);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ClassNoteBook noteBook = new ClassNoteBook();
        noteBook.addStudent(new Student(3, "3Zoli"));

        noteBook.addStudent(new Student(2, "2Zoli"));
        noteBook.addStudent(new Student(5, "5Zoli"));
        noteBook.addStudent(new Student(1, "1Zoli"));

        noteBook.addMark(3, 5);
        noteBook.addMark(3, 2);
        noteBook.addMark(2, 1);
        noteBook.addMark(2, 5);
        //System.out.println(noteBook.studentList);
    }
}
