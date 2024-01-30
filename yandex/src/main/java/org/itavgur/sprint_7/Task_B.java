package org.itavgur.sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task_B {

    private static final String DELIMITER = " ";

    protected static String[][] schedule(int size, String[][] data) {

        List<Event> events = initData(data);

        List<Event> eventsToVisit = new ArrayList<>();

        double currentEventEndTime = 0.0;

        for (Event event : events) {
            if (currentEventEndTime <= event.startTime) {
                eventsToVisit.add(event);
                currentEventEndTime = event.endTime;
            }
        }

        String[][] result = new String[eventsToVisit.size() + 1][];
        result[0] = new String[]{"" + eventsToVisit.size()};

        for (int i = 0; i < eventsToVisit.size(); i++) {
            Event event = eventsToVisit.get(i);
            result[i + 1] = new String[]{fmt(event.startTime), fmt(event.endTime)};

        }

        return result;
    }

    private static String fmt(double d) {

        return (d == (long) d) ? String.format("%d", (long) d) : String.format("%s", d);
    }

    private static List<Event> initData(String[][] data) {

        List<Event> res = new ArrayList<>(data.length);

        for (String[] datum : data) {

            Event newEvent = new Event();
            newEvent.startTime = Double.parseDouble(datum[0]);
            newEvent.endTime = Double.parseDouble(datum[1]);
            res.add(newEvent);
        }

        res.sort(new EventComparator());
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = readInt(reader);
            String[][] data = readMatrix(reader, size, 2);

            printMatrix(schedule(size, data));
        }
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toArray(String[]::new);
    }

    protected static String[][] readMatrix(BufferedReader reader, int rows, int columns) throws IOException {
        String[][] res = new String[rows][columns];
        for (int i = 0; i < rows; ++i) {
            String[] integers = readStrings(reader);
            res[i] = integers;
        }
        return res;
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printMatrix(String[][] values) {
        PrintWriter output = new PrintWriter(System.out);
        for (String[] row : values) {
            for (String value : row) {
                output.print(value);
                output.print(DELIMITER);
            }
            output.println();
        }
        output.flush();
        output.close();
    }

    private static class Event {

        Double startTime;
        Double endTime;

    }

    private static class EventComparator implements Comparator<Event> {
        @Override
        public int compare(Event o1, Event o2) {

            int i = (int) (o1.endTime - o2.endTime);

            return i == 0 ? (int) (o1.startTime - o2.startTime) : i;
        }
    }

}