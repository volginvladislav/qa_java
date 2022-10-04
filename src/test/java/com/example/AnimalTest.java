package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFamilyShouldReturnСorrectText() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
    @Test
    public void catchExceptionWhenFelineHasInvalidAnimalKind() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Падальщик"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}