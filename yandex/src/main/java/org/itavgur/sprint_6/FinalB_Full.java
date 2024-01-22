package org.itavgur.sprint_6;

import java.io.*;
import java.util.*;


public class FinalB_Full {


    private static final String MAP_IS_OPTIMAL = "YES";
    private static final String MAP_IS_NOT_OPTIMAL = "NO";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = readInt(reader);
            String[] routes = readData(reader);
            String result = process(size, routes);
            System.out.println(result);
        }
    }

    public static void main(BufferedReader reader) throws IOException {
        int size = readInt(reader);
        String[] routes = readData(reader);
        String result = process(size, routes);
        System.out.println(result);
    }


    protected static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    protected static String[] readData(Reader reader) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        List<String> tokens = new ArrayList<>();

        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                tokens.add(streamTokenizer.sval);
            }
            currentToken = streamTokenizer.nextToken();
        }
        return tokens.toArray(String[]::new);
    }

    public static String process(int size, String[] data) {

        Station[] graph = initMap(size, data);

        Queue<Pair<Station, RouteType>> queue = new LinkedList<>();
        Map<Pair<Station, Station>, RouteType> map = new HashMap<>();
        for (Station station : graph) {
            queue.offer(new Pair<>(station, null));
            try {
                buildOptimizedMap(queue, map);
            } catch (Exception e) {
                return MAP_IS_NOT_OPTIMAL;
            }
        }
        return MAP_IS_OPTIMAL;
    }

    private static Station[] initMap(int size, String[] data) {

        Station[] stations = new Station[size];

        for (int i = 0; i < size; i++) {
            stations[i] = new Station(i);
        }

        int currentCity = 0;
        for (String station : data) {
            String[] routes = station.split("");
            stations[currentCity].routes = new ArrayList<>(routes.length);
            for (int i = 0; i < routes.length; i++) {
                Route newRoute = new Route();
                newRoute.from = stations[currentCity];
                newRoute.to = stations[currentCity + i + 1];
                newRoute.type = RouteType.valueOf(routes[i]);
                stations[currentCity].routes.add(newRoute);
            }
            currentCity++;
        }

        stations[size - 1].routes = Collections.emptyList();

        return stations;
    }

    private static void buildOptimizedMap(Queue<Pair<Station, RouteType>> queue, Map<Pair<Station, Station>, RouteType> map) {

        Station sourceStation = Objects.requireNonNull(queue.peek()).first;

        Pair<Station, RouteType> destStation;
        while ((destStation = queue.poll()) != null) {
            for (Route route : destStation.first.routes) {
                //add routes
                RouteType lastRouteType = destStation.second;
                if (lastRouteType == null || route.type == lastRouteType) {
                    Pair<Station, Station> newStationsInfo = new Pair<>(sourceStation, route.to);
                    RouteType routeType = map.get(newStationsInfo);
                    if (lastRouteType != null && routeType != route.type) {
                        throw new MapNotOptimizedException();
                    }
                    map.put(newStationsInfo, route.type);
                    queue.offer(new Pair<>(route.to, route.type));
                }
            }
        }
    }

    private enum RouteType {
        R, B
    }

    private static class Station {

        int value;
        List<Route> routes;

        public Station(int value) {
            this.value = value;
        }

    }

    private static class Route {
        RouteType type;
        Station from;
        Station to;
    }

    private static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private static class MapNotOptimizedException extends RuntimeException {
    }

}