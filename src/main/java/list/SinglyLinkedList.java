package main.java.list;

/**
 * Implement Linked List with methods to:
 * - insert at the head
 * - insert at the tail
 * - get the size of the linked list
 * - remove at the head
 * - remove at the tail
 **/
public class SinglyLinkedList {
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int size;

    /**
     * Inserts a new node at the head
     * @param value value of node to be added
     */
    public void insertFirst(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Inserts a new node at the tail
     * @param value value of node to be added
     */
    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Returns the size of linked list
     * @return size of linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Removes and returns the node at the head
     * @return node removed at the head
     */
    public Node removeFirst() {
        if (head == null) return null;
        else {
            Node node = head;
            head = head.next;
            size--;
            return node;
        }
    }

    /**
     * Removes and returns the node at the tail
     * @return node removed at the tail
     */
    public Node removeLast() {
        if (tail == null) return null;
        else {
            Node node = tail;
            Node previousToTail = head;
            while (previousToTail.next != tail) {
                previousToTail = previousToTail.next;
            }
            previousToTail.next = null;
            tail = previousToTail;
            size--;
            return node;
        }
    }
}
