package day9;

class Node{
    int val;
    Node next, random;
    Node(int v){val=v;}
}

public class CopyInLinkedViaRandom {
    public static Node copyRandom(Node head){
        if(head==null) return null;
        Node cur=head;
        while(cur!=null){
            Node copy = new Node(cur.val);
            copy.next=cur.next;
            cur.next=copy;
            cur=copy.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur=head;
        Node copyHead = head.next;
        while(cur!=null){
            Node copy=cur.next;
            cur.next = copy.next;
            if(copy.next!=null)
                copy.next=copy.next.next;
            cur=cur.next;
        }
        return copyHead;
    }
    public static void main(String[] args) {
        Node n1=new Node(7);
        Node n2=new Node(13);
        Node n3=new Node(11);
        Node n4=new Node(10);
        Node n5=new Node(1);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
        n2.random=n1;n3.random=n5;n4.random=n3;
        n5.random=n1;
        Node newHead = copyRandom(n1);
        // print 
        Node cur = newHead;
        while(cur!=null){
            System.out.println("Value is:"+cur.val+
                ", random: "+
                (cur.random!=null?cur.random.val:"null")
            );
            cur=cur.next;
        }
    }
}
