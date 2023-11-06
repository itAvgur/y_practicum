package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task_BTest {

    @Test
    public void test() {

        assertTrue(Task_B.process("ezhgeljkablzwnvuwqvp", "gbpdcvkumyfxillgnqrv", 1000, 123987123));
        assertTrue(Task_B.process("ysdsjgiylnkjdcvbnhsj", "bnxamcsiljcdsfjszkzy", 1000, 123987123));
    }

    @Test
    public void findCollision() {

        Map<Long, String> map = new HashMap<>();

        int length = 20;
        String[] letters = new String[length];

        int min = 97;
        int max = 122;

        Random random = new Random();

        while (true) {

            for (int i = 0; i < length; i++) {
                int randomChar = random.nextInt(max - min + 1) + min;
                letters[i] = Character.toString(randomChar);
            }

            StringBuilder sb = new StringBuilder(10);
            for (String letter : letters) {
                sb.append(letter);

            }

            long hash = Task_B.hash(sb.toString(), 1003, 123987123);

            if (map.containsKey(hash)) {

                System.out.println("str1: " + map.get(hash) + "\nstr2: " + sb + "\nhash: " + hash);
                break;
            } else {
                map.put(hash, sb.toString());
            }
        }

    }

}