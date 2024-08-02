package com.example;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;


public class TestLion  {
    Feline feline = new Feline();
    Lion lion ;


    //Создаем объект класса Lion и инициируем мок перед тестом
    @Before
    public void beforeTest() throws Exception {
        lion = new Lion("Самец",feline);
    }




    //Проверяем создание объекта с несуществуещем полом животного
    //перехватываем ошибку не с помощью аннотации, а с помощью try catch
    //чтобы сравнить текст ошибки
    @Test
    public void createLionWrongParemetr() {
        String lerror = "Используйте допустимые значения пола животного - самей или самка";
        try {
        lion = new Lion("Пацан",feline);
        //А вдруг создасться, поэтому пишем ниже fail, чтобы исключить ложную отработку
        Assert.fail("Лев не должен был быть создан. Если создали, то ай яй яй");
        } catch (Exception exception) {
            //Сверим текст исключения с ожидаемым
            MatcherAssert.assertThat(exception.getMessage(), containsString(lerror));
        }
    }

    //В этом тесте проверим сколько возвращается 1 экземпляр льва
    @Test
    public void getKittensReturnOneKittens() {
        Assert.assertEquals(1, lion.getKittens());
    }

    //Проверим что кушает лев
    @Test
    public void getFoodPredatorreturnMeat() throws Exception {
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedResult, lion.getFood());
    }

    //Проверим, что если лев самец, то вернется true
    @Test
    public void doesHaveManeMaleHasManeTrue() {
        Assert.assertTrue("Получаем TRUE, если лев самец", lion.doesHaveMane());
    }

    //Проверим, что если лев самка, то вернется false
    @Test
    public void doesHaveManeFemaleHasManeFalse() throws Exception {
        lion = new Lion("Самка",feline);
        Assert.assertFalse("Получаем False, если это львица", lion.doesHaveMane());
    }
}
