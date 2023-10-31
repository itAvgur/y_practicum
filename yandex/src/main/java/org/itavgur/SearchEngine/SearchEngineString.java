package org.itavgur.SearchEngine;

public class SearchEngineString extends SearchEngineAbstract<String, String> {

    private static final String DELIMITER = " ";

    public SearchEngineString(String[] documents) {
        super(documents);
    }

    public SearchEngineString(String[] documents, int searchLimit) {
        super(documents, searchLimit);
    }

    @Override
    protected String[] parseDocument(String request) {
        return request.split(DELIMITER);
    }

}
