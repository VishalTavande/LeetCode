package example.leetcode.linkedlist;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/">...</a>
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements obj = new RemoveLinkedListElements();

        ListNode list = new ListNode(10);
        list.next = new ListNode(10);
        list.next.next = new ListNode(10);
        list.next.next.next = new ListNode(10);
        list.next.next.next.next = new ListNode(10);

        Utils.printList("Before", list);
        Utils.printList("After", obj.removeElements(list, 10));
    }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            if(current.val == val) {
                ListNode temp = current;
                if (previous == null) {
                    current = current.next;
                    head = current;
                } else {
                    previous.next = current.next;
                    current = current.next;
                }
                temp.next = null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        return head;
    }
}
