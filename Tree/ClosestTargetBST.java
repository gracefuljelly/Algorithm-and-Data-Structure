package Tree;
/*
* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
* 1. compare with root.val: if >root.val start to traverse right subtree else traverse left subtree
* 2. get the new closest value from the subtree and then compare with the root
*
* */
public class ClosestTargetBST {
    public int closestValue(TreeNode root, double target){
        int a=root.val;
       TreeNode candidate= root.val<target ? root.right :root.left;
       if(candidate==null) return a;
        int b=closestValue(candidate,target);
        return Math.abs(b-target)<Math.abs(a-target) ? b:a;
    }

    public int IclosestValue(TreeNode root, double target){
       int a = root.val;
       while(root!=null){
           if(Math.abs(root.val-target)<Math.abs(a-target)){
               a=root.val;
           }
           if(target<root.val){
               root=root.left;
           }else{
               root=root.right;
           }
       }
       return a;
    }
}
