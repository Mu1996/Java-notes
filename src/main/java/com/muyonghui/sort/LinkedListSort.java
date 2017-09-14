package com.muyonghui.sort;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LinkedListSort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        // /待左右两边各自有序，进行归并即可
        ListNode temp_head = new ListNode(0);
        ListNode temp_node = temp_head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp_node.next = left;
                left = left.next;
            } else {
                temp_node.next = right;
                right = right.next;
            }
            temp_node = temp_node.next;
        }
        if (left != null)
            temp_node.next = left;
        if (right != null)
            temp_node.next = right;
        return temp_head.next;
    }

    //插入排序
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next== null)
            return head;
        ListNode root = new ListNode(0); // 头结点
        root.next = head;
        ListNode p = head;
        ListNode q;
        ListNode r;

        while (p != null && p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            }else {
                q = p.next;
                p.next = q.next;

                r = root;
                // 找第一个大于等于q.val的前驱结点，因为在root.next到p之间必定存在这样的结点
                while (r.next.val <= q.val) {
                    r = r.next;
                }

                q.next = r.next;
                r.next = q;
            }
        }

        return root.next;

    }

}
