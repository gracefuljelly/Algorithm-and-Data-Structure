package Microsoft;
import java.util.*;

public class kclosest {

    public List<Integer> findClosestElements(int[] arr, int k, int x){

        Map<Integer, Integer> map = buildMap(arr,x);

       PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k,
               new Comparator<Map.Entry<Integer,Integer>>(){
           @Override
           public int compare(Map.Entry<Integer,Integer> t1, Map.Entry<Integer,Integer> t2) {
             return t1.getValue().compareTo(t2.getValue());
           }
       });
       
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           if(maxHeap.size()<k){
               maxHeap.offer(entry);
           } else if(entry.getValue()> maxHeap.peek().getValue()){
               maxHeap.poll();
               maxHeap.offer(entry);
           }
       }
       return heapToArray(maxHeap);
    }

    private List<Integer> heapToArray(PriorityQueue<Map.Entry<Integer, Integer>> maxHeap) {
        List<Integer> result = new ArrayList<>();
        for(int i= maxHeap.size()-1;i>=0; i--){
            result.add(maxHeap.poll().getKey());
        }
        Collections.sort(result);
        return result;
    }

    private Map<Integer,Integer> buildMap(int[] arr, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(i,Math.abs(arr[i]-target));
        }
        return map;
    }

    public static void main(String[] args) {

    }
}
