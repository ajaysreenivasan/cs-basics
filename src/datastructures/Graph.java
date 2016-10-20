package datastructures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    static class Node {
        int value;
        boolean visited;
        List<Node> connections;

        public Node(int value) {
            this.value = value;
            this.visited = false;
            connections = new ArrayList<Node>();
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<Node>();

        for (int i = 1; i <= 9; i++) {
            nodeList.add(new Node(i));
        }

        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = 0; j < nodeList.size(); j++) {
                if (i != j) {
                    if ((nodeList.get(i).value % nodeList.get(j).value) == 0) {
                        nodeList.get(i).connections.add(nodeList.get(j));
                        nodeList.get(j).connections.add(nodeList.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println(nodeList.get(i).value + " " + nodeList.get(i).connections.size());
        }

        System.out.println("LEEDLES INC");
        // dfsRecursive(nodeList.get(590));
        resetGraph(nodeList);

        System.out.println("LEEDLES INC");
        // dfsIterative(nodeList.get(590));

        resetGraph(nodeList);
        System.out.println("LEEDLES INC");
        // bfsIterative(nodeList.get(5));

        resetGraph(nodeList);
        System.out.println("LEEDLES INC");
        // System.out.println("Depth: " + dfsDepth(nodeList.get(8)));

        printLevelOrder(nodeList.get(7));
    }

    public static void dfsRecursive(Node origin) {
        if (!origin.visited) {
            origin.visited = true;

            for (Node connection : origin.connections) {
                if (!connection.visited)
                    dfsRecursive(connection);
            }

            System.out.println(origin.value);
        }
        else {
            return;
        }
    }

    // uses bfs to find shortest path
    public static void findShortestPath(Node origin, Node startNode, Node endNode) {
        HashMap<Node, Node> discoveryMap = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<Node>();

        nodeQueue.add(origin);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            node.visited = true;

            for (Node connection : node.connections) {
                if (!connection.visited) {
                    if (!nodeQueue.contains(connection)) {
                        discoveryMap.put(connection, node);
                        nodeQueue.add(connection);
                    }
                }
            }
        }

        List<Node> shortestPath = new ArrayList<>();
        Node curNode = endNode;
        while (curNode != null) {
            shortestPath.add(curNode);
            curNode = discoveryMap.get(curNode);
        }

        Collections.reverse(shortestPath);
        for (Node node : shortestPath) {
        	System.out.println(node.value + "->");
            // System.out.print("[" + node.x + ", " + node.y + "]");
            // if (!node.value.equals("B"))
            // System.out.print(" -> ");
        }

        System.out.println("");
    }

    public static int dfsDepth(Node origin) {
        List<Integer> depths = new ArrayList<Integer>();
        depths.add(1);
        if (!origin.visited) {
            for (Node connection : origin.connections) {
                int depth = dfsDepth(connection) + 1;
                depths.add(depth);
            }

            origin.visited = true;
        }
        return Collections.min(depths) + 1;
    }

    public static void dfsIterative(Node origin) {
        Stack<Node> nodeStack = new Stack<Node>();

        nodeStack.add(origin);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();

            node.visited = true;

            for (Node connection : node.connections) {
                if (!connection.visited && !nodeStack.contains(connection)) {
                    nodeStack.push(connection);
                }
            }

            System.out.println(node.value);
        }
    }

    public static void bfsIterative(Node origin) {
        Queue<Node> nodeQueue = new LinkedList<Node>();

        nodeQueue.add(origin);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            node.visited = true;

            for (Node connection : node.connections) {
                if (!connection.visited) {
                    nodeQueue.add(connection);
                }
            }

            System.out.println(node.value);

        }
    }

    public static void resetGraph(List<Node> nodeList) {
        for (Node node : nodeList) {
            node.visited = false;
        }
    }

    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(root);

        int currLvlNodeCount = 1;
        int nextLvlNodeCount = 0;

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            currLvlNodeCount--;

            node.visited = true;

            if (node != null) {
                System.out.print(node.value + " ");

                for (Node n : node.connections) {
                    if (!n.visited) {
                        nodeQueue.add(n);
                        nextLvlNodeCount++;
                    }
                }
            }
            if (currLvlNodeCount == 0) {
                System.out.println("");
                currLvlNodeCount = nextLvlNodeCount;
                nextLvlNodeCount = 0;
            }
        }
    }

    public void findAllCycles(Node origin) {

    }
}
