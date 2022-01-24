package day01;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<StudentComparable> {

    @Override
    public int compare(StudentComparable o1, StudentComparable o2) {
        return o1.getName().length()-o2.getName().length();
    }
}
