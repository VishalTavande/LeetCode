package example.leetcode;

/****
 * Solution to leetcode problem <a href="https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/">...</a>
 */

public class MyLinkedList {

    private ListNode head, tail;
    private int size;

    public int get(int index) {
        if(index < 0 || index > size-1 || head == null) {
            return -1;
        }

        if(index == 0) {
            return head.val;
        }

        ListNode curr = head;
        int count = 0;
        while(count++ < index) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = head;
        head = node;
        if(size == 0) {
            tail = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if(size == 0) {
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode();
        node.val = val;
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }

        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == size) {
            addAtTail(val);
            return;
        }

        ListNode node = new ListNode();
        node.val = val;

        if(head == null) {
            head = node;
            tail = node;
        } else {
            ListNode curr = head;
            int count = 0;
            while(count++ < index-1) {
                curr = curr.next;
            }
            ListNode nextNode = curr.next;
            curr.next = node;
            node.next = nextNode;
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index > size-1 || head == null) {
            return;
        }

        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }

        //check if deleting head
        if(index == 0) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            size--;
            return;
        }

        //check if deleting tail
        if(index == size-1) {
            ListNode curr = head;
            ListNode prev = head;
            while(curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            tail = prev;
            size--;
            return;
        }

        //if deleting any middle node
        ListNode curr = head;
        int count = 0;
        while(count < index-1) {
            curr = curr.next;
            count++;
        }
        ListNode temp = curr.next;
        curr.next = temp.next;
        temp.next = null;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(38);              // 38
        myLinkedList.addAtTail(66);    // 38,66
        myLinkedList.addAtTail(61);
        myLinkedList.addAtTail(76);
        myLinkedList.addAtTail(26);
        myLinkedList.addAtTail(37);
        myLinkedList.addAtTail(8);    //38,66,61,76,26,37,8
        myLinkedList.deleteAtIndex(5);    //38,66,61,76,26,8
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(45);   //45,4,38,66,61,76,26,8
        System.out.println(myLinkedList.get(4)); //61
        myLinkedList.addAtTail(85);
        myLinkedList.addAtHead(37);    // 37,45,4,38,66,61,76,26,8,85
        System.out.println(myLinkedList.get(5)); //61
        myLinkedList.addAtTail(93); //37,45,4,38,66,61,76,26,8,85,93
        myLinkedList.addAtIndex(10,23); //37,45,4,38,66,61,76,26,8,85,23,93
        myLinkedList.addAtTail(21); //37,45,4,38,66,61,76,26,8,85,23,93
        myLinkedList.addAtHead(52);
        myLinkedList.addAtHead(15);
        myLinkedList.addAtHead(47); // 47,15,52,37,45,4,38,66,61,76,26,8,85,23,93,21,52,15
        System.out.println(myLinkedList.get(12)); //85
        myLinkedList.addAtIndex(6, 24); // 47,15,52,37,45,4,24,38,66,61,76,26,8,85,23,93,21,52,15
        myLinkedList.addAtHead(64); // 64,47,15,52,37,45,4,24,38,66,61,76,26,8,85,23,93,21,52,15
        System.out.println(myLinkedList.get(4)); //37
        myLinkedList.addAtHead(31); // 31,64,47,15,52,37,45,4,24,38,66,61,76,26,8,85,23,93,21
        myLinkedList.deleteAtIndex(6); //31,64,47,15,52,37,4,24,38,66,61,76,26,8,85,23,93,21
        myLinkedList.addAtHead(40);
        myLinkedList.addAtTail(17);
        myLinkedList.addAtTail(15);
        myLinkedList.addAtIndex(19,2);
        myLinkedList.addAtTail(11);
        myLinkedList.addAtHead(86);
        System.out.println(myLinkedList.get(17));
        myLinkedList.addAtTail(55);
        myLinkedList.deleteAtIndex(15);
        myLinkedList.addAtIndex(14,95);

    }
}
