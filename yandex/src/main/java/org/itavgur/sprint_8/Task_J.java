package org.itavgur.sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task_J {

    protected static String[] camelCase(int classesNumber, String[] classes, int requestsNumber, String[] requests) {

        List<String> res = new ArrayList<>();

        TrieNode trie = initTrie(classes);

        for (String request : requests) {
            res.addAll(searchTemplates(trie, request));
        }

        return res.toArray(String[]::new);
    }

    private static Set<String> searchTemplates(TrieNode trie, String request) {

        if (request.isBlank()) {
            return trie.classes;
        }

        for (int i = 0; i < request.length(); i++) {
            char letter = request.charAt(i);
            trie = trie.children.get(letter);
            if (trie == null) return Collections.emptySet();
        }

        return trie.classes;
    }

    private static TrieNode initTrie(String[] classes) {

        TrieNode trie = new TrieNode(null);

        Collections.addAll(trie.classes, classes);

        String[] upperCases = new String[classes.length];

        for (int i = 0; i < classes.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < classes[i].length(); j++) {
                char letter = classes[i].charAt(j);
                if (letter > 40 && letter < 91) {
                    sb.append(letter);
                }
            }

            upperCases[i] = sb.toString();
        }

        for (int i = 0; i < upperCases.length; i++) {
            String upperCase = upperCases[i];
            TrieNode finalNode = trie;
            for (int j = 0; j < upperCase.length(); j++) {
                char letter = upperCase.charAt(j);
                finalNode = addClassToTree(classes[i], letter, finalNode);
            }
        }

        return trie;
    }

    private static TrieNode addClassToTree(String className, char letter, TrieNode node) {

        TrieNode foundChild = node.children.get(letter);

        if (foundChild == null) {
            TrieNode newNode = new TrieNode(letter);
            newNode.classes.add(className);
            node.children.put(letter, newNode);
            return newNode;
        } else {
            foundChild.classes.add(className);
            return foundChild;
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int classesNumber = readInt(reader);
            String[] classes = readStrings(reader, classesNumber);
            int requestsNumber = readInt(reader);
            String[] requests = readStrings(reader, requestsNumber);

            String[] res = camelCase(classesNumber, classes, requestsNumber, requests);
            printArrayPerLine(res);

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

    private static void printArrayPerLine(String[] strings) {
        PrintWriter output = new PrintWriter(System.out);
        for (String string : strings) {
            output.println(string);
        }
        output.flush();
        output.close();
    }

    private static class TrieNode {

        Character letter;
        Map<Character, TrieNode> children = new HashMap<>();

        Set<String> classes = new TreeSet<>();

        public TrieNode(Character letter) {
            this.letter = letter;
        }
    }

}
