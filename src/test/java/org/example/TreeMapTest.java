package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class TreeMapTest {

    @Test
    void testTreeMapConstructor() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //expect
        assertEquals(0, map.size());
    }

    @Test
    void testTreeMapPutMethod() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        //then
        assertEquals(3, map.size());
        assertEquals("🥦", map.get("b"));
        assertEquals("🍎", map.get("a"));
        assertEquals("🥔", map.get("p"));
    }

    @Test
    void testTreeMapRemoveMethod() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        map.remove("b");
        //then
        assertEquals(2, map.size());
        assertEquals("🍎", map.get("a"));
        assertEquals("🥔", map.get("p"));
    }

    @Test
    void testTreeMapContainsKeyMethod() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        //then
        assertTrue(map.containsKey("b"));
        assertTrue(map.containsKey("a"));
        assertTrue(map.containsKey("p"));
        assertFalse(map.containsKey("e"));
    }

    @Test
    void testTreeMapContainsValueMethod() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        //then
        assertTrue(map.containsValue("🥦"));
        assertTrue(map.containsValue("🍎"));
        assertTrue(map.containsValue("🥔"));
        assertFalse(map.containsValue("🍑"));
    }

    @Test
    void testTreeMapClearMethod() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        map.clear();
        //then
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    void testPutWithExistingKey() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        map.put("a", "🥑");
        //then
        assertEquals(3, map.size());
        assertEquals("🥦", map.get("b"));
        assertEquals("🥑", map.get("a"));
        assertEquals("🥔", map.get("p"));
    }

    @Test
    void testGetNotPresentKey() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        //then
        assertNull(map.get("e"));
    }

    @Test
    void testGetOrDefaultElse() {
        //given
        TreeMap<String, String> map = new TreeMap<>();
        //when
        map.put("b", "🥦");
        map.put("a", "🍎");
        map.put("p", "🥔");
        //then
        assertEquals("🥦", map.getOrDefault("b", "🍒"));
        assertEquals("🍎", map.getOrDefault("a", "🍒"));
        assertEquals("🥔", map.getOrDefault("p", "🍒"));
        assertEquals("🍒", map.getOrDefault("c", "🍒"));
    }
}
