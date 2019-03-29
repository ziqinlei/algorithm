package com.ziqinlei.algorithm.linkedlist;

/**
 * 反转单向链表和双向链表
 * 要求：如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)
 *
 * @author ziqin.lei
 * @since 2019-03-28
 */
public class LinkedList_001_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转单向链表
     *
     * @param head 头节点
     * @return 反转后头节点
     */
    public static ListNode reverseSingleLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void printSingleLinkedList(ListNode head) {
        System.out.print("single linked list: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int val) {
            this.val = val;
        }
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("double linked list: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.last;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printSingleLinkedList(head);
        printSingleLinkedList(reverseSingleLinkedList(head));

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseDoubleLinkedList(head2));
    }
}
