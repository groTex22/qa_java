package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/*В этом тестовом классе замокали класс Feline
* Возможно в контексте этого кода и не совсем нужно, но для тренировки*/
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat cat;
    @Mock
    Feline feline;

    @Before
    public void beforeTest() {
        cat = new Cat(feline);
    }
    //Будем проверять как говорит котик
    @Test
    public void getSoundReturnCatSound(){
        Assert.assertEquals("Мяу", cat.getSound());
    }


    //Так же проверим, что он кушает
    @Test
    public void getFoodEatMeat() throws Exception{

        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedResult);
        Assert.assertEquals(expectedResult, cat.getFood());
    }

}
