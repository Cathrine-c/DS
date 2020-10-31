public class TestDemo {

    //找出两个链表公共部分
    public Node getIntersectionNode(Node headA,Node headB) {
        int lenA=0;
        int lenB=0;
        Node pl=headA;
        Node ps=headB;
        int len=lenA-lenB;
        while (pl!=null){
            lenA++;
            pl=pl.next;
        }
        while (ps!=null){
            lenB++;
            ps=ps.next;
        }
        while (len<0){
            pl=headB;
            ps=headA;
        }
        for(int i=0;i<len;i++){
            pl=pl.next;
            len--;
        }
        while (pl!=ps){
            pl=pl.next;
            ps=ps.next;
        }
        if (pl != null) {
            return pl;
        }
        return null;
    }

//把两个有序链表合并成一个单链表
    public Node mergeTwoList(Node headA, Node headB){
        Node newhead=new Node(-1);
        Node tmp=newhead;
        while (headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            }else {
                tmp.next = headB;
                tmp = tmp.next;
                headB=headB.next;
            }
            if(headA!=null){
                headA=headA.next;
                newhead=headA;
            }
            if (headB != null) {
                headB=headB.next;
                newhead=headB;
            }
        }
        return newhead;

    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(1);
       // myLinkedList.addLast(6);
     //   myLinkedList.addLast(9);
        //myLinkedList.insertIndex(6,0);
       // myLinkedList.removeKey(0);

        myLinkedList.display();
        //myLinkedList.reverseList();
        myLinkedList.display();
       // System.out.println(myLinkedList.size());
       // myLinkedList.clear();


    }
}
