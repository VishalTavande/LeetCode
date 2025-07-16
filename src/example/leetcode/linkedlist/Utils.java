package example.leetcode.linkedlist;

public class Utils {

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if(curr.next != null)
                sb.append("->");
            curr = curr.next;
        }
        System.out.println(sb);
    }
}
