package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        String catSound = "Мяу";
        assertEquals("Кошка должна говорить Мяу", catSound, cat.getSound());
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(cat.predator.eatMeat()).thenReturn(expectedFood);
        List<String> actual = cat.getFood();
        assertEquals("Коты питаются животными, птицами и рыбой",expectedFood, actual);
    }

}