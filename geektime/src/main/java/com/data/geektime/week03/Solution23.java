package com.data.geektime.week03;

import com.data.entity.ListNode;

/**
 * 合并k个升序链表
 */
public class Solution23 {

  // 分治 + 归并排序
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    return mergeList(lists, 0, lists.length - 1);
  }

  // 合并lists[left, right]的升序链表
  private ListNode mergeList(ListNode[] lists, int left, int right) {
    // base case
    if (left == right) {
      return lists[left];
    }

    int mid = (left + right) / 2;

    ListNode l1 = mergeList(lists, left, mid);
    ListNode l2 = mergeList(lists, mid + 1, right);

    return merge(l1, l2);
  }

  // 合并两个升序链表
  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    pre.next = l1 != null ? l1 : l2;

    return dummy.next;
  }

}
