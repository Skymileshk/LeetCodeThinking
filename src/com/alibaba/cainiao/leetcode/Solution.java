package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BCG", "CDE", "GEA", "FFF");
    }

    // https://www.acwing.com/video/1347/
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        var dummy = new ListNode(-1);
        dummy.next = head;
        var p = dummy;
        var c = dummy;
        while (p != null) {
            c = p;
            for (int i = 0; i < k && c != null; i++) {
                c = c.next;
            }

            if (c == null) {
                break;
            }

            var a = p.next;
            var b = a.next;
            for (int i = 0; i < k - 1; i++) {
                c = b.next;
                b.next = a;
                a = b;
                b = c;
            }

            c = p.next;
            p.next = a;
            c.next = b;
            p = c;
        }

        return dummy.next;
    }
}
