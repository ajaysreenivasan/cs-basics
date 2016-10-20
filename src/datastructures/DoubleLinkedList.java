package datastructures;
import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {
    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<Node>();

        DoubleLinkedList.Node head = new DoubleLinkedList.Node(30);
        nodeList.add(new Node(20));
        nodeList.add(new Node(40));
        nodeList.add(new Node(10));
        nodeList.add(new Node(25));
        nodeList.add(new Node(24));
        nodeList.add(new Node(27));
        nodeList.add(new Node(35));
        nodeList.add(new Node(45));
        nodeList.add(new Node(29));
        nodeList.add(new Node(28));

        for (Node n : nodeList) {
            insertNode(head, n);
        }

        fPrintList(head);
        System.out.println("---------");

        head = deleteNode(head, 45);

        fPrintList(head);
        System.out.println("---------");
        rPrintList(head);

        System.out.println(searchList(head, 45));
    }

    public static void insertNode(Node head, Node newNode) {
        Node cursor = head;

        while (cursor.next != null) {
            cursor = cursor.next;
        }

        cursor.next = newNode;
        newNode.prev = cursor;
    }

    static Node deleteNode(Node head, int value) {
        Node cursor = head;

        if (cursor.value == value) {
            head = head.next;
            head.prev = null;
            return head;
        }

        while (cursor.next != null) {
            if (cursor.next.value == value) {
                break;
            }

            cursor = cursor.next;
        }

        if (cursor.next == null) {
            cursor = null;
        }
        else {
            cursor.next = cursor.next.next;
            cursor.next.next.prev = cursor;
        }

        return head;
    }

    static boolean searchList(Node head, int value) {
        boolean isFound = false;
        Node cursor = head;

        while (cursor != null) {
            if (cursor.value == value) {
                isFound = true;
                break;
            }
            cursor = cursor.next;
        }

        return isFound;
    }

    static void fPrintList(Node head) {
        Node cursor = head;
        int i = 1;
        while (cursor != null) {
            System.out.println(i + ". " + cursor);
            cursor = cursor.next;
            i++;
        }
    }

    static void rPrintList(Node head) {
        Node cursor = head;
        int i = 1;

        while (cursor.next != null) {
            cursor = cursor.next;
            i++;
        }

        while (cursor != null) {
            System.out.println(i + ". " + cursor);
            cursor = cursor.prev;
            i--;
        }
    }
}
