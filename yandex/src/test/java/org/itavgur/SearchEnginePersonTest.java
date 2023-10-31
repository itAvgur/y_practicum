package org.itavgur;


import org.itavgur.SearchEngine.Person;
import org.itavgur.SearchEngine.SearchEngine;
import org.itavgur.SearchEngine.SearchEnginePersons;
import org.itavgur.SearchEngine.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchEnginePersonTest {

    @Test
    public void test() {

        Team[] teams;
        Integer[][] expected;
        SearchEngine<Team, Person> searchEngine;

        Person ivan = new Person("Ivan");
        Person maria = new Person("Maria");
        Person abdulla = new Person("Abdulla");
        Team team1 = new Team(List.of(ivan, maria, abdulla));
        Team team2 = new Team(List.of(abdulla));

        teams = new Team[]{team1, team2};
        expected = new Integer[][]{{1}, {1, 2}};
        searchEngine = new SearchEnginePersons(teams);

        searchEngine.search(
                new Person[]{ivan},
                new Person[]{abdulla}
        );
        Assertions.assertArrayEquals(expected, searchEngine.getSearchResultArray());

    }

}