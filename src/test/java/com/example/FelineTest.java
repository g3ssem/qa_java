package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    @Test
    public void eatMeatTest () throws Exception {
        Feline feline = new Feline();
        List<String> actual= feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getFamilyTest () {
        Feline feline = new Feline();
        String actual  = feline.getFamily();
        String expected = ("Кошачьи");
        Assert.assertEquals(actual,expected);
    }
    @Parameterized.Parameter
    public int countKittens;
    @Parameterized.Parameter(1)
    public int expectedResult;
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {5, 5}
        };
    }
    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int actual;
        if (countKittens==0) {
         actual = feline.getKittens();}
        else {actual = feline.getKittens(countKittens);}
         Assert.assertEquals(actual,expectedResult);
    }

}
