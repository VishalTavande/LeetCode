package example.leetcode.linkedlist;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/">two-pointer-technique...</a>
 */
public class DetectCycle2InLinkedList {

    //TODO Write main method to test below method

    public ListNode detectCycle(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while(fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(slowRunner == fastRunner) {
                slowRunner = head;
                while(slowRunner != fastRunner) {
                    slowRunner = slowRunner.next;
                    fastRunner = fastRunner.next;
                }
                return slowRunner;
            }
        }
        return null;
    }
}
