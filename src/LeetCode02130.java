public class LeetCode02130 {
    public int pairSum(ListNode head) {

        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            ++count;
        }

        final int[] data = new int[count];
        count = 0;
        temp = head;
        while(temp != null) {
            data[count] = temp.val;
            temp = temp.next;
            ++count;
        }

        int max = -1;
        int i = 0;
        int j = count - 1;
        while(i < j) {
            max = Math.max(max, data[i++] + data[j--]);
        }

        return max;
    }
}
