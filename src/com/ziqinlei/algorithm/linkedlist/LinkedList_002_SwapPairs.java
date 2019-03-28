package com.ziqinlei.algorithm.linkedlist;

/**
 * Swap Nodes in Pairs - LeetCode 24
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author ziqin.lei
 * @since 2019-03-28
 */
public class LinkedList_002_SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }

    private static void printSingleLinkedList(ListNode head) {
        System.out.print("single linked list: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        printSingleLinkedList(head);
        printSingleLinkedList(swapPairs(head));
    }
}
