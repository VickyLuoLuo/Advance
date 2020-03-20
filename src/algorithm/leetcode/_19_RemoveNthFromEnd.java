package algorithm.leetcode;

public class _19_RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sourceHead = head;
        int length = 1;
        while (null != head.next) {
            head = head.next;
            length ++;
        }
        int i = length - n;
        while (i > 0) {
            sourceHead = sourceHead.next;
            i --;
        }
        sourceHead.next = sourceHead.next.next;
        return sourceHead;
    }
}

