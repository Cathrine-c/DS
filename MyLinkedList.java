package java_1101.java;


class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = next;
    }
}
public class MyLinkedList {
    public Node head;
//头插
    public void addFirst(int data){
        Node node= new Node(data);
        if (this.head == null) {
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }
//尾插
    public void addLast(int data){
        Node node = new Node(data);
        Node cur=this.head;
        if (this.head == null) {
            this.head=node;
            return;
        }
        while (cur.next!=null){
            cur=cur.next;
            cur.next=node;
        }
    }
//判断链表是否包含某个值
    public boolean contains(int key){
        Node cur=this.head;
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

//计算链表长度
    public int size(){
        Node cur=this.head;
        int count = 0;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

//在index位置插入一个新节点
    public void addIndex(int index,int data){
        Node node = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        Node cur=findIndex(index);
        node.next = cur.next;
        cur.next = node;
    }


    private Node findIndex(int index){
        Node cur=this.head;
        if (index < 0 || index > size()) {
            System.out.println("插入位置不合理！");
            return null;
        }
        while (index-1>0){
            cur= cur.next;
            index--;
        }
        return cur;
    }

    //删除值为key的节点
    public void removeKey(int key){
        if (this.head==null){
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev= findPrev(key);
        if (prev == null) {
            System.out.println("没有这个节点！");
            return;
        }
        Node del= prev.next;
        prev.next = del.next;
    }


    private Node findPrev(int key){
        Node prev = this.head;
        while (prev.next!=null){
            if (prev.next.data==key){
                return prev;
            }else{
                prev = prev.next;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur=this.head.next;
        Node prev = this.head;
        while (cur!=null){
            if (cur.data==key){
                prev.next=cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
            if (this.head.data == key) {
                this.head = this.head.next;
            }
        }
    }

//打印链表
    public void display(){
        Node cur=this.head;
        while (cur!=null){
            System.out.println(cur.data+" ");
            cur= cur.next;
        }
    }
}
