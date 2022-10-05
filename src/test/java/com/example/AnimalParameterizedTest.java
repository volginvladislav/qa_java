package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String EAT_TYPE;
    private final List<String> FOOD_TYPE_LIST;

    public AnimalParameterizedTest(String eat_type, List<String> food_type_list) {
        this.EAT_TYPE = eat_type;
        this.FOOD_TYPE_LIST = food_type_list;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыбы")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };

    }

    @Test
    public void eatMeat() throws Exception {
        Animal animal = new Animal();
        assertEquals("Еда не соответствует данному типу животных",FOOD_TYPE_LIST, animal.getFood(EAT_TYPE));
    }
}