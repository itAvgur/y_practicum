package org.itavgur.sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/*
30 окт 2023, 21:32:09
95313476

-- ПРИНЦИП РАБОТЫ --

При создании SearchEngine парсим документы.
SearchLimit являеется изменяемым полем, влияет на итоговый вывод, по умолчанию = 5

При парсинге создает Map из StatResult в которых храним соответствие слово->документ, количество повторов в документе.

В Метод search передаем массив строк, запросов.

HashSet слов из запроса исключает дубли
В цикле поиска ищем для каждого запроса данные в hashtable, создаем объекты StatResult в которых суммируем индекс документа
и количество повторов (счетчик).

После полной проработки всех запросов берем итоговые данные, сортируем по условиям задачи через реализацию интерфейса Comparable.

Выдача результатов происходит отдельным методом getSearchResultList, поэтому он и метод search синхронизированы.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Использование родного HashMap, HashSet + нативная реализация hascode()

Каждый запрос обрабатываем отдельно по каждому слову.


-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Создание базы слов (с учетом операции вставки, проверки): O(n), где N = общее количество слов во всех документах
Поиск слов:
    кеш слов в запросе O(k), где k - все уникальные слова в запросе
    поиск слов O(k)*O(1)   считаетм что поиск занимает в среднем O(1)
    сортировка итоговой таблицы - в худшем случае O(k2), если все слова в запросе попали в выдачу

Итого, мне кажется что имеем за отбросом всех констант амортизированное время O(n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Таблица, в java реализации 16 basket, в зависимости от входных данных будет масштабироваться = O(n*d) d- количество документов
+ O(k) таблица слов для поиска
+ O(n*d*k) в худшем случае итоговая таблица

так-же алгоритм сортировки fast sorting в java берет какое-то количество памяти

*/
public class FinalA {

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            FinalA finalB = new FinalA();
            int docAmount = readInt(reader);
            String[] documents = readStrings(reader, docAmount);
            int requestAmount = readInt(reader);
            String[] requests = readStrings(reader, requestAmount);
            List<List<Integer>> result = finalB.process(docAmount, documents, requestAmount, requests);
            printMatrixPerLine(result);
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static String[] readStrings(BufferedReader reader, int rows) throws IOException {
        String[] res = new String[rows];
        for (int i = 0; i < rows; ++i) {
            String value = readString(reader);
            res[i] = value;
        }
        return res;
    }

    public static void printMatrixPerLine(List<List<Integer>> array) {
        PrintWriter output = new PrintWriter(System.out);
        for (List<Integer> row : array) {
            for (int i = 0; i < row.size(); i++) {
                output.print(row.get(i));
                if (i + 1 != row.size()) {
                    output.print(DELIMITER);
                }
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    public List<List<Integer>> process(int docAmount, String[] documents, int requestAmount, String[] requests) {

        SearchEngine searchEngine = new SearchEngine(documents);

        searchEngine.search(requests);

        return searchEngine.getSearchResultList();
    }

    private static class SearchEngine {

        private static final String DELIMITER = " ";
        private static final int DEFAULT_SEARCH_RESULT_LIMIT = 5;
        private final Map<String, List<StatResult>> database = new HashMap<>();
        private int searchLimit;
        private List<List<Integer>> searchResult;

        public SearchEngine(String[] documents) {
            this(documents, DEFAULT_SEARCH_RESULT_LIMIT);
        }

        public SearchEngine(String[] documents, int searchLimit) {
            this.searchLimit = searchLimit;
            parseDocuments(documents);
        }

        public int getSearchLimit() {
            return searchLimit;
        }

        public void setSearchLimit(int searchLimit) {
            this.searchLimit = searchLimit;
        }

        private void parseDocuments(String[] documents) {

            for (int i = 0; i < documents.length; i++) {
                if (documents[i].isEmpty()) continue;
                String[] words = documents[i].split(DELIMITER);
                for (String word : words) {
                    addElement(word, i);
                }
            }
        }

        private void addElement(String element, Integer docIndex) {

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

        public synchronized void search(String[] requests) {

            searchResult = new ArrayList<>(requests.length);

            for (String request : requests) {
                if (request == null) continue;
                HashSet<String> words = new HashSet<>();
                words.addAll(Arrays.asList(request.split(DELIMITER)));

                Map<Integer, StatResult> stats = new HashMap<>();
                for (String word : words) {
                    List<StatResult> statFound = database.get(word);
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

        public synchronized List<List<Integer>> getSearchResultList() {
            return searchResult;
        }

        private static class StatResult implements Comparable<StatResult> {

            int docIdx;
            int counter;

            public StatResult(int docIdx, int counter) {
                this.docIdx = docIdx;
                this.counter = counter;
            }

            @Override
            public int compareTo(StatResult o) {
                if (this.counter == o.counter) {
                    return this.docIdx - o.docIdx;
                } else {
                    return o.counter - this.counter;
                }
            }
        }

    }
}