package laioffer.ArrayAndSortingAlgorithms;

public class MoveZerosToEndI {
    public int[] movezero(int[] array){
        if(array==null||array.length<=0){
            return array;
        }
        int leftBound=0;
        int rightBound=array.length-1;
        while(leftBound<=rightBound) {
            if (array[leftBound] != 0) {
                leftBound++;
            } else if (array[rightBound] == 0) {
                rightBound--;
            } else {
                swap(array, leftBound, rightBound);
                leftBound++;
                rightBound--;
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=array[left];
    }
    public static void main(String[] args) {
        int[] array={0,1,0,1,0,1};
        MoveZerosToEndI solution= new MoveZerosToEndI();
        solution.movezero(array);
        //System.out.println(solution.movezero(array));
    }
}


