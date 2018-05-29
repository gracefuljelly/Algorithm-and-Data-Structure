package Tree;
import java.util.*;

public class TreeTraversal {
    //InOrder Traversal without parent pointer
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNodeInOrder(stack,root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            result.add(cur.val);
            firstNodeInOrder(stack,cur.right);
        }
        return result;
    }

    private static void firstNodeInOrder(Deque<TreeNode> stack, TreeNode node) {
        while(node != null){
            stack.push(node);
            node =node.left;
        }
    }

    //PreOrder Traversal without parent pointer
    public static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNodeInOrder(stack,root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur.right!=null)  firstNodeInOrder(stack,cur.right);
            if(cur.left!=null)  firstNodeInOrder(stack,cur.left);
            result.add(cur.val);
        }
        return result;
    }

    private static void firstNodePreOrder(Deque<TreeNode> stack, TreeNode node) {
            stack.push(node);
    }

    //PostOrder Traversal without parent pointer
    public static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNodePostOrder(stack,root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode cur=stack.peek();
            if(prev==null|| cur==prev.left||cur==prev.right){
            if(cur.left!=null)  {
                firstNodePostOrder(stack,cur.left);
            } else if(cur.right!=null) {
                firstNodePostOrder(stack,cur.right);
            } else {

                result.add(cur.val);
            }
            }
        }
        return result;
    }

    private static void firstNodePostOrder(Deque<TreeNode> stack, TreeNode node) {
        stack.push(node);
    }



    //InOrder Traversal with parent pointer
    public static TreeNode firstNodeInOrder(TreeNode root){
        if(root==null) return null;
        while(root.left!=null) root= root.left;
        return root;
    }

    public static TreeNode nextNodeInOrder(TreeNode cur) {
        if (cur == null) return null;
        if (cur.right != null) return firstNodeInOrder(cur.right);
        while (cur.parent != null && cur.parent.left != cur) {
            cur = cur.parent;
        }
        return cur.parent;
    }

    //PreOrder Traversal with parent pointer
    public static TreeNode firstNodePreOrder(TreeNode root){
        return root;
    }

    public static TreeNode nextNodePreOrder(TreeNode cur){
        if(cur.left != null){
            return firstNodePreOrder(cur.left);
        }
        if(cur.right != null){
            return firstNodePreOrder(cur.right);
        }
        while(cur.parent !=null && (cur.parent.right==cur|| cur.parent.right== null)){
            cur=cur.parent;
        }
        if(cur.parent== null) return null;
        return firstNodePreOrder(cur.parent.right);
    }

    //PostOrder Traversal with parent pointer
    public static TreeNode firstNodePostOrder(TreeNode root){
        while(root.left !=null || root.right !=null){
            if(root.left!= null){
                root=root.left;
            }else {
                root=root.right;
            }
        }
        return root;
    }

    public static TreeNode nextNodePostOrder(TreeNode cur){
        if(cur.parent==null){
            return null;
        }
        if(cur.parent.right == cur){
            return cur.parent;
        }
        return cur.parent.right == null? cur.parent: firstNodePostOrder(cur.parent.right);
    }

    public static void main(String[] args){
        TreeNode root= new TreeNode(29);
        TreeNode cur=firstNodePreOrder(root);
        while(cur != null){
            System.out.print(cur.val);
            cur=nextNodePreOrder(cur);
        }
    }

}
