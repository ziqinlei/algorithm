package com.ziqinlei.algorithm.linkedlist;

/**
 * 打印两个链表的公共部分
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 *
 * @author Leiziqin
 * @since 2019/3/29
 */
public class LinkedList_003_PrintCommonPart {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void printCommonPart(ListNode head1, ListNode head2) {
        System.out.print("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.print(head1.val + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
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
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(6);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(5);
        listNode2.next.next.next = new ListNode(7);
        listNode2.next.next.next.next = new ListNode(8);

        printLinkedList(listNode1);
        printLinkedList(listNode2);
        printCommonPart(listNode1, listNode2);
    }
}
