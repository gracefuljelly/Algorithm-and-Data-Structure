package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class IncreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> holder= new ArrayList<Integer>();

        dfs(nums,res,holder,0);
        List result= new ArrayList(res);
        return result;
    }

    private void dfs(int[] nums,Set<List<Integer>> res, List<Integer>holder, int index){
        if(holder.size()>=2){
            res.add(new ArrayList(holder));
        }
        for(int i=index; i<nums.length;i++){
            if(holder.size()==0||holder.get(holder.size()-1)<=nums[i]){
                holder.add(nums[i]);
                dfs(nums,res,holder,index+1);
                holder.remove(holder.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={4,6,7,7};
        IncreasingSubsequence is= new IncreasingSubsequence();
        is.findSubsequences(nums);
    }
}
