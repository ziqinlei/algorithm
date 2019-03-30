package com.ziqinlei.algorithm.linkedlist;

/**
 * Partition List - LeetCode 86
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author Leiziqin
 * @since 2019/3/30
 */
public class LinkedList_006_PartitionList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode notLessHead = null;
        ListNode notLessTail = null;
        ListNode next;
        while (head != null) {
            if (head.val < x) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else {
                if (notLessHead == null) {
                    notLessHead = head;
                    notLessTail = head;
                } else {
                    notLessTail.next = head;
                    notLessTail = head;
                }
            }
            next = head.next;
            head.next = null;
            head = next;
        }
        if (lessHead == null) {
            return notLessHead;
        }
        lessTail.next = notLessHead;
        return lessHead;
    }

    private static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next.next = new ListNode(3);
        printLinkedList(head1);
        head1 = partition(head1, 5);
        printLinkedList(head1);
    }
}
