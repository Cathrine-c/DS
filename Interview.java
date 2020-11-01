package java_1101.java;

import java.util.ArrayList;

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

public class Interview {
    public boolean Find(int target, int [][] array) {
        if (array.length==0||array[0].length==0){
            return false;
        }
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if (target==array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }


    public String replaceSpace(StringBuffer str) {
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                str.replace(i,i+1,"20%");
            }
        }
        return str.toString();
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur=listNode;
        ArrayList<Integer> midTemp=new ArrayList<>();
        while (cur!=null){
            midTemp.add(cur.val);
            cur=cur.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i= midTemp.size()-1;i>=0;i--){
            list.add(midTemp.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target=7;
        Interview interview= new Interview();
        //interview.Find(7,array);
        System.out.println(interview.Find(7,array));

    }
}
