package org.itavgur;

import java.util.*;
import java.util.stream.Collectors;

public class SpanningTree {

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

    private void findSpanningForest(Set<Tree> resultSpanningForest, int searchingMode) {


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