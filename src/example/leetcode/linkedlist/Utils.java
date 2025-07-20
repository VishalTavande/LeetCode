package example.leetcode.linkedlist;

public class Utils {

    public static void printList(ListNode head) {
        System.out.println(getListInStringFormat(head));
    }

    public static void printList(String message, ListNode head) {
        System.out.println(message + " : " + getListInStringFormat(head));
    }

    private static String getListInStringFormat(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if(curr.next != null)
                sb.append("->");
            curr = curr.next;
        }
        return sb.toString();
    }
}
