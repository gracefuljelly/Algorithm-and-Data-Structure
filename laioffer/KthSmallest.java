package laioffer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * Created by jieli on 7/31/2017.
 */
public class KthSmallest {

    public static int kthsmallest(int[] A , int[] B, int k){

        PriorityQueue<Cell> maxHeap = new PriorityQueue(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                int value1= A[c1.row]+B[c1.column];
                int value2= A[c2.row]+B[c2.column];
                if(value1 == value2){
                    return 0;
                }
                return value1 < value2 ? -1:1;
            }
        });

            maxHeap.offer(new Cell(0,0));
            Set<Integer> appeared = new HashSet<Integer>();
            appeared.add(A[0]+B[0]);

            for(int curr = 0; curr<k-1; curr++){
                Cell temp =maxHeap.poll();
                if(temp.row +1 < A.length && !appeared.contains(A[temp.row+1]+B[temp.column])){
                    appeared.add(A[temp.row+1]+B[temp.column]);
                    maxHeap.offer(new Cell(temp.row +1,temp.column));
                }

                if(temp.column +1 < B.length && !appeared.contains(A[temp.row]+B[temp.column+1])){
                    appeared.add(A[temp.row]+B[temp.column+1]);
                    maxHeap.offer(new Cell(temp.row ,temp.column+1));
                }

            }

            Cell res=maxHeap.poll();
            return A[res.row]+ B[res.column];
        }






    private static  class Cell{
        int row;
        int column;


        Cell(int row, int column){
            this.row=row; //i=0; i< M; i++
            this.column=column; // j=0; j<N; j++
        }
    }

}





