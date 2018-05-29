package laioffer;

import java.util.*;

public class kthsmallestsortedmatrix {

    public int kthSmallest(int[][]matrix, int k){
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(rows==0|| columns==0|| k==0){
            return 0;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if(c1.value==c2.value){
                    return 0;
                }
                return  c1.value < c2.value ? -1:1;
            }
        });

        Set<Cell>  visited = new HashSet<>();
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited.add(new Cell(0,0,matrix[0][0]));

        for(int i=0; i< k-1;i++){
            Cell cur= minHeap.poll();
            if(cur.row+1 < rows && !visited.contains(new Cell(cur.row+1,cur.column,matrix[cur.row+1][cur.column]))){
                minHeap.offer(new Cell(cur.row+1,cur.column,matrix[cur.row+1][cur.column]));
                visited.add(new Cell(cur.row+1,cur.column,matrix[cur.row+1][cur.column]));
            }
            if(cur.column+1 < columns && !visited.contains(new Cell(cur.row,cur.column+1,matrix[cur.row][cur.column+1]))){
                minHeap.offer(new Cell(cur.row,cur.column+1,matrix[cur.row][cur.column+1]));
                visited.add(new Cell(cur.row,cur.column+1,matrix[cur.row][cur.column+1]));
            }
        }
        return minHeap.peek().value;

    }

    private static  class Cell{
        int row;
        int column;
        int value;

        Cell(int row, int column, int value){
            this.row=row;
            this.column=column;
            this.value=value;
        }
    }



    public static void main(String[] args){
      int[][] input= new int[][]{{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
      kthsmallestsortedmatrix km = new kthsmallestsortedmatrix();
      int output = km.kthSmallest(input,6);//expected answer is 5
      System.out.println(output);
    }


}

