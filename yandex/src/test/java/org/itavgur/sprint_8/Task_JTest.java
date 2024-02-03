package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.itavgur.sprint_8.Task_J.camelCase;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_JTest {

    @Test
    public void test1() {

        String[] expected;
        String[] result;

        String[] classes = new String[]{"MamaMilaRamu", "MamaMia", "MonAmi"};
        String[] requests = new String[]{"MM", "MA"};
        expected = new String[]{"MamaMia", "MamaMilaRamu", "MonAmi"};
        result = camelCase(3, classes, 2, requests);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {

        String[] expected;
        String[] result;

        String[] classes = new String[]{"AlphaBetaGgamma", "AbcdBcdGggg"};
        String[] requests = new String[]{"ABGG", "ABG"};
        expected = new String[]{"AbcdBcdGggg", "AlphaBetaGgamma"};
        result = camelCase(2, classes, 2, requests);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {

        String[] expected;
        String[] result;

        String[] classes = new String[]{"WudHnagkbhfwrbci", "WCUkvoxboxufsdap", "jdrxomezzrpuhbgi", "ZcGHdrPplfoldemu", "cylbtqwuxhiveznc"};
        String[] requests = new String[]{"WGHV", "NKVDT", "ZGHU"};
        expected = new String[0];
        result = camelCase(3, classes, 2, requests);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test4() {

        String[] expected;
        String[] result;

        String[] classes = new String[]{"Pxibjagrlhlwaytc", "PymhxsgyavebrAnk", "DtnwtwVmbcBmipjp",
                "fxclcvxsxuetwztm", "DuVgkudcqotsyemx"};
        String[] requests = new String[]{"DARK", "", "NQAI"};
        expected = new String[]{"DtnwtwVmbcBmipjp", "DuVgkudcqotsyemx", "Pxibjagrlhlwaytc", "PymhxsgyavebrAnk", "fxclcvxsxuetwztm"};
        result = camelCase(5, classes, 3, requests);
        assertArrayEquals(expected, result);
    }


}