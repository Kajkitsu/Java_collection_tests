package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SetTest {
    @Test
    void testSetConstructor() {
        //given
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        //expect
        assertEquals(3, set.size());
    }

    @Test
    void testSetAddMethod() {
        //given
        Set<Integer> set = new HashSet<>();
        //when
        set.add(1);
        set.add(2);
        set.add(3);
        //then
        assertEquals(3, set.size());
    }

    @Test
    void testSetRemoveMethod() {
        //given
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        //when
        set.remove(1);
        //then
        assertEquals(2, set.size());
    }

    @Test
    void testSetContainsMethod() {
        //given
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        //when
        boolean contains = set.contains(1);
        //then
        assertTrue(contains);
    }

    @Test
    void testSetClearMethod() {
        //given
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        //when
        set.clear();
        //then
        assertEquals(0, set.size());
    }

    @Test
    void testSetIsEmptyMethod() {
        //given
        Set<Integer> set = new HashSet<>();
        //expect
        assertTrue(set.isEmpty());
    }

    @Test
    void testAddExistingValue() {
        //given
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        //when
        boolean result = set.add(1);
        //expect
        assertEquals(3, set.size());
        assertFalse(result);
    }



}
