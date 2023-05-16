import java.util.HashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return limitedDisplay(this, 10);
    }

    private String limitedDisplay(ListNode node, int limit) {
        --limit;
        if (node == null) {
            return "null";
        }
        if (limit <= 0) {
            return "ListNode{" +
                    "val=" + node.val +
                    ", next=..." +
                    '}';
        } else {
            return "ListNode{" +
                    "val=" + node.val +
                    ", next=" + limitedDisplay(node.next, limit) +
                    '}';

        }
    }
}
