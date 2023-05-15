package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class OptionalTest {

    //isPresent() - zwraca informację logiczną, czy dany Optional zawiera
    //referencję na istniejący obiekt,
    @Test
    void testIsPresent() {
        var optional = Optional.of("I am not null!");
        assertTrue(optional.isPresent());
    }

    //isEmpty() - - zwraca informację logiczną, czy dany Optional jest pusty,
    @Test
    void testIsEmpty() {
        var optional = Optional.empty();
        assertTrue(optional.isEmpty());
    }

    //map(Function<T, U>) - zwraca obiekt Optional zawierający wynik
    //wywołania przekazanej jako argument funkcji na obiekcie typu T, jeśli
    //obiekt Optional zawiera referencję na obiekt typu T, w przeciwnym wypadku
    //zwraca pusty obiekt Optional,
    @Test
    void testMap() {
        var optional = Optional.of("I am a string!");
        var mappedOptional = optional.map(String::length);
        assertTrue(mappedOptional.isPresent());
        assertEquals(14, mappedOptional.get());
    }

    //Optional.ofNullable(T) - zwraca obiekt Optional, który może być
    //pusty w zależności od przekazanej referencji.
    @Test
    void testOfNullable() {
        var optional = Optional.ofNullable(null);
        assertTrue(optional.isEmpty());
    }

    // Optional.of(T) - zwraca obiekt Optional zawierający przekazaną
    //referencję na obiekt typu T, referencja obj nie może wskazywać na null,
    @Test
    void testOf() {
        var optional = Optional.of(2);
        assertTrue(optional.isPresent());
    }

    //W przypadku gdy Optional.ofNullable(T) otrzyma null jako argument,
    //zostanie zwrócony pusty obiekt Optional. W przypadku gdy Optional.of(T)
    //otrzyma null jako argument, zostanie rzucony wyjątek NullPointerException.
    @Test
    void testThrowExceptionWhenCreatingOptionalOfNull() {
        assertThrows(NullPointerException.class, () -> Optional.of(null));
    }

    //get() - zwraca referencję na obiekt typu T, jeśli obiekt Optional
    //zawiera referencję na obiekt typu T, w przeciwnym wypadku rzuca wyjątek
    //NoSuchElementException.
    //isPresent() - zwraca informację logiczną, czy dany Optional zawiera
    //referencję na istniejący obiekt,
    @Test
    void testGet() {
        var optional = Optional.of("I am a string!");
        optional.ifPresent(System.out::println); //check console output
        String value = optional.get();
        assertEquals("I am a string!", value);
    }

    //orElse(T) - zwraca referencję na obiekt typu T, jeśli obiekt Optional
    //zawiera referencję na obiekt typu T, w przeciwnym wypadku zwraca
    //wartość przekazaną jako argument.
    @Test
    void testOrElse() {
        Optional<String> optional = Optional.empty();
        String value = optional.orElse("I am present!");
        assertEquals("I am present!", value);
    }

    //orElseGet(Supplier<T>) - zwraca referencję na obiekt typu T, jeśli
    //obiekt Optional zawiera referencję na obiekt typu T, w przeciwnym wypadku
    //zwraca wartość zwróconą przez przekazany jako argument obiekt typu
    //Supplier<T>.
    @Test
    void testOrElseGet() {
        Optional<String> optional = Optional.empty();
        String value = optional.orElseGet(() -> "I am present!");
        assertEquals("I am present!", value);
    }

    //orElseThrow(Supplier<X extends Throwable>) - zwraca referencję na
    //obiekt typu T, jeśli obiekt Optional zawiera referencję na obiekt typu T,
    //w przeciwnym wypadku rzuca wyjątek typu X zwrócony przez przekazany
    //jako argument obiekt typu Supplier<X extends Throwable>.
    @Test
    void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        assertThrows(IllegalArgumentException.class, () -> optional.orElseThrow(IllegalArgumentException::new));
    }


}
