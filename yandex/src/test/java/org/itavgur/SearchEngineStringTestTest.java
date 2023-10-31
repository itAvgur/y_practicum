package org.itavgur;


import org.itavgur.SearchEngine.SearchEngine;
import org.itavgur.SearchEngine.SearchEngineString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchEngineStringTestTest {

    private static final String DELIMITER = " ";

    @Test
    public void test() {

        String[] documents;
        Integer[][] expected;
        SearchEngine<String, String> searchEngine;

        documents = new String[]{"i love coffee", "coffee with milk and sugar", "free tea for everyone"};
        searchEngine = new SearchEngineString(documents);
        searchEngine.search(
                "i like black coffee without milk".split(DELIMITER),
                "everyone loves new year".split(DELIMITER),
                "mary likes black coffee without milk".split(DELIMITER)
        );
        expected = new Integer[][]{{1, 2}, {3}, {2, 1}};
        Assertions.assertArrayEquals(expected, searchEngine.getSearchResultArray());

        documents = new String[]{"jdxmp jdxmp jdxmp jdxmp", "jdxmp jdxmp jdxmp jdxmp jdxmp", "jdxmp jdxmp jdxmp jdxmp jdxmp jdxmp"
                , "jdxmp jdxmp jdxmp jdxmp jdxmp", "jdxmp jdxmp jdxmp jdxmp jdxmp", "jdxmp jdxmp jdxmp jdxmp jdxmp"};
        searchEngine = new SearchEngineString(documents, 3);
        searchEngine.search(
                "jdxmp jdxmp jdxmp jdxmp jdxmp".split(" "),
                "asd ac qwe xcv".split(" "),
                "mary likes black coffee without milk".split(" ")
        );
        expected = new Integer[][]{{3, 2, 4}, {}, {}};
        Assertions.assertArrayEquals(expected, searchEngine.getSearchResultArray());

    }

}