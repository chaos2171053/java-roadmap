package org.example.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupAnagramsTest {
    @Test
    public void testGroupAnagrams_Example1() {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("bat"));
        expected.add(Arrays.asList("nat", "tan"));
        expected.add(Arrays.asList("ate", "eat", "tea"));

        List<List<String>> result = solution.groupAnagrams(strs);

        // 对期望和实际结果中的每个列表进行排序
        expected.forEach(Collections::sort);
        result.forEach(Collections::sort);

        // 断言排序后的结果
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGroupAnagrams_EmptyString() {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {""};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(""));

        List<List<String>> result = solution.groupAnagrams(strs);

        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGroupAnagrams_SingleCharacter() {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {"a"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("a"));

        List<List<String>> result = solution.groupAnagrams(strs);

        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }
}
