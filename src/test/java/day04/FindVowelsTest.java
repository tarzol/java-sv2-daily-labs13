package day04;

import day01.MainPractice;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindVowelsTest {

    @Test
    void testFindVowels() {
        FindVowels findVowels = new FindVowels();

        Map<Character, Integer> result = findVowels.insertAndCountInMap("appletree");
        assertEquals(1, result.get('a'));
        assertEquals(3, result.get('e'));
    }
}