package Tree;
/*      1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       List<TreeNode> res = new LinkedList<>();
       Map<String,Integer> map = new HashMap<>();
       postOrder(root,map,res);
       return res;
    }

    private String postOrder(TreeNode root, Map<String,Integer> map, List<TreeNode> res) {
        if(root==null){
          return "#";
        }
        String serial=root.val+postOrder(root.left,map,res)+postOrder(root.right,map,res);
        if(map.getOrDefault(serial,0)==1){
            res.add(root);
        }
        map.put(serial,map.getOrDefault(serial,0)+1);
        return serial;
    }
}
