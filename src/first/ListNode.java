package first;

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
        StringBuilder stringBuilder = new StringBuilder();
        ListNode temp = this;
        while (temp!= null) {

            stringBuilder.append(",");
            stringBuilder.append(temp.val);
            temp = temp.next;
        }
        if (stringBuilder.length() > 0) {
            return "[" + stringBuilder.substring(1) +
                    ']';
        }
        return "[]";
    }
}
