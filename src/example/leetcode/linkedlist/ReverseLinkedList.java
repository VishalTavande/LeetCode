package example.leetcode.linkedlist;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/">...</a>
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();

        ListNode list = new ListNode(10);
        list.next = new ListNode(20);
        list.next.next = new ListNode(30);
        list.next.next.next = new ListNode(40);
        list.next.next.next.next = new ListNode(50);

        Utils.printList(list);
        ListNode reverseList = obj.reverseList(list);
        Utils.printList(reverseList);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        if(curr != null)
            next = curr.next;

        while(next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return curr == null ? prev : curr;
    }


}

// 10,20,30,40,50