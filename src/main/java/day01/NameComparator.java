package day01;

import java.util.Comparator;

public class NameComparator implements Comparator<StudentComparable> {

    @Override
    public int compare(StudentComparable o1, StudentComparable o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
