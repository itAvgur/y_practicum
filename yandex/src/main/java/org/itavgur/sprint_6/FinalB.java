package org.itavgur.sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
21 янв 2024, 16:02:26
105451523

-- ПРИНЦИП РАБОТЫ --
При создании графа инвертируем маршруты R, маршруты B оставляем как есть.
Рекурсивно выполянем dfs, если находим вершину, которая имеет статус IN_PROCESS (для статусов создан отдельный enum)
бросает MapNotOptimizedException, которые перехватывает в основной функции.
Метод findNextNotVisitedNode() необходим для обработки ситуации, когда у нас существует несвязанные графы и мы не можем
за один проход проверить узла

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Всего типов дорог 2, значит мы можем не формировать карту всех маршрутов через bfs (это тоже сделал, но прошло по
 времени/памяти), а искуственно привести задачу к поиску цикла в графе.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Максимум будет O(V+E) для цикла от самого первого узла

Итого: O(ElogV)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Используем массив объектов Station + List<int> в качестве маршрутов.
Итого имеет O(V+E) + накладные расходы на объекты

*/
public class FinalB {

    private static final String MAP_IS_OPTIMAL = "YES";
    private static final String MAP_IS_NOT_OPTIMAL = "NO";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = readInt(reader);
            String[] routes = readStrings(reader, size - 1);
            String result = process(size, routes);
            System.out.println(result);
        }
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

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static String process(int size, String[] data) {


        Station[] graph = initMap(size, data);

        try {

            Integer headNode = 0;
            do {
                checkMapIsOptimalRecursively(graph, headNode);
                graph[headNode].state = ProcessingState.VISITED;
                headNode = findNextNotVisitedNode(graph);
            } while (headNode != null);
        } catch (MapNotOptimizedException e) {
            return MAP_IS_NOT_OPTIMAL;
        }

        return MAP_IS_OPTIMAL;
    }

    private static Integer findNextNotVisitedNode(Station[] graph) {

        for (int i = 1; i < graph.length; i++) {
            if (graph[i].state == ProcessingState.NOT_VISITED) {
                return i;
            }
        }
        return null;
    }

    private static void checkMapIsOptimalRecursively(Station[] graph, Integer idx) {

        //base case
        Station station = graph[idx];
        if (station.routes.isEmpty()) {
            station.state = ProcessingState.VISITED;
            return;
        }

        station.state = ProcessingState.IN_PROCESS;

        for (int nextRoute : station.routes) {

            if (ProcessingState.NOT_VISITED.equals(graph[nextRoute].state)) {
                checkMapIsOptimalRecursively(graph, nextRoute);
                graph[nextRoute].state = ProcessingState.VISITED;
            } else if (ProcessingState.IN_PROCESS.equals(graph[nextRoute].state)) {
                throw new MapNotOptimizedException();
            }
        }

    }

    private static Station[] initMap(int size, String[] data) {

        Station[] stations = new Station[size];

        for (int i = 0; i < size; i++) {
            stations[i] = new Station();
            stations[i].routes = new ArrayList<>();
        }

        int currentCity = 0;
        for (String routes : data) {
            for (int i = 0; i < routes.length(); i++) {
                if (RouteType.B.charCode == routes.charAt(i)) {
                    int newRoute = currentCity + i + 1;
                    stations[currentCity].routes.add(newRoute);
                } else {
                    stations[currentCity + i + 1].routes.add(currentCity);
                }
            }
            currentCity++;
        }
        return stations;
    }

    private enum RouteType {

        R(82), B(66);
        final int charCode;

        RouteType(int charCode) {
            this.charCode = charCode;
        }
    }

    private enum ProcessingState {
        NOT_VISITED, IN_PROCESS, VISITED
    }

    private static class Station {

        List<Integer> routes;
        ProcessingState state = ProcessingState.NOT_VISITED;

    }

    private static class MapNotOptimizedException extends RuntimeException {
    }

}