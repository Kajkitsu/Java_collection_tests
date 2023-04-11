package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void testQueueConstructor() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //expect
        assertEquals(0, queue.size());
    }

    @Test
    void testQueueAddMethod() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //then
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    void testQueueRemoveMethod() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        //then
        assertEquals(2, queue.size());
        assertEquals(2, queue.peek());
    }

    @Test
    void testQueuePollMethod() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.poll();
        //then
        assertEquals(1, result);
        assertEquals(2, queue.size());
        assertEquals(2, queue.peek());
    }

    @Test
    void testQueuePeekMethod() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.peek();
        //then
        assertEquals(1, result);
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    void testQueueElementMethod() {
        //given
        Queue<Integer> queue = new ArrayDeque<>();
        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Integer result = queue.element();
        //then
        assertEquals(1, result);
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }


}
