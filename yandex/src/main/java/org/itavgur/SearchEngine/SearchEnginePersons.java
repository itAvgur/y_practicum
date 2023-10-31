package org.itavgur.SearchEngine;

public class SearchEnginePersons extends SearchEngineAbstract<Team, Person> {

    public SearchEnginePersons(Team[] documents) {
        super(documents);
    }

    @Override
    protected Person[] parseDocument(Team request) {
        return request.members().toArray(Person[]::new);
    }
}
