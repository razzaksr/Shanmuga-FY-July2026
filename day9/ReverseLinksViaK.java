package day9;

class ListNode{
    int val;
    ListNode next;
    ListNode(int v){val=v;}
}

public class ReverseLinksViaK {
    public static ListNode reverse(ListNode head, int k){
        if(head==null||k==1) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pGrpEnd = dum;
        while(true){
            ListNode kthNode = formGroup(pGrpEnd, k);
            if(kthNode==null) break;
            ListNode gStart = pGrpEnd.next;
            ListNode nStart = kthNode.next;
            // reverse
            ListNode prev = nStart;
            ListNode cur = gStart;
            while(cur!=nStart){
                ListNode temp = cur.next;
                cur.next = prev;
                prev=cur;cur=temp;
            }
            pGrpEnd.next = kthNode;
            pGrpEnd = gStart;
        }
        return dum.next;
    }
    public static ListNode formGroup(ListNode node, int k){
        while(node!=null&&k>0){
            node=node.next;
            k--;
        }
        return node;
    }
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reversed = reverse(head, 2);
        while(reversed!=null){
            System.out.println(reversed.val+" ");
            reversed=reversed.next;
        }
    }
}
