package org.example.basisStructure.dynamicArray;

/**
 * @Author: erenjaeger
 * @Date: 2024/5/6 18:12
 */
public class MyLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 输入一个数组，转换为一条单链表
    static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    static class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int x) {
            val = x;
        }
    }

    //用于创建一条双链表
    static DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        //单链表的遍历/查找/修改
        //查/改
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5

        //增
        //在单链表头部插入新元素
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5

        //在单链表尾部插入新元素
        ListNode p1 = head;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = new ListNode(6);
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //在单链表中间插入新元素
        ListNode p2 = head;
        for (int i = 0; i < 2; i++) {
            p2 = p2.next;
        }
        ListNode newNode = new ListNode(66);
        newNode.next = p2.next;
        p2.next = newNode;
        // 现在链表变成了 1 -> 2 -> 3 -> 66 -> 4 -> 5 -> 6

        //删
        // 删除第 4 个节点
        ListNode p3 = head;
        for (int i = 0; i < 2; i++) {
            p3 = p3.next;
        }
        p3.next = p3.next.next;
        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5 -> 6

        //在单链表尾部删除元素
        ListNode p4 = head;
        while (p4.next.next != null) {
            p4 = p4.next;
        }
        p4.next = null;
        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5

        //在单链表头部删除元素
        head = head.next;
        // 现在链表变成了 2 -> 3 -> 4 -> 5


    }

}
