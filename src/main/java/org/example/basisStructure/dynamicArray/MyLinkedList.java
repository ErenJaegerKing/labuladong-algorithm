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



        /*---------------------*/
        //查/改
        //双链表的遍历/查找/修改
        DoublyListNode head1 = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5});

        // 从头遍历双链表
        for (DoublyListNode p5 = head1; p5 != null; p5 = p5.next) {
            System.out.println(p5.val);
        }
        //1 -> 2 -> 3 -> 4 -> 5
        // 从尾遍历双链表（假设我们有尾节点的引用 tail）
        // for (DoublyListNode p = tail; p != null; p = p.prev) {
        //   System.out.println(p.val);
        // }

        //增
        //在双链表头部插入新元素
        DoublyListNode newHead1 = new DoublyListNode(0);
        newHead1.next = head1;
        head1.prev = newHead1;
        head1 = newHead1;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5

        //在双链表尾部插入新元素
        DoublyListNode tail = head1;
        while (tail.next != null) {
            tail = tail.next;
        }

        // 在双链表尾部插入新节点 6
        DoublyListNode newNode1 = new DoublyListNode(6);
        tail.next = newNode1;
        newNode1.prev = tail;
        tail = newNode1;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

        //在双链表中间插入新元素 假设是第 3 个节点后面插入 66
        DoublyListNode dp1 = head1;
        for (int i = 0; i < 2; i++) {
            dp1 = dp1.next;
        }

        // 组装新节点
        DoublyListNode newNode2 = new DoublyListNode(66);
        newNode2.next = dp1.next;
        newNode2.prev = dp1;

        // 插入新节点
        dp1.next.prev = newNode2;
        dp1.next = newNode2;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 66 -> 4 -> 5 -> 6

        //删
        //在双链表中删除一个节点
        // 删除第 4 个节点
        // 先找到第 3 个节点
        DoublyListNode dp2 = head1;
        for (int i = 0; i < 2; i++) {
            dp2 = dp2.next;
        }

        // 现在 p 指向第 3 个节点，我们它后面那个节点摘除出去
        DoublyListNode toDelete = dp2.next;

        // 把 toDelete 从链表中摘除
        dp2.next = toDelete.next;
        toDelete.next.prev = dp2;

        // 把 toDelete 的前后指针都置为 null 是个好习惯（可选）
        toDelete.next = null;
        toDelete.prev = null;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

        //在双链表头部删除元素
        DoublyListNode toDelete1 = head1;
        head1 = head1.next;
        head1.prev = null;

        // 清理已删除节点的指针
        toDelete1.next = null;
        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5 -> 6

        //在双链表尾部删除元素
        DoublyListNode tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        // 现在 p 指向尾节点
        // 把尾节点从链表中摘除
        tail1.prev.next = null;
        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5

    }

}
