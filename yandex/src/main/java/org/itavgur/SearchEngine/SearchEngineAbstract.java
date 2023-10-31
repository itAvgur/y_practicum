package org.itavgur.SearchEngine;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SearchEngineAbstract<T, E> implements SearchEngine<T, E> {

    private static final int DEFAULT_SEARCH_RESULT_LIMIT = 5;
    private final Map<E, List<StatResult>> database = new HashMap<>();
    protected int searchLimit;
    protected List<List<Integer>> searchResult;

    protected SearchEngineAbstract(T[] documents) {
        this(documents, DEFAULT_SEARCH_RESULT_LIMIT);
    }

    protected SearchEngineAbstract(T[] documents, int searchLimit) {
        this.searchLimit = searchLimit;
        parseDocuments(documents);
    }

    private void parseDocuments(T[] documents) {

        for (int i = 0; i < documents.length; i++) {
            if (documents[i] == null) continue;
            E[] elements = parseDocument(documents[i]);

            for (E element : elements) {
                addElement(element, i);
            }
        }

    }

    abstract protected E[] parseDocument(T request);

    private void addElement(E element, int docIndex) {

        List<StatResult> stats = database.get(element);
        if (stats != null) {
            if (docIndex >= stats.size()) {
                stats.add(new StatResult(docIndex, 1));
            } else {
                StatResult stat = stats.get(docIndex);
                stat.counter = stat.counter + 1;
            }
        } else {
            List<StatResult> newStat = new ArrayList<>();
            newStat.add(new StatResult(docIndex, 1));
            database.put(element, newStat);
        }

    }

    @Override
    public synchronized void search(E[]... requests) {

        searchResult = new ArrayList<>(requests.length);

        for (E[] request : requests) {
            if (request == null) continue;
            HashSet<E> elements = new HashSet<>();
            elements.addAll(Arrays.asList(request));

            Map<Integer, StatResult> stats = new HashMap<>();
            for (E element : elements) {
                List<StatResult> statFound = database.get(element);
                if (statFound == null) continue;

                for (StatResult stat : statFound) {
                    if (stats.containsKey(stat.docIdx)) {
                        StatResult statSlot = stats.get(stat.docIdx);
                        statSlot.counter = stat.counter + statSlot.counter;
                        stats.put(stat.docIdx, statSlot);
                    } else {
                        stats.put(stat.docIdx, new StatResult(stat.docIdx, stat.counter));
                    }
                }
            }

            searchResult.add(stats.values().stream().
                    sorted()
                    .limit(searchLimit)
                    .map(s -> s.docIdx + 1)
                    .collect(Collectors.toList()));
        }

    }

    @Override
    public int getSearchLimit() {
        return searchLimit;
    }

    @Override
    public void setSearchLimit(int searchLimit) {
        this.searchLimit = searchLimit;
    }

    @Override
    public synchronized List<List<Integer>> getSearchResultList() {
        return searchResult;
    }

    @Override
    public synchronized Integer[][] getSearchResultArray() {
        return searchResult.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
    }

    private static class StatResult implements Comparable<StatResult> {

        int docIdx;
        int counter;

        public StatResult(int docIdx, int counter) {
            this.docIdx = docIdx;
            this.counter = counter;
        }

        @Override
        public int compareTo(SearchEngineAbstract.StatResult o) {
            if (this.counter == o.counter) {
                return this.docIdx - o.docIdx;
            } else {
                return o.counter - this.counter;
            }
        }
    }


}
