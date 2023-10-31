package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_DTest {

    @Test
    public void test() {

        String[] expected;
        String[] result;
        String[] input;


        input = new String[]{"вышивание крестиком"
                , "рисование мелками на парте"
                , "настольный керлинг"
                , "настольный керлинг"
                , "кухня африканского племени ужасмай"
                , "тяжелая атлетика"
                , "таракановедение"
                , "таракановедение"};
        result = Task_D.process(8,input);
        expected = new String[]{"вышивание крестиком"
                , "рисование мелками на парте"
                , "настольный керлинг"
                , "кухня африканского племени ужасмай"
                , "тяжелая атлетика"
                , "таракановедение"};
        assertArrayEquals(expected, result);

    }

}