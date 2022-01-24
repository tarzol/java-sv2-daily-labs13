package day04;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FindVowels {

    private Map<Character, Integer> vowelsInMap = new TreeMap<>();
    public static final String VOWELS = "aeiou";

    public Map<Character, Integer> insertAndCountInMap(String word) {
        String filteredWord = filterVowels(word);
        for (Character actual : filteredWord.toCharArray()) {
            if (vowelsInMap.containsKey(actual)) {
                vowelsInMap.put(actual, vowelsInMap.get(actual)+1);
                //System.out.println(vowelsInMap);
            } else {
                vowelsInMap.put(actual, 1);
            }
        }
        return vowelsInMap;
    }



    private String filterVowels(String word) {

        StringBuilder filteredWord = new StringBuilder();
        for (Character actual : word.toCharArray()) {
            if ( VOWELS.contains(actual.toString())) {
                filteredWord.append(actual);
            }
        }
        return filteredWord.toString();
    }

    public static void main(String[] args) {
        FindVowels findVowels = new FindVowels();
        System.out.println(findVowels.insertAndCountInMap("appletree-oboa"));
    }
}
