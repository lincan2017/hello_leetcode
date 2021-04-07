package first;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        /*ListNode l1 = new ListNode(1);
        ListNode l1Dummy = l1;
        l1 = l1.next = new ListNode(2);
        l1.next = new ListNode(4);

        System.out.println(l1Dummy);

        ListNode l2 = new ListNode(1);
        ListNode l2Dummy = l2;
        l2 = l2.next = new ListNode(3);
        l2.next = new ListNode(4);

        System.out.println(l2Dummy);

        System.out.println(mergeTwoLists(l1Dummy, l2Dummy));*/
        System.out.println(mergeTwoLists(null, null));
        System.out.println(mergeTwoLists(null, new ListNode(0)));

    }
}
