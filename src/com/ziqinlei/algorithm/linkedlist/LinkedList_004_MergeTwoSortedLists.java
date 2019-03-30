package com.ziqinlei.algorithm.linkedlist;

/**
 * Merge Two Sorted Lists - LeetCode 21
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author Leiziqin
 * @since 2019/3/29
 */
public class LinkedList_004_MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        if (node1.val <= node2.val) {
            node1.next = mergeTwoLists(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoLists(node1, node2.next);
            return node2;
        }
    }

    private static void printLinkedList(ListNode listNode) {
        System.out.print("Linked List: ");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        printLinkedList(listNode1);
        printLinkedList(listNode2);
        printLinkedList(mergeTwoLists(listNode1, listNode2));
    }
}
