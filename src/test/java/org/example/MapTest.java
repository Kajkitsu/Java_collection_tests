package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.TreeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapTest {
    private HashMap<Integer, String> hashMap;
    private TreeMap<Integer, String> treeMap;

    @BeforeEach
    public void init() {
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i, Integer.valueOf(i).toString());
            treeMap.put(i, Integer.valueOf(i).toString());
        }
    }

    private Double speedTest(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000_000.0;
    }

    @Test
    void testGetElement() {
        //given
        //when
        Double treeMapTime = speedTest(() -> treeMap.get(50_000));
        Double hashMapTime = speedTest(() -> hashMap.get(50_000));
        //then
        System.out.println("HashMap get element time: " + treeMapTime);
        System.out.println("TreeMap get element time: " + hashMapTime);
        assertTrue(treeMapTime > hashMapTime);
    }

    @Test
    void testPutElement() {
        //given
        //when
        Double treeMapTime = speedTest(() -> treeMap.put(50_000, "420"));
        Double hashMapTime = speedTest(() -> hashMap.put(50_000, "420"));
        //then
        System.out.println("HashMap put element time: " + treeMapTime);
        System.out.println("TreeMap put element time: " + hashMapTime);
        assertTrue(treeMapTime > hashMapTime);
    }

    @Test
    void testRemoveElement() {
        //given
        //when
        Double treeMapTime = speedTest(() -> treeMap.remove(50_000));
        Double hashMapTime = speedTest(() -> hashMap.remove(50_000));
        //then
        System.out.println("HashMap remove element time: " + treeMapTime);
        System.out.println("TreeMap remove element time: " + hashMapTime);
        assertTrue(treeMapTime > hashMapTime);
    }

}
