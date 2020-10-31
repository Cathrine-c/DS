

class Node{
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
public class MyLinkedList {
    public Node head;

    public void addFirst(int data){
        Node node=new Node(data);
        if (this.head == null) {
            this.head=node;
            return;
        }
        node.next=head;
        head=node;
    }

    public void addLast(int data){
        Node node=new Node(data);
        Node cur=this.head;
        if(this.head==null){
            this.head=node;
        }
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }

    public void insertIndex(int index,int data){
        Node node=new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Node cur=findIndex(index);
        //Node del=cur.next;
       // cur.next=node;
       // node.next=del;

        node.next=cur.next;
        cur.next=node;
    }

    private Node findIndex(int index) {
        if(index<0||index>size()){
            System.out.println("插入位置不合理");
        }
        Node cur=this.head;
        while (index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }

    public boolean contains(int key){
        Node cur=this.head;
        while (cur!=null){
            if (cur.data == key) {
                return true;
            }
           cur=cur.next;
        }
        return false;
    }

    public void removeKey(int key){
        Node cur=this.head;
        if(this.head==null){
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next.next;
            return;
        }
        Node prev=findKey(key);
        if(prev==null){
            System.out.println("没有此节点");
            return;
        }
        Node del=prev.next;
        prev.next=del.next;
    }

    private Node findKey(int key){
        Node prev=this.head;
        while (prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    public void removeAllKey(int key){
        Node prev=this.head;
        Node cur=prev.next;
        while (cur!=null){
            if (prev.data == key) {
                prev.next=cur.next;
                cur=cur.next;
            }else {
                prev=cur;
                cur=cur.next;
            }
        }
        if (this.head.data == key) {
            this.head=this.head.next;
            return;
        }
    }

    public void display(){
        Node cur=this.head;
        while (cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public int size(){
        Node cur=this.head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    public void clear(){
        this.head=null;
    }

    //反转单链表
    public Node reverseList(Node head){
        Node cur=this.head;
        Node prev=null;
        Node newhead=null;

        while (cur!=null){
             Node curNext=cur.next;
            if (curNext == null) {
                newhead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=cur.next;
        }
        return newhead;
    }

    public Node reversePrint() {
        Node newhead=null;
        Node cur=this.head;
        Node prev=null;
        if(this.head==null){
            newhead=cur;
        }
        while (cur!=null) {
            Node curNext = cur.next;
            if (cur.next == null) {
                newhead = cur;
                int[] array={cur.data};
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
            int[] array={cur.data};
        }
        return cur;

    }

}
