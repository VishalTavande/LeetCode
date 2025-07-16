package example.leetcode;

public class Utils {

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if(curr != null)
                System.out.print("->");
        }
        System.out.println();
    }
}
