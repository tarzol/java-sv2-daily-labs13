package day04;

import java.util.Map;
import java.util.TreeMap;

public class FindVowels24 {

    public Map<Character, Integer> findAndCountVowels(String word) {
        Map<Character, Integer> result = new TreeMap<>();
        String arrayOfVowels = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (Character actual : word.toCharArray()) {
            if ( arrayOfVowels.contains(actual.toString()) || arrayOfVowels.toUpperCase().contains(actual.toString()) ) {
                sb.append(actual);
            }
        }
        return writeInMap(sb.toString());
    }

    private Map<Character, Integer> writeInMap(String word) {
        Map<Character, Integer> result = new TreeMap<>();
        for (Character actual : word.toLowerCase().toCharArray()) {
            if (result.containsKey(actual))  {
                result.put(actual, result.get(actual)+1);
            } else {
                result.put(actual, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindVowels24 findVowels = new FindVowels24();
        System.out.println(findVowels.findAndCountVowels("AappletreE"));
    }
}
