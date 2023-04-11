package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class IncorrectHashImplTest {

    class CorruptedKey {
        protected int value;

        public CorruptedKey(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Test
    void testUseIncorrectHashInHashMap() {
        //given
        Map<CorruptedKey, String> map = new HashMap<>();
        map.put(new CorruptedKey(1), "1");
        map.put(new CorruptedKey(2), "2");
        map.put(new CorruptedKey(3), "3");
        //when
        map.remove(new CorruptedKey(1));
        map.remove(new CorruptedKey(2));
        map.remove(new CorruptedKey(3));
        //then
        assertEquals(3, map.size());
        assertNull(map.get(new CorruptedKey(1)));
        assertNull(map.get(new CorruptedKey(2)));
        assertNull(map.get(new CorruptedKey(3)));
    }

    @Test
    void testUseIncorrectHashWithoutComparableInTreeMap() {
        //given
        Map<CorruptedKey, String> map = new TreeMap<>();
        //expect
        assertThrows(ClassCastException.class, () -> {
            map.put(new CorruptedKey(1), "1");
        });
    }

    class SecondCorruptedKey extends CorruptedKey implements Comparable<SecondCorruptedKey> {
        public SecondCorruptedKey(int value) {
            super(value);
        }

        @Override
        public int compareTo(SecondCorruptedKey o) {
            return o.value - this.value;
        }
    }

    @Test
    void testUseIncorrectHashWithComparableInTreeMap() {
        //given
        Map<SecondCorruptedKey, String> map = new TreeMap<>();
        map.put(new SecondCorruptedKey(1), "1");
        map.put(new SecondCorruptedKey(2), "2");
        map.put(new SecondCorruptedKey(3), "3");
        //when
        map.remove(new SecondCorruptedKey(1));
        //then
        assertEquals(2, map.size());
        assertNull(map.get(new SecondCorruptedKey(1)));
        assertEquals("2", map.get(new SecondCorruptedKey(2)));
        assertEquals("3", map.get(new SecondCorruptedKey(3)));
    }



}
