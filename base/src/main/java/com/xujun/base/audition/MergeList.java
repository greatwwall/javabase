package com.xujun.base.audition;

/**
  * @todo 实现合并两个排序的链表
  * @author xujun
  * @version 1.0
  * @date 2018年4月28日 下午12:29:47 
  */

public class MergeList {

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2; // 判断到某个链表为空就返回另一个链表。如果两个链表都为空呢？没关系，这时候随便返回哪个链表，不也是空的吗?
        if (list2 == null)
            return list1;
        ListNode list0 = null;// 定义一个链表作为返回值
        if (list1.val < list2.val) {// 判断此时的值，如果list1比较小，就先把list1赋值给list0，反之亦然
            list0 = list1;
            list0.next = merge(list1.next, list2);// 做递归，求链表的下一跳的值
        } else {
            list0 = list2;
            list0.next = merge(list1, list2.next);
        }
        return list0;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode result = merge(list1, list2);
        ListNode temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", next=" + next + "]";
    }

}
