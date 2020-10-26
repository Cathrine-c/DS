package java_1023.java;

class Node{

     Node left;
     Node right;
     int key;

    public Node(int key) {

        this.left = left;
        this.right = right;
        this.key = key;
    }
}

/**
 * 二叉搜索树：左子树的值小于根结点的值，右子树的值大于根结点的值
 * 往树中插入新节点，只能插到叶子结点
 */
public class BinarySearchTree {
    //根结点，root为null的时候表示这是个空树
    private Node root=null;
    public Node find(int key) {
        //查找key是否在树中存在，如果存在返回对应的Node
        Node cur = root;
        while (cur != null){
            if (key<cur.key){
                //去左子树中找
                cur=cur.left;
            } else if (key > cur.key) {
                //去右子树中找
                cur=cur.right;
            }else{
                return cur;
            }
        }
        //循环结束了也没找到，key就不存在
        return null;
    }


    //二叉搜索树中不允许存在相同key的元素
    //如果发现新插入的key和树中节点重复了，那就插入失败了，返回false
    //插入成功，返回true

    public boolean insert(int key){
        if (root==null){
            //如果为空树，直接让root指向key对应的新节点即可
            root= new Node(key);
            return true;
        }
        //和查找类似，需要先找到合适位置，再去插入元素
        Node cur=root;
        Node parent = null;//parent始终指向cur的父节点，和链表插入类似
        while (cur!=null){
            if (key < cur.key) {
                parent=cur;
                cur=cur.left;
            } else if (key > cur.key) {
                parent=cur;
                cur=cur.right;
            }else{
                //如果当前树存的只是key，发现相同的key就以为插入失败
                //如果当前树存的是键值对，发现相同的key就修改值即可
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
