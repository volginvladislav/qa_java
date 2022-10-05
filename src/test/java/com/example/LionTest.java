package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    private final String SEX;
    private final boolean MANE_HAVE;

    public LionTest(String gender, Boolean mane_have) {
        this.SEX = gender;
        this.MANE_HAVE = mane_have;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            };
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    @Test
    public void checkDoesLionHasMane() throws Exception {
        Lion lion = new Lion(SEX, feline);
        assertEquals(MANE_HAVE, lion.doesHaveMane());
    }

    @Test
    public void getKittensShouldReturnOneAmount() throws Exception {
        Lion lion = new Lion(SEX, feline);
        int numberOfKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(numberOfKittens, lion.getKittens());
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion lion = new Lion(SEX, feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыбы");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals("Еда не соответствует хищникам", expectedFood,actualFood);

    }
    @Test
    public void catchExceptionWhenLionHasInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Падальщик", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());

    }
}