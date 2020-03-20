package algorithm.interview;

/**
 * 洋钱罐第一道算法题
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 10 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 10 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        if (null == temp) {
            return temp;
        }

        if (null == temp.next) {
            if (temp.val == val) {
                return null;
            }
        }

        while (temp.val == val) {
            temp = temp.next;
        }

        while (null != temp) {
            if (null != temp.next && val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
