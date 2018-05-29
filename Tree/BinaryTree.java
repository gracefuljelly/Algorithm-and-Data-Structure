package Tree;

public class BinaryTree {

    public boolean search(TreeNode root, int target){
        if(root==null) return false;
        if(root.val==target) {
            return true;
        } else if (root.val<target) {
            return search(root.left,target);
        }
        else {
            return search(root.right,target);
        }
    }

    public TreeNode insertR(TreeNode root, int target){
        TreeNode cur = new TreeNode(target);
        if(root==null){
            return cur;
        } else if (root.val<target){
            root.left=insertR(root.left,target);
        } else if(root.val>target){
            root.right = insertR(root.right,target);
        } else {
            root=cur;
        }
      return root;
    }

    public TreeNode insertI(TreeNode root, int target){
        TreeNode cur = new TreeNode(target);
        if(root==null){
            return cur;
        }
        while(root != null){
            if(target<root.val){
                if(root.left==null) {
                    root.left = cur;
                } else {
                    root=root.left;
                }
            } else {
                    if(root.right==null){
                        root.right = cur;
                    }else {
                        root=root.right;
                    }
                }
            }
         return root;
        }


    public boolean isBalanced(TreeNode root){
        if(root==null) return true;
        return getHeight(root)==-1?false:true;
    }
    private int getHeight(TreeNode root){
        if(root==null) return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(left==-1||right==-1) {
            return -1;
        }
        else if(Math.abs(left-right)>1) {
            return -1;
        } else{
            return Math.max(right,left)+1;
        }
    }

    public TreeNode delete(TreeNode root, int target){
        if(root==null) return root;
        if(target<root.val) {
            root.left= delete(root.left,target);
        }
        else if(target>root.val) {
            root.right= delete(root.right,target);
        } else {
            if(root.left==null) {
                return root.right;
            } else if(root.right==null){
                return root.left;
            } else {
                root.val=findMin(root.right);
                root.right= delete(root.right,root.val);
            }
        }
        return root;
    }
    private int findMin(TreeNode root){
        while(root.left!= null){
            root=root.left;
        }
        return root.val;
    }

    public TreeNode arrayToBST (int[] array){
        if(array==null||array.length==0) return null;
        if(array.length==1) return new TreeNode(array[0]);
        return helper(0, array.length-1,array);
    }
    private TreeNode helper(int left, int right, int[] array){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode cur = new TreeNode(array[mid]);
        cur.left=helper(left,mid-1,array);
        cur.right=helper(right, mid+1, array);
        return cur;
    }


}
