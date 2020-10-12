

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树笔试题
 */

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class InterviewTree {

    //前序遍历：List实现
    public List<Integer> preOrderTraversal(Node root){
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
            //返回空List
        }
        result.add((int) root.val);
        result.addAll(preOrderTraversal(root.left));
        result.addAll(preOrderTraversal(root.right));
        return result;
    }


    public List<Integer> inOrderTraversal(Node root){
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inOrderTraversal(root.left));
        result.add((int) root.val);
        result.addAll(inOrderTraversal(root.right));
        return result;
    }


    public List<Integer> postOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inOrderTraversal(root.left));
        result.addAll(inOrderTraversal(root.right));
        result.add((int) root.val);
        return result;
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q == null) {
            return true;
        }
        if (p==null||q == null){
            return false;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }


    //判断t是否为s的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s==null||t==null){
            return false;
        }
        boolean ret=false;
       if (s.val==t.val){
            ret = isSameTree(s,t);
            return ret;
        }
       /*
        if (!ret){
            ret=isSubtree(s.left,t);
        }
        if (!ret){
            ret=isSubtree(s.right,t);
        }*/
        return ret||isSubtree(s.left,t)||isSubtree(s.right,t);
    }


    //求一棵树的最大深度/高度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return 1+leftDepth>rightDepth?leftDepth:rightDepth;
    }


    //判断二叉树是否为平衡二叉树
    public boolean isBalanced(TreeNode root){
        if (root==null){
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
       if(maxDepth(root.left)-maxDepth(root.right)>1||maxDepth(root.left)-maxDepth(root.right)<-1){
           return false;
       }
       return isBalanced(root.left)&&isBalanced(root.right);
    }


//判断二叉树是否镜像对称
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isMirror(A.left,B.right)&&isMirror(A.right,B.left);
    }


//层序遍历
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断树是否为完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if (root==null){
            return true;
        }

        boolean isSecondStep=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!isSecondStep) {
                if (cur.left != null&&cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.left==null&&cur.right!=null) {
                    return false;
                }else if(cur.left!=null&&cur.right==null){
                    isSecondStep=true;
                    queue.offer(cur.left);
                }else{
                    isSecondStep=true;
                }
            }else {
                //第二阶段:任何一个节点没有子树,一旦找到就返回false
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }


}
