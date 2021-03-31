package first;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode extractNode = new ListNode();
        extractNode.next = head;

        ListNode n1 = extractNode;
        ListNode n2 = extractNode;

        for (int i=0; i<n; i++) {
            n2 = n2.next;
        }

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        n1.next = n1.next.next;
        return extractNode.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);

        ListNode listNode = removeNthFromEnd(test, 2);
        System.out.println(listNode);

    }


}
