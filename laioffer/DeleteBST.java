package laioffer;

import Tree.TreeNode;

public class DeleteBST {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
           if(root.left==null || root.right==null){
               return root.left==null? root.right: root.left;
           } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newNode = Deletesmallest(root.right);
                newNode.left = root.left;
                newNode.right = root.right;
                return newNode;
            }
        }
        if (key < root.val) {
            root.left = delete(root.left, key);

        } else if (key > root.val) {
            root.right = delete(root.right, key);
        }
        return root;
    }

    private TreeNode Deletesmallest(TreeNode cur) {
        while (cur.left.left != null) {
            cur = cur.left;
        }
        TreeNode newNode = cur.left;
        cur.left = cur.left.right;
        return newNode;
    }
}
