package example.leetcode;

import static example.leetcode.Utils.printList;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/">...</a>
 */

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode commonNode = new ListNode(5);

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = commonNode;

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = new ListNode(8);
        listB.next.next.next.next = new ListNode(4);
        listB.next.next.next.next.next = commonNode;

        printList(listA);
        printList(listB);

        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        ListNode node = solution.getIntersectionNode(listA, listB);
        System.out.println(node.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int lengthA, lengthB;
        lengthA = findLength(headA);
        lengthB = findLength(headB);

        int skipPositions = lengthA > lengthB ? lengthA-lengthB : lengthB-lengthA;

        if (lengthA > lengthB) {
            headA = skipListByPositions(headA, skipPositions);
        } else {
            headB = skipListByPositions(headB, skipPositions);
        }

        while (headA != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private ListNode skipListByPositions(ListNode head, int skipPositions) {
        while (skipPositions-- > 0)
            head = head.next;
        return head;
    }

    private int findLength(ListNode node) {
        int length = 1;
        ListNode head = node;
        while(head.next != null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
