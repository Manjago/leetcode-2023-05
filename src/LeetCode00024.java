public class LeetCode00024 {

    public static void main(String[] args) {
        final LeetCode00024 solver = new LeetCode00024();
        // 1, 2, 3
        final var data = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(data);
        System.out.println(solver.swapPairs(data));
    }

    public ListNode swapPairs(ListNode head) {
        final ListNode[] answer = new ListNode[3];
        internalSwapPairs(head, answer);
        ListNode newHead = answer[0];
        ListNode nextHead = answer[1];
        ListNode next = answer[2];
        if (newHead == null) {
            return null;
        } else if (nextHead == null) {
            return newHead;
        }
        final ListNode realAnswer = newHead;

        while(newHead != null && nextHead != null) {
            internalSwapPairs(next, answer);
            nextHead.next = answer[0];
            newHead = answer[0];
            nextHead = answer[1];
            next = answer[2];
        }

        return realAnswer;
    }

    private void internalSwapPairs(ListNode head, ListNode[] answer) {
        if (head == null) {
            answer[0] = null;
            return;
        }
        if (head.next == null) {
            answer[0] = head;
            answer[1] = null;
            return;
        }

        ListNode first = head;
        ListNode second = first.next;
        ListNode next = second.next;

        second.next = first;
        first.next = next;
        answer[0] = second;
        answer[1] = first;
        answer[2] = next;
    }
}
