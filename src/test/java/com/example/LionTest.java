package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {



    @Test
    public void hasManeLion () throws Exception {
        Lion lion = null;
        try {
            lion = new Lion("Самец", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        boolean actual = lion.hasMane;
        Assert.assertEquals(true,actual);
    }
    @Test
    public void notManeLion () throws Exception {
        Lion lion = null;
        try {
            lion = new Lion("Самка", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        boolean actual = lion.hasMane;
        Assert.assertEquals(false,actual);
    }
    @Test (expected = Exception.class)
    public void notValidSexLion () throws Exception {
       Lion lion = new Lion("Лошадь", feline);

    }
    @Mock
   private Feline feline;
    @Test
    public void getKittensLion () throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        Assert.assertEquals(1, actualKittens);
    }
    @Test
    public void doesHaveManeTrue () throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(true, actual);

    }
    @Test
    public void doesHaveManeFalse () throws Exception {
            Lion lion = new Lion("Самка", feline);
       boolean actual = lion.doesHaveMane();
        Assert.assertEquals(false, actual);

    }
       @Test

        public void getFoodTest () throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual= lion.getFood();
        Assert.assertThat(actual, is(List.of("Животные", "Птицы", "Рыба")));
    }

}
