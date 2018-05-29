package Tree;

public class CountCompleteTree {




    public int sum(TreeNode root){
        int res=0;
        if(root==null)return 0;
        int leftLen= len(root.left);
        int rightLen= len(root.right);
        if(leftLen==rightLen){
            res= (1<<leftLen) + sum(root.right);
        }else if (leftLen==rightLen+1){
            res= (1<<rightLen) + sum(root.left);
        }
        return res;
    }

    private int len(TreeNode root) {
        int res=0;
        while(root!=null){
            res++;
            root=root.left;
        }
        return res;
    }

    public int sum2(TreeNode root){
       int res=0;
       while(root!=null){
          int leftLen=len(root.left);
          int rightLen=len(root.right);
          //case 1: left sub tree is a perfect tree and right sub tree is a complete tree
          if(leftLen==rightLen){
             res += (1<<leftLen);
             root=root.right;
             //case 2: right sub tree is a perfect tree and right sub tree is a complete tree
          }else if(leftLen==rightLen+1){
              res +=(1<<rightLen);
              root=root.left;
          }
       }
       return res;
    }

}
