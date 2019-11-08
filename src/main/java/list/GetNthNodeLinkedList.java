package main.java.list;

/**
 * Write a function to get Nth Node in a linked list
 * n >= 0
 */
public class GetNthNodeLinkedList {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * @param n position of node in the LinkedList
     * @param head head of LinkedList
     * @return Nth node in the LinkedList
     */
    public ListNode getNthNode(int n, ListNode head) {
        if (n == 0) return head;
        if (n == 1) {
            if (head != null) return head.next;
            else throw new IndexOutOfBoundsException();
        }
        ListNode node = head;
        int count = n / 2;
        while (count > 0 && node != null && node.next != null) {
            node = node.next.next;
            count--;
        }
        if (count != 0) throw new IndexOutOfBoundsException();
        // if n is even return node else return node.next
        return n % 2 == 0 ? node : node.next;
    }
}
