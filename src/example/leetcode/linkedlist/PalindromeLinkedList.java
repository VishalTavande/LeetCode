package example.leetcode.linkedlist;

/****
 * PalindromeLinkedList class.
 *
 * @author vishalta
 * @since 20/07/25
 *
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/">...</a>
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(10);
        list.next = new ListNode(20);
        list.next.next = new ListNode(30);
        list.next.next.next = new ListNode(20);
        list.next.next.next.next = new ListNode(10);

        System.out.println(new PalindromeLinkedList().isPalindrome(list));
    }

    public boolean isPalindrome(ListNode head) {
        //find the mid of the list using 2-pointer technique
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now we have got the mid, start reversing the list from slow pointer
        ListNode secondHead = reverseList(slow);

        //iterate both the heads and see if every node is identical
        ListNode firstHead = head;

        while (firstHead != null && secondHead != null) {
            if (firstHead.val != secondHead.val)
                return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        if (curr != null)
            next = curr.next;

        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return curr == null ? prev : curr;
    }
}
