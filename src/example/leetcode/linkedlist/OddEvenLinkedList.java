package example.leetcode.linkedlist;

/****
 * OddEvenLinkedList class.
 *
 * @author vishalta
 * @since 20/07/25
 *
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/">...</a>
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();

        ListNode list = new ListNode(2);
        list.next = new ListNode(1);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next = new ListNode(80);
        list.next.next.next.next.next.next.next.next = new ListNode(90);

        Utils.printList("Before", list);
        Utils.printList("After", obj.oddEvenList(list));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHeadNode = evenNode;

        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            evenNode.next = evenNode.next.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHeadNode;

        return head;
    }
}
