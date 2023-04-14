package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ListTest {
    private static Collection<Integer> bigCollection;

    @BeforeAll
    public static void init() {
        bigCollection = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            bigCollection.add(i);
        }
    }

    private Double speedTest(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000_000.0;
    }

    @Test
    void testAddLastElement() {
        //given
        ArrayList<Integer> arrayList = new ArrayList<>(bigCollection);
        LinkedList<Integer> linkedList = new LinkedList<>(bigCollection);
        //when
        Double arrayListTime = speedTest(() -> arrayList.add(arrayList.size()/2, 1));
        Double linkedListTime = speedTest(() -> linkedList.add(linkedList.size()/2, 1));
        //then
        System.out.println("ArrayList add last element time: " + arrayListTime);
        System.out.println("LinkedList add last element time: " + linkedListTime);
        assertTrue(arrayListTime < linkedListTime);
    }

    @Test
    void testRemoveFirstElement() {
        //given
        ArrayList<Integer> arrayList = new ArrayList<>(bigCollection);
        LinkedList<Integer> linkedList = new LinkedList<>(bigCollection);
        //when
        Double arrayListTime = speedTest(() -> arrayList.remove(0));
        Double linkedListTime = speedTest(() -> linkedList.remove(0));
        //then
        System.out.println("ArrayList remove first element time: " + arrayListTime);
        System.out.println("LinkedList remove first element time: " + linkedListTime);
        assertTrue(arrayListTime > linkedListTime);
    }

    @Test
    void testRemoveLastElement() {
        //given
        ArrayList<Integer> arrayList = new ArrayList<>(bigCollection);
        LinkedList<Integer> linkedList = new LinkedList<>(bigCollection);
        //when
        Double arrayListTime = speedTest(() -> arrayList.remove(arrayList.size()/2));
        Double linkedListTime = speedTest(() -> linkedList.remove(linkedList.size()/2));
        //then
        System.out.println("ArrayList remove last element time: " + arrayListTime);
        System.out.println("LinkedList remove last element time: " + linkedListTime);
        assertTrue(arrayListTime < linkedListTime);
    }

    @Test
    void testGetMiddleElement() {
        //given
        ArrayList<Integer> arrayList = new ArrayList<>(bigCollection);
        LinkedList<Integer> linkedList = new LinkedList<>(bigCollection);
        //when
        Double arrayListTime = speedTest(() -> arrayList.get(arrayList.size() / 2));
        Double linkedListTime = speedTest(() -> linkedList.get(linkedList.size() / 2));
        //then
        System.out.println("ArrayList get middle element time: " + arrayListTime);
        System.out.println("LinkedList get middle element time: " + linkedListTime);
        assertTrue(arrayListTime < linkedListTime);
    }
}
