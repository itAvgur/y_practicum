package org.itavgur.sprint_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Final_ATest {

    @Test
    public void test1() {
        String[] result;
        String[] input;
        String[] expected;

        input = new String[]{"push_front -855", "push_front 0", "pop_back", "pop_back", "push_back 844", "pop_back", "push_back 823"};
        expected = new String[]{"-855", "0", "844"};
        result = FinalA.process(input, 10);
        assertArrayEquals(expected, result);

        input = new String[]{"push_back 844", "pop_back"};
        expected = new String[]{"844"};
        result = FinalA.process(input, 10);
        assertArrayEquals(expected, result);

        input = new String[]{"push_front 861", "push_front -819", "pop_back", "pop_back"};
        expected = new String[]{"861", "-819"};
        result = FinalA.process(input, 4);
        assertArrayEquals(expected, result);

        input = new String[]{"push_front -201", "push_back 959", "push_back 102", "push_front 20", "pop_front", "pop_back"};
        expected = new String[]{"20", "102"};
        result = FinalA.process(input, 6);
        assertArrayEquals(expected, result);

    }

}