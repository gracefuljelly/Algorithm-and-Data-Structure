package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null) return 0;
        int sum=0;
        int level=1;
        Queue<NestedInteger> queue= new LinkedList<NestedInteger>(nestedList);
        int size=queue.size();
        while(!queue.isEmpty()){
            for(int i=0; i<size;i++){
               NestedInteger cur= queue.poll();
               if(cur.isInteger()){
                    sum+=cur.getInteger()*level;
               }else{
                   queue.addAll(cur.getList());
               }
            }
            level++;
        }
        return sum;
    }
}
