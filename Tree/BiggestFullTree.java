package Tree;

public class BiggestFullTree {
  /*
    case 1:  以该node为root的tree也是一颗full tree，都可以contribute
            isperfect(leftsubtree) && isperfect(rightsubtree)
            size = left sub tree total + right sub tree total +1

    case 2: 以该node为root的tree不是一颗full tree， contribute 左边的值或右边的值或者0
  */
  public static class ReturnType{
     boolean isPerfect;
     int size;

     ReturnType(){
         isPerfect=false;
         size=0;
     }
  }

  public int getbiggestfulltree(TreeNode root){
      return getbiggestfulltreehelper(root).size;
  }


  private ReturnType getbiggestfulltreehelper(TreeNode root){
         ReturnType rt= new ReturnType();

         if(root == null){
            rt.isPerfect = true;
            return rt;
         }

         ReturnType leftrt = getbiggestfulltreehelper(root.left);
         ReturnType rightrt = getbiggestfulltreehelper(root.right);

         if(leftrt.isPerfect && rightrt.isPerfect ){
            rt.size=leftrt.size+rightrt.size+1;
            rt.isPerfect=true;
            return rt;
         }
         rt.size = Math.max(leftrt.size,rightrt.size);
         return rt;
         }





}
