package com.data.geektime.week01;

import com.data.entity.ListNode;

// 21.合并两个有序链表，生成一个新链表
public class Solution21 {

  // 和归并排序的merge差不多
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode pre = dummyHead;

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

    // 经过上述过程后,l1和l2最多有一个为null,加到pre的next即可
    pre.next = l1 != null ? l1 : l2;

    return dummyHead.next;

  }

}
