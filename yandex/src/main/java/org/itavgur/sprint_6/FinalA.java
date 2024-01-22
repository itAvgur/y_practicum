package org.itavgur.sprint_6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
18 янв 2024, 12:35:46
105196832

-- ПРИНЦИП РАБОТЫ --

Вся работа алгоритма в отдельном классе SpanningTree
Подаем на вход массив ребер в формате (узел, узел, вес..)
Основной метод findMaxSpanningForest выполняет:
1) сортировка ребер с использованием соответствующего компаратора
2) берет каждое ребро и помещает его в подходящее дерево (когда один из узлом ребра входит в имеющееся дерево) и
    увеличивает счетчие веса дерева
3) при необходимости объединяет деревья, когда узла ребра принадлежат двум разным деревьям
4) если ребро не подходит ни в одно дерево, то создаем новое дерево
5) петли из одного узла не обрабатываем
6) если ребро уже имеется в дереве, то сравниваем его вес и выбираем больший
7) краевые случае из пустого дерева и дерева из одного узла обрабатываем отдельно
На выходе работы получаем список из всех имеющихся остовных деревьях
Если в списке одно дерево, выводим его вес, если 0 или >2, то выводим сообщение согласно требованию

Имеется возможность выполнить поиск минимального дерева, методы findMinSpanningForest() и getSpanningForestMinWeight()

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Используется алгоритм Краскала.
https://habr.com/ru/articles/569444/
В реализации максимальных весов.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
загрузка данных O(n)
сортировка O(ElogV)
обрабовка ребер за отбрасываение константы (каждое ребро обрабатывается несколько раз) O(n)

Итого: O(ElogV)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Исходный массив n преобразовыется в объект Edge с однотипной структурой
Класс Tree служит для накопления информации о деревьях.
Итого приблизительно выделяем 3n + некоторое количество на объекты

*/
public class FinalA {

    private static final String NOT_FOUND = "Oops! I did it again";
    private static final String ONE_NODE_TREE = "0";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String result = process(readData(reader));
            System.out.println(result);
        }
    }

    private static Integer[] readData(Reader reader) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        List<Integer> tokens = new ArrayList<>();

        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add((int) streamTokenizer.nval);
            }
            currentToken = streamTokenizer.nextToken();
        }
        return tokens.toArray(Integer[]::new);
    }

    public static String process(Integer[] data) {

        //corner cases when we don't have edges
        if (data[1] == 0 && data[0] == 1) return ONE_NODE_TREE;
        if (data[1] == 0) return NOT_FOUND;

        SpanningTree spanningTree = new SpanningTree(Arrays.copyOfRange(data, 2, data.length));

        spanningTree.findMaxSpanningForest();

        List<Integer> maxSpanningForestWeight = spanningTree.getSpanningForestMaxWeight();

        return maxSpanningForestWeight.size() != 1 ? NOT_FOUND : "" + maxSpanningForestWeight.get(0);
    }


    // Separate class for SpanningTree operations
    private static class SpanningTree {

        private static final int MIN_SPANNING_TREE = -1;
        private static final int MAX_SPANNING_TREE = 1;
        private final MinForestComparator minEdgeComparator = new MinForestComparator();
        private final MaxForestComparator maxEdgeComparator = new MaxForestComparator();

        private final List<Edge> edges;
        private Set<Tree> maxSpanningForest;
        private Set<Tree> minSpanningForest;

        public SpanningTree(Integer[] arrayOfEdges) {
            this.edges = new ArrayList<>();

            for (int i = 0; i < arrayOfEdges.length; i = i + 3) {
                Edge newEdge = new Edge();
                newEdge.weight = arrayOfEdges[i + 2];
                newEdge.nodes = new int[2];
                newEdge.nodes[0] = arrayOfEdges[i];
                newEdge.nodes[1] = arrayOfEdges[i + 1];
                this.edges.add(newEdge);
            }
        }

        public List<Integer> getSpanningForestMinWeight() {

            return minSpanningForest.stream().map(o -> o.weight).collect(Collectors.toList());
        }

        public List<Integer> getSpanningForestMaxWeight() {

            return maxSpanningForest.stream().map(o -> o.weight).collect(Collectors.toList());
        }

        public void findMinSpanningForest() {

            edges.sort(minEdgeComparator);
            minSpanningForest = new HashSet<>();
            findSpanningForest(minSpanningForest, MIN_SPANNING_TREE);
        }

        public void findMaxSpanningForest() {

            edges.sort(maxEdgeComparator);
            maxSpanningForest = new HashSet<>();
            findSpanningForest(maxSpanningForest, MAX_SPANNING_TREE);
        }

        public void findSpanningForest(Set<Tree> resultSpanningForest, int searchingMode) {


            for (Edge edge : edges) {
                int leftNode = edge.nodes[0];
                int rightNode = edge.nodes[1];

                //exclude loop
                if (leftNode == rightNode) continue;

                Tree candidateTreeLeft = null;
                Tree candidateTreeRight = null;
                int newNodeToTree = -1;
                boolean skipThisEdge = false;

                //trying to find edge in the existent trees
                for (Tree tree : resultSpanningForest) {

                    Edge foundLeftNodeEdge = tree.nodes.get(leftNode);
                    Edge foundRightNodeEdge = tree.nodes.get(rightNode);

                    if (foundLeftNodeEdge != null && foundRightNodeEdge != null) {

                        if (foundLeftNodeEdge.equals(foundRightNodeEdge)
                                && Integer.signum(edge.weight - foundLeftNodeEdge.weight) == searchingMode) {
                            tree.edges.add(edge);
                            tree.edges.remove(foundRightNodeEdge);
                        }
                        skipThisEdge = true;

                    } else if (foundLeftNodeEdge != null) {
                        candidateTreeLeft = tree;
                        newNodeToTree = rightNode;

                    } else if (foundRightNodeEdge != null) {
                        candidateTreeRight = tree;
                        newNodeToTree = leftNode;
                    }
                }

                if (skipThisEdge) continue;

                if (candidateTreeLeft == null && candidateTreeRight == null) {
                    Tree newTree = new Tree();
                    newTree.nodes.put(leftNode, edge);
                    newTree.nodes.put(rightNode, edge);
                    newTree.edges.add(edge);
                    newTree.weight = edge.weight;
                    resultSpanningForest.add(newTree);
                } else if (candidateTreeRight == null) {
                    candidateTreeLeft.nodes.put(newNodeToTree, edge);
                    candidateTreeLeft.edges.add(edge);
                    candidateTreeLeft.weight = candidateTreeLeft.weight + edge.weight;
                } else if (candidateTreeLeft == null) {
                    candidateTreeRight.nodes.put(newNodeToTree, edge);
                    candidateTreeRight.edges.add(edge);
                    candidateTreeRight.weight = candidateTreeRight.weight + edge.weight;
                } else {
                    candidateTreeLeft.nodes.putAll(candidateTreeRight.nodes);
                    candidateTreeLeft.edges.addAll(candidateTreeRight.edges);
                    candidateTreeLeft.edges.add(edge);
                    candidateTreeLeft.weight = candidateTreeLeft.weight + candidateTreeRight.weight + edge.weight;
                    resultSpanningForest.remove(candidateTreeRight);
                }
            }
        }

        private static class Edge {
            int weight;
            int[] nodes;
        }

        private static class Tree {
            Map<Integer, Edge> nodes = new HashMap<>();
            Set<Edge> edges = new HashSet<>();
            int weight = 0;
        }

        private static class MaxForestComparator implements Comparator<Edge> {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.weight - o1.weight;
            }
        }

        private static class MinForestComparator implements Comparator<Edge> {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        }

    }
}