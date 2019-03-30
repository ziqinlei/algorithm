package com.ziqinlei.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * <p>
 * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数。
 *
 * @author Leiziqin
 * @since 2019/3/30
 */
public class LinkedList_008_CopyLinkedListWithRandom {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode rand;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 复制链表
     * 使用 HashMap
     *
     * @param head 头节点
     * @return 复制链表的头节点
     */
    public static ListNode copyLinkedListWithRandom1(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 复制后分开
     *
     * @param head 头节点
     * @return 复制链表的头节点
     */
    public static ListNode copyLinkedListWithRandom2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next;
        // copy and link
        while (cur != null) {
            next = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        ListNode curCopy;
        // set copy listNode rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        cur = head;
        ListNode copyHead = head.next;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return copyHead;
    }

    private static void printRandLinkedList(ListNode head) {
        ListNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode res1;
        ListNode res2;
        printRandLinkedList(head);
        res1 = copyLinkedListWithRandom1(head);
        printRandLinkedList(res1);
        res2 = copyLinkedListWithRandom2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyLinkedListWithRandom1(head);
        printRandLinkedList(res1);
        res2 = copyLinkedListWithRandom2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }
}
