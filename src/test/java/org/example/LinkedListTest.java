package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void testLinkedListConstructor() {
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        //expect
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testArrayAddMethod() {
        //given
        List<Integer> list = new LinkedList<>();
        //when
        list.add(1);
        list.add(2);
        list.add(3);
        //then
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void throwExceptionWhileAccessingNotPresentValue() {
        //given
        List<Integer> list = new LinkedList<>();
        //when
        list.add(1);
        list.add(2);
        list.add(3);
        //then
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void testArrayRemoveMethod() {
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        //when
        list.remove(1);
        //then
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testExceptionWhileRemoveNotPresentIndex() {
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        //expect
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    void testArrayRemoveMethodWithObject() {
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        //when
        boolean result = list.remove(Integer.valueOf(2));
        //then
        assertTrue(result);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testArrayRemoveMethodWithObjectNotPresent() {
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        //when
        boolean result = list.remove(Integer.valueOf(4));
        //then
        assertFalse(result);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }


}