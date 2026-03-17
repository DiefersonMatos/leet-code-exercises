package com.matos.addtwonumbers;

/**
 * Solution class to add two numbers represented by linked lists.
 *
 * <p>Each linked list represents a non-negative integer in reverse order,
 * where each node contains a single digit. This class provides a method
 * to add the two numbers and return the result as a new linked list
 * in the same reverse order.</p>
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}