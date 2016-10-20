package datastructures;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {
    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "Node: " + value;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<Node>();

        Node root = new Node(30);
        nodeList.add(new Node(20));
        nodeList.add(new Node(40));
        nodeList.add(new Node(10));
        nodeList.add(new Node(25));
        nodeList.add(new Node(24));
        nodeList.add(new Node(27));
        nodeList.add(new Node(35));
        nodeList.add(new Node(45));
        nodeList.add(new Node(26));
        nodeList.add(new Node(29));
        nodeList.add(new Node(28));

        for (Node n : nodeList) {
            insertNode(root, n);
        }

        traverseInOrder(root);
        System.out.println("LEEDLES INC");
        printLevelOrder(root);
        // convert(root);
        //
        // while (root.left != null) {
        // root = root.left;
        // }
        //
        // printList(root);
    }

    public static void insertNode(Node root, Node newNode) {
        if (newNode.value < root.value) {
            if (root.left != null) {
                insertNode(root.left, newNode);
            }
            else {
                root.left = newNode;
            }
        }
        else if (newNode.value >= root.value) {
            if (root.right != null) {
                insertNode(root.right, newNode);
            }
            else {
                root.right = newNode;
            }
        }
    }

    public static void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left);
        System.out.println(root.value);
        traverseInOrder(root.right);
    }

    public static void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        traverseInOrder(root.left);
        traverseInOrder(root.right);

    }

    public static void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left);
        traverseInOrder(root.right);
        System.out.println(root.value);
    }

    public static Node convert(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            Node left;
            left = convert(root.left);
            while (left.right != null) {
                left = left.right;
            }

            left.right = root;
            root.left = left;
        }
        if (root.right != null) {
            Node right;
            right = convert(root.right);
            while (right.left != null) {
                right = right.left;
            }

            right.left = root;
            root.right = right;
        }

        return root;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
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

            if (node != null) {
                System.out.print(node.value + " ");
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                nextLvlNodeCount += 2;
            }
            if (currLvlNodeCount == 0) {
                System.out.println("");
                currLvlNodeCount = nextLvlNodeCount;
                nextLvlNodeCount = 0;
            }
        }
    }
}
