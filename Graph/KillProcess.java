package Graph;

import java.util.*;

/*Input:
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation:
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.*/
public  class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new LinkedList<>();
        Map<Integer,List<Integer>> processMap = new HashMap<>();
        for(int i=0; i<pid.size();i++){
            processMap.putIfAbsent(ppid.get(i),new ArrayList<>());
            //ppid.get(i) is pid.get(i)'s parent
            processMap.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(kill);
        while(queue.isEmpty()){
            int cur = queue.poll();
            ans.add(cur);
            if(processMap.containsKey(cur)){
                queue.addAll(processMap.get(cur));
            }
        }
        return ans;
    }
}
