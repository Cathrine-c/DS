package java16_0328.java;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val) {
        //this.data = data;
        this.val = val;
    }
}


public class doubleLinkedList {

    public ListNode head;
    public ListNode last;

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head != null&& last!= null) {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }else{
            this.head = node;
            this.last = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }


    private ListNode findIndex(int index) {
        ListNode cur = this.head;
        while(index>0) {
            cur = cur.next;
            index --;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        //ListNode cur = new ListNode(data);
        if(index<0||index>size()) {
            return;
        }
        if(index==0) {
            addFirst(data);
            return;
        }
        if(index==size()) {
            addLast(data);
            return;
        }
        ListNode cur = findIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }




    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur!=null) {
            if(cur.val==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }




    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                //当前cur是不是头结点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    //cur是否为尾结点
                } else {
                    cur.prev.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }



    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }


    public void display(){
        ListNode cur = this.head;
        while(cur != null) {
            System.out.println(cur.val+" ");
            cur = cur.next;
        }
    }


    public void clear(){
        this.head = null;
        this.last = null;
    }
}

