package day01;

import java.util.*;

public class ClassNoteBookComparable {

    private Map<StudentComparable, List<Integer>> students = new TreeMap<>(new NameComparator());


    public void addStudent(StudentComparable student) {
        students.put(student, new ArrayList<>());
    }

    public void addMark(String id, int mark) {
        for (Map.Entry<StudentComparable, List<Integer>> actual : students.entrySet()) {
        //for (Map.Entry actual : students.entrySet()) {
            if (actual.getKey().getId().equals(id)) {
                actual.getValue().add(mark);
            }
        }
    }

    public static void main(String[] args) {
        ClassNoteBookComparable studentComparable = new ClassNoteBookComparable();
        studentComparable.addStudent(new StudentComparable("12345", "Zoli5"));
        studentComparable.addStudent(new StudentComparable("123456", "peti 6"));
        studentComparable.addStudent(new StudentComparable("1234567", "Ánna  7"));
        studentComparable.addStudent(new StudentComparable("12345678", "Virág  8"));
        studentComparable.addMark("123456", 4);
        studentComparable.addMark("123456", 3);
        studentComparable.addMark("123456", 5);
        studentComparable.addMark("12345678", 2);
        studentComparable.addMark("12345678", 5);
        studentComparable.addMark("12345678", 4);

        System.out.println(studentComparable.students);
        /*Collections.sort(studentComparable.students, new Comparator<StudentComparable>() {
            @Override
            public int compare(StudentComparable o1, StudentComparable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/
    }
}
