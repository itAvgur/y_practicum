package org.itavgur.sprint_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalATest extends FinalA {

    @Test
    public void test1() {

        String expected;
        String result;

        String[] packedStrings = new String[]{"2[a]2[ab]", "3[a]2[r2[t]]", "a2[aa3[b]]"};
        expected = "aaa";
        result = process(3, packedStrings);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {

        String expected;
        String result;

        String[] packedStrings = new String[]{"abacabaca", "2[abac]a", "3[aba]"};
        expected = "aba";
        result = process(3, packedStrings);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {

        String expected;
        String result;

        String[] packedStrings = new String[]{"a2[bb]c", "abb1[bb]d"};
        expected = "abbbb";
        result = process(2, packedStrings);
        assertEquals(expected, result);
    }

    @Test
    public void test4() {

        String expected;
        String result;

        String[] packedStrings = new String[]{
                "3[2[bkyb]2[eszi]1[k]1[ep]]2[w]3[3[a]]1[krr]2[lh]1[pj]",
                "3[2[bkyb]2[eszi]1[k]1[ep]]2[w]3[3[a]]1[3[i]2[t]]",
                "3[2[bkyb]2[eszi]1[k]1[ep]]2[w]3[3[a]]1[1[i]2[nbiv]1[i]]1[blrw]3[gh]2[g]3[gt]",
                "3[2[bkyb]2[eszi]1[k]1[ep]]2[w]3[3[a]]3[1[f]1[uze]]3[3[f]1[zw]]",
                "3[2[bkyb]2[eszi]1[k]1[ep]]2[w]3[3[a]]3[al]1[kywr]2[1[lhgo]]"
        };
        expected = "bkybbkybeszieszikepbkybbkybeszieszikepbkybbkybeszieszikepwwaaaaaaaaa";
        result = process(5, packedStrings);
        assertEquals(expected, result);
    }

    @Test
    public void testFailed2() {

        String expected;
        String result;

        String[] packedStrings = new String[]{
                "2[2[aa]2[bb]]"
        };
        expected = "aaaabbbbaaaabbbb";
        result = process(5, packedStrings);
        assertEquals(expected, result);
    }


}