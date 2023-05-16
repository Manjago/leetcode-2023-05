public class LeetCode01721 {
    public ListNode swapNodes(ListNode head, int k) {
        // count
        int n = 0;
        {
            ListNode current = head;
            while(current != null) {
                ++n;
                current = current.next;
            }
        }

        // flat to array
        final int[] data = new int[n];
        {
            int index = 0;
            ListNode current = head;
            while(current != null) {
                data[index++] = current.val;
                current = current.next;
            }
        }

        //swap
        {
            final int from = k - 1;
            final int to = n - k;
            final int temp = data[from];
            data[from] = data[to];
            data[to] = temp;
        }

        //rebuild
        final ListNode newHead = new ListNode(data[0]);
        {
            ListNode current = newHead;
            for(int i = 1; i < n; ++i) {
                final ListNode temp = new ListNode(data[i]);
                current.next = temp;
                current = current.next;
            }

            return newHead;
        }
    }
}
