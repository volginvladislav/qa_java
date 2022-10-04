package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void getFamilyShouldReturnFelineType() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void getKittensShouldReturnGetKittensWhoTakesOne() {
        Feline feline = new Feline();
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }

    @Test
    public void GetKittensShouldReturnWhatItTakes() {
        Feline feline = new Feline();
        int expected = 1;
        int setKittensCount = 1;
        assertEquals(expected, feline.getKittens(setKittensCount));
    }
    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыбы");
        assertEquals("Еда не соответствует хищникам",predatorFood, feline.eatMeat());

    }
}