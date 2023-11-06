package org.itavgur.sprint_4;

public class Task_B {

    //Гоша использует следующую хеш-функцию:
    //
    // h(s) = (s1*an-1 + s2*an-2 + ... +sn-1*a + sn) mod m
    //
    //для a = 1000 и m = 123 987 123.

    public static Boolean process(String str1, String str2, int base, int mod) {

        char[] charArray;

        long hash1 = 0;
        charArray = str1.toCharArray();
        if (charArray.length == 1) hash1 = charArray[0];
        for (char letter : charArray) {
            hash1 = (hash1 * base + letter) % mod;
        }

        long hash2 = 0;
        charArray = str2.toCharArray();
        if (charArray.length == 1) hash1 = charArray[0];
        for (char letter : charArray) {
            hash2 = (hash2 * base + letter) % mod;
        }

        System.out.println(hash1);
        System.out.println(hash2);

        return hash1 == hash2;
    }

    public static long hash(String str1, int base, int mod) {

        char[] charArray;

        long hash = 0;
        charArray = str1.toCharArray();
        if (charArray.length == 1) hash = charArray[0];
        for (char letter : charArray) {
            hash = (hash * base + letter) % mod;
        }

        return hash;
    }

}