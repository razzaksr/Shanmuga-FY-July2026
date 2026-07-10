package day9;

public class RemoveKthNode {
    public static ListNode removeNth(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int index=0;index<=n;index++)
            first=first.next;
        while(first!=null){
            first=first.next;second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head=removeNth(head, 2);
        while(head!=null){
            System.out.println(head.val);head=head.next;
        }
    }
}
