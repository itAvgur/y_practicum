package org.itavgur.SearchEngine;

import java.util.List;

public interface SearchEngine<T, E> {

    @SuppressWarnings("unchecked")
    void search(E[]... requests);

    int getSearchLimit();

    void setSearchLimit(int searchLimit);

    List<List<Integer>> getSearchResultList();

    Integer[][] getSearchResultArray();
}
