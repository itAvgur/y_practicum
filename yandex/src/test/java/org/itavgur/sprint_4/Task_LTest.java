package org.itavgur.sprint_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task_LTest {

    @Test
    public void test() {

        Integer[] expected;
        Integer[] result;
        String input;

        input = "gggggooooogggggoooooogggggssshaa";
        result = Task_L.process(10, 2, input);
        expected = new Integer[]{0, 5};
        assertArrayEquals(expected, result);

        input = "ggooggoogg";
        result = Task_L.process(4, 2, input);
        expected = new Integer[]{0, 1, 2};
        assertArrayEquals(expected, result);


        input = "aabbaabbaa";
        result = Task_L.process(4, 2, input);
        expected = new Integer[]{0, 1, 2};
        assertArrayEquals(expected, result);

        input = "allallallallalla";
        result = Task_L.process(3, 4, input);
        expected = new Integer[]{0, 1, 2};
        assertArrayEquals(expected, result);

    }

    @Test
    public void testFailed() {

        Integer[] expected;
        Integer[] result;
        String input;

        input = "ppppppppppppppp";
        result = Task_L.process(5, 2, input);
        expected = new Integer[]{0};
        assertArrayEquals(expected, result);

        input = "jwdupqtgjzqgwiqufyprfjeuezqpwexytxytsgmcphegwbcepuouaopompuozqwfeyddgxawlqjulnzqgpmxdviezqpwexqugajxytesohlhhzqklaupgegwbceuhpjrlnefdrhffimenjwdeuzlpsmgrprfjeuhlhhzqupqtgjhhztqgxtlkhibniszekhibniynsbbhqlpgeumizlqbbbhqlpcrnxlzlxyqfjpydzdmynscmtfknjizqiisllyznynsjwdsgmcphwpspuqcrzchxbtzxytxuvbxefvagaedvbkhwifcsllyznulndcgthpulndrhuexoqxvpeipuuaopomxinydtcvdbbhqlpsllyznsllyznxuvbxeezqpwesonncsupqtgjcrzcfogeumizhjxlkcjwnfvmprfjeuxytklaupgcforbppydzdmcrnxlzxtljhxqpduhphjxlkcetlzgsqmygplpuplhazgsqmyyfjkzbjrlnefgaedrhcxkmhuzgsqmyfvaexeklaupggaehhztqgzazoxjldkudplxyqfjjwdcxkmhusllyznzqwkgngeumizzemddsszeufyqhkfeykhibniynsklaupgzazoxjlxyqfjifcuaopomxytxinydtqjulzjcrzulnlqjlqjvngpqqldkudplqbbzeatgjizqiilxyqfjzqgchxbtzcxkmhujhxqpdprfjeujwduaopomlpsmgrzqgbbhqlpvpeipusllyznxtlxytsjgjmtbbhqlpeuzbwosvtrwkzgsqmyazyupqtgjcmtufyuexoqxrbpjhxqpdsgmcphjwdtbyjmbszedvbkhwxqugajcrnxlzvngpqqbbhqlpxytchxbtzvpeipufvachxbtzpuouexoqxjmbdvbkhweuzetlbwosvtzeqtbyfrulqbsllyzndvbkhwffimencrzffimencfoxinydtbzeatgdrhkzb";
        result = Task_L.process(6, 2, input);
        expected = Arrays.stream(new Integer[]{24, 25, 42, 18, 105, 3, 180, 198, 36, 252, 51, 288, 204,
                111, 231, 219, 411, 477, 126, 171, 225, 516, 190, 191, 192, 548, 549, 550, 343, 348, 555, 556, 246, 279, 459,
                147, 336, 575, 370, 394, 330, 263, 299, 300, 93, 675, 792, 135, 964, 690
        }).sorted().toArray(Integer[]::new);
        assertArrayEquals(expected, result);

    }

}