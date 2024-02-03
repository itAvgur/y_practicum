package org.itavgur.sprint_8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
3 фев 2024, 11:12:37
106500114

-- ПРИНЦИП РАБОТЫ --
Создаем дополнительный массив boolean[] для хранения результатов поиска, можно ли достичь этого символа с помощью
любого слова из шаблона.
Поиск осуществляем не от всех букв, а только от букв для которых предыдущая буква может быть достижима (canReachTo[])
+ первый элемент массива = true, для начала поиска с позиции text[0]

Итогом является true/false для последней позиции в массиве canReachTo.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
ДП.
Делим общую задачу достижения последней буквы в слове на подзадачи.
Т.е. если от l(a) можно достичь l(b), а от l(b+1) - l(c), то тогда от l(a) можно достичь l(c)

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
O(N) - обработка каждого символа
O(L) - поиск по бору, в случае самого длинного слова
Итого: O(N*L)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Дополнительно используем массив N+1

*/
public class FinalB {

    protected static final String POSITIVE_ANSWER = "YES";
    protected static final String NEGATIVE_ANSWER = "NO";

    public static String process(String text, int wordsNumber, String[] words) {

        TrieNode trie = initTrie(words);

        boolean[] canReachTo = new boolean[text.length() + 1];
        canReachTo[0] = true;

        for (int i = 1; i < canReachTo.length; i++) {
            markPossibleDestination(text, trie, i, canReachTo);
        }

        return canReachTo[canReachTo.length - 1] ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }

    private static void markPossibleDestination(String text, TrieNode trie, int startIdx, boolean[] canReachTo) {

        if (!canReachTo[startIdx - 1]) return;

        TrieNode currentNode = trie;
        for (int i = startIdx; i < canReachTo.length; i++) {
            char letter = text.charAt(i - 1);
            TrieNode foundNode = currentNode.children.get(letter);
            if (foundNode == null) {
                break;
            } else if (foundNode.isTerminal) {
                canReachTo[i] = true;
                currentNode = foundNode;
            } else {
                currentNode = foundNode;
            }
        }

    }

    private static TrieNode initTrie(String[] templates) {

        TrieNode rootTrie = new TrieNode(null);

        for (String template : templates) {
            TrieNode currentNode = rootTrie;

            for (int i = 0; i < template.length(); i++) {
                char letter = template.charAt(i);
                currentNode = addLetterToTree(currentNode, letter);
            }

            currentNode.isTerminal = true;
        }

        return rootTrie;
    }

    private static TrieNode addLetterToTree(TrieNode node, char letter) {
        TrieNode foundNode = node.children.get(letter);

        if (foundNode == null) {
            TrieNode newNode = new TrieNode(letter);
            node.children.put(letter, newNode);
            foundNode = newNode;
        }

        return foundNode;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String test = readString(reader);
            int wordsNumber = readInt(reader);
            String[] words = readData(reader);
            System.out.println(process(test, wordsNumber, words));
        }
    }

    private static Integer readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static String readString(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private static String[] readData(Reader reader) throws IOException {
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

    private static class TrieNode {

        Character letter;
        Map<Character, TrieNode> children = new HashMap<>();

        boolean isTerminal;

        public TrieNode(Character letter) {
            this.letter = letter;
        }
    }

}