package java16_1020.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapInterview {
    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    //复制带随机指针的链表
    public Node copyRandomList(Node head){
        Map<Node,Node> map=new HashMap<>();
        //遍历链表
        for(Node cur=head;cur!=null;cur=cur.next){
            map.put(cur,new Node(cur.val));
        }
        //再遍历一遍链表得到新链表
        for (Node cur=head;cur!=null;cur=cur.next){
            Node newCur=map.get(cur);
            newCur.next=map.get(cur.next);//通过旧链表.next得到新链表.next
            newCur.random=map.get(cur.random);
        }
        return map.get(head);
    }

    //石头中有多少颗宝石
    public int numJewelsInstones(String J,String S){
        Set<Character> set=new HashSet<>();
        for (char c:J.toCharArray()){
            set.add(c);
        }

        int ret=0;
        for (char c:S.toCharArray()){
            if (set.contains(c)){
                ret++;
            }
        }
        return ret;
    }

}
