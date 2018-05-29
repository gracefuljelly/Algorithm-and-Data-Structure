package laioffer;

import java.util.PriorityQueue;

public class MergeKArrays {
  /*  public int[] merge(int[][]arrayOfArrays){
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(20, new Comparator());
        int length=0;
        for(int i=0; i<arrayOfArrays.length;i++){
            int[] array = arrayOfArrays[i];
            length +=array.length;
            if(array.length==0){
                minHeap.offer(new Entry(i,0,array[0]));
            }
        }

        int[] result = new int[length];
        int cur=0;
        while(!minHeap.isEmpty()){
            Entry tmp=minHeap.poll();
            result[cur++] = tmp.key;

        }
    }

    private class Entry{}*/
}
