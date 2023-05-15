package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StreamTest {

    //filter(Predicate<? super T> predicate) - odfiltrowuje elementy w strumieniu
    //na podstawie przekazanego predykatu, zwraca strumień
    @Test
    void testFilter() {
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.println(num + " ")); // 2 4 6

        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .filter(num -> num % 2 == 0)
                        .collect(Collectors.toList());

        assertEquals(List.of(2, 4, 6), list);
    }

    //map(Function<? super T, ? extends R> mapper) - przekształca elementy w strumieniu
    //za pomocą przekazanej funkcji, zwraca strumień
    @Test
    void testMap() {
        List<Integer> list =
                Stream.of(1, 2, 3)
                        .map(num -> num * 2)
                        .collect(Collectors.toList());

        assertEquals(List.of(2, 4, 6), list);
    }


    //limit(long maxSize) - ogranicza liczbę elementów w strumieniu do podanej wartości,
    //zwraca strumień
    @Test
    void testLimit() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .limit(3)
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3), list);
    }

    //skip(long n) - pomija n pierwszych elementów w strumieniu, zwraca strumień
    @Test
    void testSkip() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .skip(3)
                        .collect(Collectors.toList());

        assertEquals(List.of(4, 5, 6), list);
    }

    //distinct() - usuwa duplikaty z strumienia, zwraca strumień
    @Test
    void testDistinct() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6, 1, 2, 3)
                        .distinct()
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3, 4, 5, 6), list);
    }

    //flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) - spłaszcza strumień
    //zagnieżdżonych strumieni do jednego strumienia, zwraca strumień
    @Test
    void testFlatMap() {
        List<Integer> list =
                Stream.of(List.of(1, 2), List.of(3, 4))
                        .flatMap(listOfNums -> listOfNums.stream())
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3, 4), list);
    }

    //sorted() - sortuje elementy w strumieniu, zwraca strumień
    @Test
    void testSorted() {
        List<Integer> list =
                Stream.of(3, 2, 1, 4, 5, 6)
                        .sorted()
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3, 4, 5, 6), list);
    }

    //peek(Consumer<? super T> action) - wykonuje akcję na każdym elemencie strumienia,
    //zwraca strumień
    @Test
    void testPeek() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .peek(num -> System.out.println(num))
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3, 4, 5, 6), list);
    }

    //takeWhile(Predicate<? super T> predicate) - zwraca elementy strumienia dopóki
    //predykat jest spełniony, zwraca strumień
    @Test
    void testTakeWhile() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .takeWhile(num -> num < 4)
                        .collect(Collectors.toList());

        assertEquals(List.of(1, 2, 3), list);
    }

    //Operacje Terminujące

    //count() - zwraca liczbę elementów w strumieniu
    @Test
    void testCount() {
        long count =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .count();

        assertEquals(6, count);
    }

    //min(Comparator<? super T> comparator) - zwraca najmniejszy element w strumieniu
    @Test
    void testMin() {
        int min =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .min(Integer::compareTo)
                        .get();

        assertEquals(1, min);
    }

    //max(Comparator<? super T> comparator) - zwraca największy element w strumieniu
    @Test
    void testMax() {
        int max =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .max(Integer::compareTo)
                        .get();

        assertEquals(6, max);
    }

    //findAny() - zwraca dowolny element ze strumienia, lub Optional.empty() jeśli strumień jest pusty
    @Test
    void testFindAny() {
        int any =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .findAny()
                        .get();

        assertEquals(1, any);
    }

    //findFirst() - zwraca pierwszy element ze strumienia, lub Optional.empty() jeśli strumień jest pusty
    @Test
    void testFindFirst() {
        int first =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .findFirst()
                        .get();

        assertEquals(1, first);
    }

    //allMatch(Predicate<? super T> predicate) - zwraca true jeśli wszystkie elementy spełniają predykat
    @Test
    void testAllMatch() {
        boolean allMatch =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .allMatch(num -> num < 10);

        assertTrue(allMatch);
    }

    //anyMatch(Predicate<? super T> predicate) - zwraca true jeśli którykolwiek element spełnia predykat
    @Test
    void testAnyMatch() {
        boolean anyMatch =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .anyMatch(num -> num == 3);

        assertTrue(anyMatch);
    }

    //noneMatch(Predicate<? super T> predicate) - zwraca true jeśli żaden element nie spełnia predykatu
    @Test
    void testNoneMatch() {
        boolean noneMatch =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .noneMatch(num -> num == 7);

        assertTrue(noneMatch);
    }

    //toList(), toSet(), toArray() - tworzy wynikową listę, zbiór, lub tablicę z
    //elementów wchodzących w stan strumienia.
    @Test
    void testToList() {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .toList();

        assertEquals(List.of(1, 2, 3, 4, 5, 6), list);
    }

    //forEach(Consumer<? super T> action) -dla każdego elementu
    //wchodzącego w skład strumienia wykonuje akcję zdefiniową przez lambdę
    //typu Consumer,
    @Test
    void testForEach() {
        List<Integer> list = new ArrayList<>();

        Stream.of(1, 2, 3, 4, 5, 6)
                .forEach(num -> list.add(num));

        assertEquals(List.of(1, 2, 3, 4, 5, 6), list);
    }

    //reduce(BinaryOperator<T> accumulator) - redukuje elementy strumienia do jednego
    //elementu, zwraca Optional
    @Test
    void testReduce() {
        int sum =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .reduce((num1, num2) -> num1 + num2)
                        .get();

        assertEquals(21, sum);
    }

    //reduce(T identity, BinaryOperator<T> accumulator) - redukuje elementy strumienia do jednego
    //elementu, zwraca Optional
    @Test
    void testReduce2() {
        int sum =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .reduce(0, (num1, num2) -> num1 + num2);

        assertEquals(21, sum);
    }

    //collect(Collector<? super T, A, R> collector) - zbiera elementy strumienia do kolektora
    //zdefiniowanego przez użytkownika
    @Test
    void testCollect() {
        Set<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.toSet());

        assertEquals(Set.of(1, 2, 3, 4, 5, 6), list);
    }

    //collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
    //- zbiera elementy strumienia do kolektora zdefiniowanego przez użytkownika
    @Test
    void testCollect2() {
        Set<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(HashSet::new, HashSet::add, HashSet::addAll);

        assertEquals(Set.of(1, 2, 3, 4, 5, 6), list);
    }

    //joinning() - łączy elementy strumienia w jeden String
    @Test
    void testJoining() {
        String str =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .map(String::valueOf)
                        .collect(Collectors.joining());

        assertEquals("123456", str);
    }

    //joinning(CharSequence delimiter) - łączy elementy strumienia w jeden String
    @Test
    void testJoining2() {
        String str =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

        assertEquals("1, 2, 3, 4, 5, 6", str);
    }

    //groupingBy(Function<? super T, ? extends K> classifier) - grupuje elementy strumienia`
    //według klucza zwracanego przez funkcję
    @Test
    void testGroupingBy() {
        Map<Integer, List<Integer>> map =
                Stream.of(1, 2, 3, 4, 5, 6)
                        .collect(Collectors.groupingBy(num -> num % 2));

        assertEquals(Map.of(0, List.of(2, 4, 6), 1, List.of(1, 3, 5)), map);
    }

    //groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
    //- grupuje elementy strumienia według klucza zwracanego przez funkcję, a następnie
    //zbiera elementy do kolektora zdefiniowanego przez użytkownika
    @Test
    void testGroupingBy2() {
        Map<Integer, Long> map =
                Stream.of(1, 2, 3, 4, 5, 6, 7)
                        .collect(Collectors.groupingBy(num -> num % 2, Collectors.counting()));

        assertEquals(map.get(0), 3L);
        assertEquals(map.get(1), 4L);
    }
}
