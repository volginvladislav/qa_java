package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFamilyShouldReturnCorrectText() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
    @Test(expected = Exception.class)
    public void getFoodInvalidAnimalKindShouldReturnExepton() throws Exception {
        new Animal().getFood("Всеядное");
    }
    @Test
    public void catchExceptionWhenFelineHasInvalidAnimalKind() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Всеядное"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}