package example.leetcode.linkedlist;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/">...</a>
 */
public class DetectCycleInLinkedList {

    //TODO Write main method to test below method

    public boolean hasCycle(ListNode head) {
        ListNode firstRunner = head;
        ListNode secondRunner = head;
        while(secondRunner != null && secondRunner.next != null) {
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next.next;
            if(firstRunner == secondRunner)
                return true;
        }
        return false;
    }
}
