package com.ziqinlei.algorithm.linkedlist;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数x。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于x的节点，中间部分都是值等于x的节点，右部分都是值大于x的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，x=3。调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
 * 总之，满足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。
 * 对某部分内部的节点顺序不做要求。
 * <p>
 * 进阶：在原问题的要求之上再增加如下两个要求。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致。
 * 例如：链表9->0->4->5->1，x=3。调整后的链表是0->1->9->4->5。
 * 在满足原问题要求的同时，左部分节点从左到右为0、1。在原链表中也是先出现0，后出现1；中间部分在本例中为空，不再讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，最后出现5。
 * 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 *
 * @author Leiziqin
 * @since 2019/3/30
 */
public class LinkedList_007_PartitionListII {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 不要求顺序
     *
     * @param head 头节点
     * @param x    分割值
     * @return 排序后头节点
     */
    public static ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        ListNode[] arr = new ListNode[length];
        for (int i = 0; i < length; i++) {
            arr[i] = cur;
            cur = cur.next;
        }
        arrPartition(arr, x);
        for (int i = 1; i < length; i++) {
            arr[i - 1].next = arr[i];
        }
        arr[length - 1].next = null;
        return arr[0];
    }

    private static void arrPartition(ListNode[] arr, int x) {
        int lt = 0;
        int gt = arr.length - 1;
        int i = 0;
        while (i <= gt) {
            if (arr[i].val < x) {
                swap(arr, lt++, i++);
            } else if (arr[i].val > x) {
                swap(arr, gt--, i);
            } else {
                i++;
            }
        }
    }

    private static void swap(ListNode[] arr, int i, int j) {
        ListNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 进阶
     *
     * @param head 头节点
     * @param x    分割值
     * @return 排序后头节点
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
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
            } else if (head.val == x) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = head;
                    greaterTail = head;
                } else {
                    greaterTail.next = head;
                    greaterTail = head;
                }
            }
            next = head.next;
            head.next = null;
            head = next;
        }
        if (lessTail != null) {
            lessTail.next = equalHead;
            equalTail = equalTail != null ? equalTail : lessTail;
        }
        if (equalTail != null) {
            equalTail.next = greaterHead;
        }
        if (lessHead != null) {
            return lessHead;
        }
        return equalHead != null ? equalHead : greaterHead;
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
        ListNode head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(3);
        printLinkedList(head);
        int x = 5;
        // printLinkedList(partition1(head, x));
        printLinkedList(partition2(head, x));
    }
}